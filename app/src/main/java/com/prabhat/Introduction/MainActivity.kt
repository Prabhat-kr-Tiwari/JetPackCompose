package com.prabhat.Introduction

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
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

                    var isVisible by remember {

                        mutableStateOf(false)
                    }

                    /* var size by remember {

                         mutableStateOf(20.dp)
                     }*/
                    /*val size by animateDpAsState(
                        targetValue = if (isVisible) 300.dp else 20.dp,
                        label = "size",
                        animationSpec = tween(
                            delayMillis = 500,
                            durationMillis = 5000,
                            easing = FastOutSlowInEasing
                        )
                    )*/
                    /* val color by animateColorAsState(
                         targetValue = if (isVisible) Color.Blue else Color.Red,
                         label = "color",
                         animationSpec = tween(
                             delayMillis = 500,
                             durationMillis = 5000,
                             easing = FastOutSlowInEasing
                         )
                     )*/

                    //infinite animation
                   /* val transition = rememberInfiniteTransition(label = "infinite animation")
                    val color by transition.animateColor(
                        initialValue = Color.Magenta,
                        targetValue = Color.Yellow,
                        animationSpec = infiniteRepeatable(tween(3000)),
                        label = "infinite animation"
                    )*/

                    //change shape
                    val corner by animateDpAsState(targetValue = if(isVisible) 300.dp else 20.dp,
                        label = ""
                    )

                    Spacer(modifier = Modifier.height(59.dp))

                    Button(onClick = {
                        isVisible = !isVisible
//                        size= 300.dp
                    }

                    ) {

                        Text(text = "Click")

                    }
                    Spacer(modifier = Modifier.height(59.dp))


                    Column(
                        modifier = Modifier
                            /*size(300.dp)*/

                            .size(300.dp)
//                            .background(MaterialTheme.colorScheme.primary)
                             .clip(RoundedCornerShape(corner))
                            .background(MaterialTheme.colorScheme.primary)
                            .padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        /*if (isVisible) {


                            Box(
                                modifier = Modifier
                                    .size(200.dp)
                                    .background(Color.Black)
                            ) {

                            }
                        }*/

                        /*AnimatedVisibility(
                            visible = isVisible,
                            enter=slideInHorizontally()+fadeIn(),
                            exit = slideOutHorizontally()+ fadeOut()
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(200.dp)
                                    .background(Color.Black)
                            ) {

                            }

                        }*/

                        //Animating the size

                    }
                }

            }
        }
    }


}







