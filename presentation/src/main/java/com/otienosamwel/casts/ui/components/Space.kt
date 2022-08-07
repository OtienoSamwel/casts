package com.otienosamwel.casts.ui.components

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.RowScope
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

@Composable
fun ColumnScope.SpaceFill() {
    Spacer(modifier = Modifier.weight(1f))
}

@Composable
fun RowScope.SpaceFill() {
    Spacer(modifier = Modifier.weight(1f))
}