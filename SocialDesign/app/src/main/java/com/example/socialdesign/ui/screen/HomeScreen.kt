package com.example.socialdesign.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.socialdesign.Data.MockData
import com.example.socialdesign.ui.component.PostsView
import com.example.socialdesign.ui.component.StoriesView

@Preview
@Composable
fun HomeScreen(navController: NavController) {
    Column{
        StoriesView(MockData.stories, navController)
        Spacer(modifier = Modifier.height(7.dp))
        Divider(color = Color.LightGray, thickness = 1.dp, modifier = Modifier.padding(15.dp, 0.dp))
        Spacer(modifier = Modifier.height(7.dp))
        PostsView(MockData.posts)
    }
}