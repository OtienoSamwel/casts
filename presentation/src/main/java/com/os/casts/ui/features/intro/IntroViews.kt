package com.os.casts.ui.features.intro

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.os.casts.R

@Composable
fun Listening() {
    val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.walking_man))
    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .fillMaxHeight(0.6f)
    ) {
        LottieAnimation(
            composition = composition,
            iterations = Int.MAX_VALUE,
            modifier = Modifier.wrapContentSize()
        )
    }
}

@Composable
fun DiscoverNew() {
    val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.discover_new))
    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .fillMaxHeight(0.6f)
    ) {
        LottieAnimation(
            composition = composition,
            iterations = Int.MAX_VALUE,
            modifier = Modifier.wrapContentSize()
        )
    }
}