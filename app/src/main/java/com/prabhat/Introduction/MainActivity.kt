package com.prabhat.Introduction

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text2.BasicTextField2
import androidx.compose.foundation.text2.input.TextFieldLineLimits
import androidx.compose.foundation.text2.input.TextFieldState
import androidx.compose.foundation.text2.input.rememberTextFieldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.prabhat.Introduction.ui.theme.IntroductionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IntroductionTheme {

                Screen()
            }
        }
    }

    @OptIn(ExperimentalFoundationApi::class)
    @Preview
    @Composable
    fun Screen() {


        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.surface),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            var textInput = remember {
                mutableStateOf("")
            }

            TextField(value = textInput.value,
                onValueChange = { newText ->
                    textInput.value = newText
                }, label = {
                    Text(text = "Type")
                })


            OutlinedTextField(
                modifier = Modifier.padding(top = 20.dp),
                value = textInput.value,
                onValueChange = { newText ->
                    textInput.value = newText
                },
                label = {
                    Text(text = "Type")
                },
                textStyle = TextStyle(
                    color = Color.Red, fontStyle = FontStyle.Italic, fontSize = 18.sp
                ),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,

                        contentDescription = null
                    )
                },
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.Clear,
                        contentDescription = null
                    )
                }
            )

            var basicTextInput by remember {
                mutableStateOf("")
            }

            BasicTextField(
                value = basicTextInput,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp)
                    .padding(horizontal = 16.dp)
                    .clip(RoundedCornerShape(50.dp))
                    .background(MaterialTheme.colorScheme.primaryContainer)
                    .padding(16.dp),
                onValueChange = {
                    basicTextInput = it
                },
                cursorBrush = SolidColor(MaterialTheme.colorScheme.primary),
                maxLines = 1,
                singleLine = true,
                textStyle = TextStyle(
                    color = MaterialTheme.colorScheme.onBackground,
                    fontSize = 18.sp
                ),
                decorationBox = { innerTextField ->
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically

                    ) {

                        Icon(imageVector = Icons.Default.Search, contentDescription = null)
                        Spacer(modifier = Modifier.width(8.dp))
                        Box(modifier = Modifier.weight(1f)) {

                            if (basicTextInput.isEmpty()) {
                                Text(
                                    text = "Search here",
                                    color = MaterialTheme.colorScheme.onBackground.copy(0.5f)
                                )

                            }

                            innerTextField()

                        }
                        if(basicTextInput.isNotEmpty()){

                            Spacer(modifier = Modifier.width(8.dp))

                            Icon(
                                modifier = Modifier.clickable {
                                    basicTextInput = ""
                                },
                                imageVector = Icons.Default.Clear, contentDescription = null
                            )
                        }



                    }

                }

            )

           val textState= rememberTextFieldState()
            BasicTextField2(

                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp)
                    .padding(horizontal = 16.dp)
                    .clip(RoundedCornerShape(50.dp))
                    .background(MaterialTheme.colorScheme.primaryContainer)
                    .padding(16.dp),
               state = textState,
                cursorBrush = SolidColor(MaterialTheme.colorScheme.primary),
                lineLimits = TextFieldLineLimits.SingleLine,
                textStyle = TextStyle(
                    color = MaterialTheme.colorScheme.onBackground,
                    fontSize = 18.sp
                ),
                decorator = { innerTextField ->
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically

                    ) {

                        Icon(imageVector = Icons.Default.Search, contentDescription = null)
                        Spacer(modifier = Modifier.width(8.dp))
                        Box(modifier = Modifier.weight(1f)) {

                            if (textState.text.isEmpty()) {
                                Text(
                                    text = "Search here",
                                    color = MaterialTheme.colorScheme.onBackground.copy(0.5f)
                                )

                            }

                            innerTextField()

                        }
                        if(textState.text.isNotEmpty()){

                            Spacer(modifier = Modifier.width(8.dp))

                            Icon(
                                modifier = Modifier.clickable {
                                    textState.edit {
                                        this.replace(0,textState.text.length,"")
                                    }
                                },
                                imageVector = Icons.Default.Clear, contentDescription = null
                            )
                        }



                    }

                }

            )
        }
    }

}

