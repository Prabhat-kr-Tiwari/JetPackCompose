package com.prabhat.Introduction

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.prabhat.Introduction.ui.theme.IntroductionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IntroductionTheme {

                firstUI()
            }
        }
    }

    @Preview
    @Composable
    fun firstUI() {


        /*Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.5f)
                .background(MaterialTheme.colorScheme.primaryContainer )
                .padding(

                    vertical = 10.dp

                *//*start = 40.dp, top = 40.dp*//*)

            ,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Button(onClick = { *//*TODO*//* }) {

                Text(text = "Button 1")
            }

            Button(onClick = { *//*TODO*//* }) {
                Text(text = "Button 2")
            }
        }*/

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.5f)

                .background(MaterialTheme.colorScheme.secondary)

                .padding(vertical = 40.dp)
                .clip(RoundedCornerShape(20.dp))
                .alpha(.8f)
                .border(12.dp, Color.Green)
                .padding(10.dp)
                .border(12.dp, Color.Yellow)
                .clickable { }
                .verticalScroll(rememberScrollState())
                .background(MaterialTheme.colorScheme.primaryContainer)
        ) {

            Button(
                onClick = { },
//                modifier = Modifier.offset(10.dp)
                modifier = Modifier.padding(start = 20.dp)
            ) {

                Text(text = "Button 1")
            }
            //spacer
            Spacer(modifier = Modifier.height(40.dp))

            Button(onClick = { }) {
                Text(text = "Button 2")
            }

            Button(
                onClick = { },
//                modifier = Modifier.offset(10.dp)
                modifier = Modifier.padding(start = 20.dp)
            ) {

                Text(text = "Button 1")
            }

            Button(onClick = { }) {
                Text(text = "Button 2")
            }
            Button(
                onClick = { },
//                modifier = Modifier.offset(10.dp)
                modifier = Modifier.padding(start = 20.dp)
            ) {

                Text(text = "Button 1")
            }

            Button(onClick = { }) {
                Text(text = "Button 2")
            }

            Button(
                onClick = { },
//                modifier = Modifier.offset(10.dp)
                modifier = Modifier.padding(start = 20.dp)
            ) {

                Text(text = "Button 1")
            }

            Button(onClick = { }) {
                Text(text = "Button 2")
            }
            Button(
                onClick = { },
//                modifier = Modifier.offset(10.dp)
                modifier = Modifier.padding(start = 20.dp)
            ) {

                Text(text = "Button 1")
            }

            Button(onClick = { }) {
                Text(text = "Button 2")
            }
        }
    }

}

