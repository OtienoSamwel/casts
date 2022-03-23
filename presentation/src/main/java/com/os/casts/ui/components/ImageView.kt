package com.os.casts.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage

@Composable
fun ImageView(imageUri: String, imageSize: Dp, padding: Dp = 8.dp) {
    SubcomposeAsyncImage(
        model = imageUri,
        contentDescription = "",
        loading = { CircularProgressIndicator() },
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .padding(padding)
            .size(imageSize)
            .clip(RoundedCornerShape(8.dp))
    )
}
