package com.example.socialdesign.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.socialdesign.Data.MockData
import com.example.socialdesign.Models.Story

@Composable
fun StoryShowScreen(id:Int) {
    val story= MockData.stories.find{x -> x.id==id}
    StoryView(story!!)
}

@Composable
fun StoryView(story: Story) {
    Card(
        modifier = Modifier.fillMaxSize(),
        shape = RoundedCornerShape(0.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(story.image)
                    .crossfade(true)
                    .build(),
                contentDescription = story.userName,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }

    }
}


