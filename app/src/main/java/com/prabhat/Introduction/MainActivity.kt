package com.prabhat.Introduction

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text2.BasicTextField2
import androidx.compose.foundation.text2.input.TextFieldLineLimits
import androidx.compose.foundation.text2.input.rememberTextFieldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.rounded.ImageNotSupported
import androidx.compose.material3.CircularProgressIndicator
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
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.prabhat.Introduction.ui.theme.IntroductionTheme
import com.prabhat.Introduction.ui.theme.font

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IntroductionTheme {

//                Screen()
//                TextScreen()
                ImageScreen()
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
                        if (basicTextInput.isNotEmpty()) {

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

            val textState = rememberTextFieldState()
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
                        if (textState.text.isNotEmpty()) {

                            Spacer(modifier = Modifier.width(8.dp))

                            Icon(
                                modifier = Modifier.clickable {
                                    textState.edit {
                                        this.replace(0, textState.text.length, "")
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


    @Preview
    @Composable
    fun TextScreen() {


        Column(

            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.surface),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            Spacer(modifier = Modifier.height(200.dp))
            val shadowOffset = Offset(5f, 10f)
            Text(
//                text = "Some Text is written here what are you doing here hello ",
                text = buildAnnotatedString {
                    append("Text is")
                    withStyle(
                        SpanStyle
                            (
                            color = Color.Red, textDecoration = TextDecoration.LineThrough,
                            fontSize = 30.sp
                        )

                    ) {
                        append("Here")
                    }

                    withStyle(
                        SpanStyle(
                            color = Color.Yellow
                        )
                    ) {

                        append("Here")
                    }
                },
                color = MaterialTheme.colorScheme.primary,
                fontFamily = font,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 22.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontStyle = FontStyle.Italic,
                textDecoration = TextDecoration.Underline,

                style = TextStyle(
                    shadow = Shadow(color = Color.Red, offset = shadowOffset, blurRadius = 9f)
                )


            )
        }
    }

    @Preview(showBackground = true, showSystemUi = true)
    @Composable
    fun ImageScreen() {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 10.dp),


            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(

                modifier = Modifier.clip(RoundedCornerShape(20.dp)),
                painter = painterResource(R.drawable.camera),

                contentDescription = null
            )

            Spacer(modifier = Modifier.height(10.dp))

            val imageUrl =
                "https://letsenhance.io/static/73136da51c245e80edc6ccfe44888a99/1015f/MainBefore.jpg"

            val model =
                ImageRequest.Builder(LocalContext.current).data(imageUrl).size(Size.ORIGINAL)
                    .build()
            AsyncImage(
                modifier = Modifier.clip(RoundedCornerShape(20.dp)),
                model = model, contentDescription = null

            )

            Spacer(modifier = Modifier.height(10.dp))
            val imageState = rememberAsyncImagePainter(model = model).state

            Box(modifier =
            Modifier
                .size(300.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(MaterialTheme.colorScheme.secondaryContainer)


            ) {


                when(imageState){

                    is AsyncImagePainter.State.Loading -> {
                        CircularProgressIndicator(
                            modifier = Modifier
                                .size(100.dp)
                                .align(Alignment.Center),
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                    is AsyncImagePainter.State.Success -> {
                        Image(
                            modifier = Modifier.fillMaxSize()

                            ,
                            painter = imageState.painter,
                            contentDescription = null,
                            contentScale = ContentScale.Crop
                        )
                    }
                   /* AsyncImagePainter.State.Empty -> TODO()
                    is AsyncImagePainter.State.Error -> TODO()*/
                    else->{
                        Icon(
                            modifier = Modifier
                                .size(100.dp)
                                .align(Alignment.Center),
                            imageVector = Icons.Rounded.ImageNotSupported, contentDescription = null)

                    }

                }



               /* if (imageState is AsyncImagePainter.State.Success) {

                    Image(
                        modifier = Modifier.fillMaxSize()

                            ,
                        painter = imageState.painter,
                        contentDescription = null,
                        contentScale = ContentScale.Crop
                    )
                }
                if (imageState is AsyncImagePainter.State.Loading) {

                    CircularProgressIndicator(
                        modifier = Modifier
                            .size(100.dp)
                            .align(Alignment.Center),
                        color = MaterialTheme.colorScheme.primary
                    )
                }
                if (imageState is AsyncImagePainter.State.Error) {

                    Icon(
                        modifier = Modifier
                            .size(100.dp)
                            .align(Alignment.Center),
                        imageVector = Icons.Rounded.ImageNotSupported, contentDescription = null)
                }*/


            }

        }

    }


}



