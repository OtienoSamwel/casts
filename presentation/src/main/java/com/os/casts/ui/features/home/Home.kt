package com.os.casts.ui.features.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun Home() {
    val viewModel: HomeViewModel = hiltViewModel()
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "Home")
    }
}