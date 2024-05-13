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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.prabhat.Introduction.ui.theme.IntroductionTheme

class MainActivity : ComponentActivity() {

    companion object{
        val items= listOf(

            Item("Item 1",R.drawable.camera),
            Item("Item 2",R.drawable.avatar),
            Item("Item 3",R.drawable.rose),
            Item("Item 4",R.drawable.camera),
            Item("Item 5",R.drawable.avatar),
            Item("Item 6",R.drawable.rose),
            Item("Item 7",R.drawable.camera),
            Item("Item 8",R.drawable.avatar),
            Item("Item 9",R.drawable.rose),

            )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IntroductionTheme {

                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background) {

                    val navHostController= rememberNavController()
                    NavHost(navController = navHostController, startDestination = "home_screen") {

                        composable("home_screen"){
                            HomeScreen(navHostController = navHostController)
                        }

                        composable("lazy_row_screen"){
                            LazyRowScreen()
                        }

                        composable("lazy_column_screen"){
                            LazyColumnScreen()
                        }

                        composable("lazy_grid_screen"){
                            LazyGridScreen()
                        }

                    }


                }
            }
        }
    }


}

@Composable
fun HomeScreen(navHostController: NavHostController) {

    Column(
        modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Button(onClick = { navHostController.navigate("lazy_row_screen") }) {

            Text(text = "Lazy Row")

        }
        Spacer(modifier = Modifier.height(30.dp))
        Button(onClick = { navHostController.navigate("lazy_column_screen") }) {

            Text(text = "Lazy Column")

        }
        Spacer(modifier = Modifier.height(30.dp))
        Button(onClick = { navHostController.navigate("lazy_grid_screen") }) {

            Text(text = "Lazy Grid")

        }
        Spacer(modifier = Modifier.height(30.dp))
    }

}



