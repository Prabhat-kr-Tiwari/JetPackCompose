package com.prabhat.Introduction.handlingSideEffects

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable

fun EffectHandler(myViewModel: MyViewModel = viewModel()) {
    val nameState by myViewModel.nameState.collectAsState()
//    WITHOUT side effects
     LaunchedEffect(key1 = true) {


         myViewModel.loadName()
     }



    //myViewModel.loadName()

    Column(horizontalAlignment = Alignment.CenterHorizontally) {

        Text(text = nameState)
        Button(onClick = {
            myViewModel.addToName()
        }) {
            Text(text = "change name")

        }

    }

}
