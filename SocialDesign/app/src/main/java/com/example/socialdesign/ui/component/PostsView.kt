package com.example.socialdesign.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Send
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.socialdesign.Models.Post

@Composable
fun PostsView(posts: ArrayList<Post>) {
    LazyColumn {
        items(posts.size) {
            PostItem(posts[it])

        }
    }
}

@Composable
fun PostItem(post: Post) {
    var liked by remember { mutableStateOf(false) }
    Column(Modifier.padding(10.dp)) {
        Row {
            Card(
                modifier = Modifier.size(40.dp),
                shape = RoundedCornerShape(50.dp),
                elevation = CardDefaults.cardElevation(10.dp)
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(post.user.image)
                        .crossfade(true)
                        .build(),
                    contentDescription = post.user.userName,
                    contentScale = ContentScale.Crop
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
            Column(Modifier.weight(1f)) {
                Text(
                    text = post.user.fullName,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                )
                Spacer(modifier = Modifier.height(7.dp))
                Text(
                    text = post.location,
                    fontSize = 12.sp,
                    color = Color.LightGray,
                )
            }

            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    Icons.Filled.MoreVert,
                    contentDescription = null,
                    modifier = Modifier.size(26.dp)
                )

            }
        }
        Card(
            modifier = Modifier.fillMaxSize(),
            shape = RoundedCornerShape(18.dp),
            elevation = CardDefaults.cardElevation(8.dp)
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(post.image)
                    .crossfade(true)
                    .build(),
                contentDescription = post.user.userName,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }
        Spacer(modifier = Modifier.height(6.dp))
        Row {
            IconButton(onClick = { liked = !liked }) {
                Icon(
                    if (liked) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
                    contentDescription = "",
                    Modifier.size(26.dp),
                    tint = if (liked) Color.Red else Color.Gray
                )
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    Icons.Outlined.Send, contentDescription = "",
                    Modifier.size(26.dp),
                    tint = Color.Gray
                )
            }

        }
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            text = post.caption,
            fontSize = 12.sp,
            textAlign = TextAlign.Justify,
            color = Color.Gray
        )

    }

}