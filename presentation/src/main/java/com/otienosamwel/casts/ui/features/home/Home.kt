package com.otienosamwel.casts.ui.features.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.otienosamwel.casts.ui.components.PodcastView
import com.otienosamwel.data.models.PodcastsResponse
import com.otienosamwel.data.models.Result

@Composable
fun Home(onPodcastClicked: (Result) -> Unit) {
    val viewModel: HomeViewModel = hiltViewModel()
    val podcasts = viewModel.podcasts.observeAsState()

    Column(modifier = Modifier.fillMaxSize()) {
        podcasts.value?.let { PodcastList(podcasts = it, onPodcastClicked = onPodcastClicked) }
    }
}

@Composable
fun PodcastList(podcasts: PodcastsResponse, onPodcastClicked: (Result) -> Unit) {
    LazyColumn {
        items(podcasts.results) { podcast ->
            PodcastView(podcast = podcast, onPodcastClicked = onPodcastClicked)
        }
    }
}

