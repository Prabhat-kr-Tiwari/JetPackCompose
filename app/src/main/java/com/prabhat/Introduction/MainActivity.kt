package com.prabhat.Introduction

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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

    @Preview
    @Composable
    fun Screen() {


        Column(
            modifier = Modifier.fillMaxSize(),

            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            val textVisibilityState = remember {
                mutableStateOf(true)
            }

            /*if (textVisibilityState.value) {
                Text(text = "Text visibile")

            }*/

            /*Text(
                modifier = Modifier.alpha(if (textVisibilityState.value) 1f else 0.3f),
                text = "Text visibile"
            )*/

            val text=if(textVisibilityState.value) "Visible Text " else "Note visible Text"


            Text(text = text, modifier = Modifier.alpha(

                if(textVisibilityState.value) 1f else 0.2f
            ))

            Spacer(modifier = Modifier.height(20.dp))

            Button(onClick = {

                textVisibilityState.value = !textVisibilityState.value

            }) {

                Text(text = "Change text  visibility")

            }
        }

    }

}

