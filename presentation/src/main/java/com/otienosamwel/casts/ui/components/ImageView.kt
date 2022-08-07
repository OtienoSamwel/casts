package com.otienosamwel.casts.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.otienosamwel.casts.R

@Composable
fun ImageView(imageUri: String, imageSize: Dp, padding: Dp = 8.dp) {
    SubcomposeAsyncImage(
        model = imageUri,
        contentDescription = "",
        loading = { ImageLoadingAnimation() },
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .padding(padding)
            .size(imageSize)
            .clip(RoundedCornerShape(8.dp))
    )
}


@Composable
fun ImageLoadingAnimation() {
    val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.bubble_loading))
    LottieAnimation(
        composition = composition,
        iterations = Int.MAX_VALUE,
        modifier = Modifier.wrapContentSize()
    )
}