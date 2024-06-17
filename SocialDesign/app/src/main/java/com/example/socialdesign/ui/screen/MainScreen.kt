package com.example.socialdesign.ui.screen

import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.socialdesign.ui.component.BottomBarView
import com.example.socialdesign.ui.component.TopBarView

@Preview
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    var fullScreen by remember { mutableStateOf(false) }
    Scaffold(
        topBar = {
            if (!fullScreen) TopBarView()
        },
        bottomBar = {
            if (!fullScreen) BottomBarView(navController)
        },

        ) { it ->

        NavHost(
            modifier = Modifier.padding(it),
            startDestination = "home",
            navController = navController,
        ) {
            composable("home") {
                fullScreen = false
                HomeScreen(navController)
            }
            composable("search") {
                fullScreen = false
                SearchScreen()
            }
            composable("add") {
                fullScreen = false
                AddPostScreen()
            }
            composable("activities") {
                fullScreen = false
                ActivitiesScreen()
            }
            composable("profile") {
                fullScreen = false
                ProfileScreen()
            }
            composable(
                "storyShow/{id}",
                arguments = listOf(navArgument("id") { type = NavType.IntType })
            ) {entry ->
                fullScreen = true
                val id =entry.arguments?.getInt("id") ?: 0
                //Log.d("StoryShowScreen", "Navigated with id: $id")
                StoryShowScreen(id)
            }
        }
    }
}

