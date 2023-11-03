package com.example.unsplashclient.presentation.search_photos.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.unsplashclient.domain.model.Photo
import com.example.unsplashclient.presentation.ui.theme.UnsplashClientTheme

@Composable
fun PhotoThumbnail(
  photo: Photo,
  onClick: (Photo) -> Unit,
) {
  Box(
    modifier = Modifier
      .background(Color.Black)
      .heightIn(min = 200.dp)
      .clickable { onClick(photo) },
    contentAlignment = Alignment.BottomCenter,
  ) {
    CircularProgressIndicator(
      modifier = Modifier.align(Alignment.Center),
    )
    AsyncImage(
      model = photo.imageUrl,
      contentDescription = photo.description,
      modifier = Modifier.fillMaxWidth(),
    )
    Row(
      modifier = Modifier
        .fillMaxWidth()
        .background(Color.Black.copy(alpha = 0.5f))
        .padding(10.dp),
    ) {
      Column(modifier = Modifier.fillMaxWidth(0.8f)) {
        Text(
          text = photo.description ?: "No description",
          color = Color.White,
          style = MaterialTheme.typography.h6,
        )
        Text(
          text = photo.photographer ?: "Unknown photographer",
          color = Color.White,
          style = MaterialTheme.typography.body2,
        )
      }
      Spacer(modifier = Modifier.weight(1f))
      Icon(
        imageVector = Icons.Default.Favorite,
        contentDescription = "likes",
        tint = Color.Magenta,
      )
      Spacer(modifier = Modifier.width(5.dp))
      Text(
        text = photo.likes.toString(),
        color = Color.White,
        style = MaterialTheme.typography.body1,
      )
    }
  }
}

@Preview
@Composable
private fun PhotoThumbnailPreview() {
  val photo = Photo(
    photoId = "",
    description = "Image description",
    likes = 100,
    imageUrl = "https://unsplash.com/ja/%E5%86%99%E7%9C%9F/%E8%89%B2%E3%81%A8%E3%82%8A%E3%81%A9%E3%82%8A%E3%81%AE%E3%82%AD%E3%83%A3%E3%83%B3%E3%83%87%E3%82%A3%E3%83%BC%E3%81%8C%E3%81%9F%E3%81%8F%E3%81%95%E3%82%93%E5%85%A5%E3%81%A3%E3%81%9F%E3%82%B0%E3%83%A9%E3%82%B9-MLE2E5UF3bE",
    photographer = "Surface",
  )
  UnsplashClientTheme {
    PhotoThumbnail(photo = photo, onClick = {})
  }
}