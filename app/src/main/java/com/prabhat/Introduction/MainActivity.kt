package com.prabhat.Introduction

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Category
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Category
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.ImageVector
import com.prabhat.Introduction.ui.theme.IntroductionTheme

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IntroductionTheme {

                var selectedState by remember {
                    mutableIntStateOf(0)
                }
                Scaffold(
                    bottomBar = {
                        NavigationBar {

                            bottomNavItems.forEachIndexed { index, bottomNavItem ->
                                NavigationBarItem(
                                    selected = index == selectedState,
                                    onClick = {
                                        selectedState = index
//                                              navController.navigate(bottomNavItem.route)
                                    },
                                    icon = {

                                        BadgedBox(badge = {

                                            if (bottomNavItem.badges != 0) {
                                                Badge {
                                                    Text(text = bottomNavItem.badges.toString())
                                                }

                                            } else if (bottomNavItem.hasNews) {

                                                Badge()

                                            }
                                        }) {


                                            Icon(
                                                imageVector =
                                                if (index == selectedState) {
                                                    bottomNavItem.selectedIcon
                                                }else{
                                                     bottomNavItem.unSelectedIcon
                                                     },
                                                contentDescription =bottomNavItem.title


                                            )
                                        }


                                    },
                                    label = {
                                        Text(text = bottomNavItem.title)
                                    }
                                )
                            }
                        }
                    },
                    floatingActionButton = {

                        FloatingActionButton(onClick = { /*TODO*/ }) {

                        }
                    }

                ) {

                    val padding=it

                }
            }
        }
    }


}

val bottomNavItems = listOf(
    BottomNavItem(
        title = "Home",
        route = "home",
        selectedIcon = Icons.Filled.Home,
        unSelectedIcon = Icons.Outlined.Home,
        hasNews = false,
        badges = 0

    ),

    BottomNavItem(
        title = "Posts",
        route = "posts",
        selectedIcon = Icons.Filled.Category,
        unSelectedIcon = Icons.Outlined.Category,
        hasNews = false,
        badges = 0

    ),
    BottomNavItem(
        title = "Notifications",
        route = "notifications",
        selectedIcon = Icons.Filled.Notifications,
        unSelectedIcon = Icons.Outlined.Notifications,
        hasNews = false,
        badges = 5

    ),
    BottomNavItem(
        title = "Profile",
        route = "profile",
        selectedIcon = Icons.Filled.AccountCircle,
        unSelectedIcon = Icons.Outlined.AccountCircle,
        hasNews = true,
        badges = 0

    ),
)

data class BottomNavItem(
    val title: String,
    val route: String,
    val selectedIcon: ImageVector,
    val unSelectedIcon: ImageVector,
    val hasNews: Boolean,
    val badges: Int
)





