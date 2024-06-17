package com.example.socialdesign.ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.socialdesign.Models.Story
import com.example.socialdesign.R
import com.example.socialdesign.ui.theme.Purple40
import com.example.socialdesign.ui.theme.ShadowColor
import com.example.socialdesign.ui.theme.White

@Composable
fun StoriesView(stories: ArrayList<Story>, navController: NavController) {
    LazyRow {
        item {
            MyStoryView()
        }
        items(stories.size) {
            StoryItem(stories[it], navController )
        }
    }
}

@Composable
fun MyStoryView() {
    val story = Story(0,"Zoya", "https://i.postimg.cc/YC8Rk4LW/IMG-20240325-113538.jpg", false)
    Card(
        shape = RoundedCornerShape(15.dp),
        modifier = Modifier
            .padding(6.dp)
            .size(70.dp, 100.dp),
        border = BorderStroke(2.dp, Purple40)
    ) {
        Box(
            modifier = Modifier
                .width(70.dp)
                .height(100.dp)
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(story.image)
                    .crossfade(true)
                    .build(),
                contentDescription = story.userName,
                contentScale = ContentScale.Crop
            )
            Box(
                Modifier
                    .fillMaxSize()
                    .background(ShadowColor)
            )
            Icon(
                painter = painterResource(id = R.drawable.baseline_add_circle_outline_24),
                contentDescription = story.userName,
                tint = Color.White,
                modifier = Modifier
                    .size(28.dp)
                    .align(Alignment.BottomEnd)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StoryItem(story: Story,navController:NavController) {
    Card(
        shape = RoundedCornerShape(15.dp),
        modifier = Modifier
            .padding(6.dp)
            .size(70.dp, 100.dp),
        border = BorderStroke(2.dp, if (story.isLive) Color.Red else Purple40),
onClick = {
    navController.navigate("storyShow/${story.id}")
}
        ) {
        Box(
            modifier = Modifier
                .width(70.dp)
                .height(100.dp)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(story.image)
                    .crossfade(true)
                    .build(),
                contentDescription = story.userName,
                contentScale = ContentScale.Crop
            )

            Box(
                Modifier
                    .fillMaxSize()
                    .background(ShadowColor)
                    .align(Alignment.BottomCenter)
            )
                Text(
                    text = story.userName,
                    color = Color.White,
                    fontSize = 10.sp,
                    textAlign = TextAlign.Center,
                   // modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                if (story.isLive) {
                    Text(
                        text = "Live",
                        color = White,
                        fontSize = 8.sp,
                        modifier = Modifier
                            .background(Color.Red)
                            .padding(3.dp, 1.dp)
                            .align(Alignment.BottomCenter),


                    )

            }

        }
    }
}


