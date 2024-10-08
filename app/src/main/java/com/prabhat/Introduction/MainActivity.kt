package com.prabhat.Introduction

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.unit.dp
import com.prabhat.Introduction.ui.theme.IntroductionTheme

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IntroductionTheme {

                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    CanvasScreen()
                }

            }
        }
    }


}

@Composable
fun CanvasScreen() {

    androidx.compose.foundation.Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .height(500.dp)
            .background(Color.Blue)

    ) {


        val width=size.width
        val height=size.height

        val recWidth=60.dp.toPx()
        val recHeight=60.dp.toPx()
        drawRect(
            color = Color.Yellow
            ,size= Size(recWidth,recHeight)
            , topLeft = Offset(
                x=(width-recWidth)/2,
                y=(height-recHeight)/2
            )
        )

        drawCircle(
            brush = Brush.verticalGradient(listOf(Color.Green,Color.White))
            , center = Offset(
                x=width/2,
                y=60.dp.toPx()+30.dp.toPx()
            ),
            radius = 60.dp.toPx()
        )

        val trianglePath= Path().apply{

            moveTo(x=width/2,y=height-150.dp.toPx())


        }
    }


}







