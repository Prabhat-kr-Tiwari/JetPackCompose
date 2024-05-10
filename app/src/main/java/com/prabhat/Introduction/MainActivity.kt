package com.prabhat.Introduction

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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
    fun firstUI(){

        /*Column(

            modifier = Modifier.fillMaxSize()
                .background(MaterialTheme.colorScheme.primaryContainer),
            verticalArrangement =Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
//            horizontalAlignment = Alignment.End
        ) {
            Button(onClick = {

            }) {

                Text(text = "click Me 1")
            }

            Button(onClick = {

            }) {
                Text(text = "click Me 2")
            }
        }*/


   /*     Row(

//            modifier = Modifier.fillMaxSize()
            modifier = Modifier.fillMaxWidth().fillMaxHeight(0.4f)
                .background(MaterialTheme.colorScheme.primaryContainer),
            verticalAlignment =Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
//            horizontalAlignment = Alignment.End
        ) {
            Button(onClick = {

            }) {

                Text(text = "click Me 1")
            }

            Button(onClick = {

            }) {
                Text(text = "click Me 2")
            }
           Button(onClick = {

            }) {
                Text(text = "click Me 3")
            }
        }*/

        //Box
        Box(

           modifier = Modifier.fillMaxSize()
               .background(MaterialTheme.colorScheme.primaryContainer),

       ) {
           Button(
               modifier = Modifier.align(Alignment.BottomCenter),
               onClick = {

           }) {

               Text(text = "click Me 1")
           }

           Button(onClick = {

           }) {
               Text(text = "click Me 2")
           }

            Button(

                modifier = Modifier.align(Alignment.TopCenter),
                onClick = {

            }) {
                Text(text = "click Me 3")
            }
       }


    }

}

