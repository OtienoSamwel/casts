package com.os.casts.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import coil.compose.SubcomposeAsyncImage

@Composable
fun ImageView(imageUri: String, imageSize: Dp) {
    SubcomposeAsyncImage(
        model = imageUri,
        contentDescription = "",
        loading = { CircularProgressIndicator() },
        contentScale = ContentScale.Crop,
        modifier = Modifier.size(imageSize)
    )
}
