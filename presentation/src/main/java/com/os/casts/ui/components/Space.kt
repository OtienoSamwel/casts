package com.os.casts.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SpaceSmall() {
    Spacer(modifier = Modifier.size(10.dp))
}

@Composable
fun SpaceMedium() {
    Spacer(modifier = Modifier.size(20.dp))
}

@Composable
fun SpaceLarge() {
    Spacer(modifier = Modifier.size(40.dp))
}