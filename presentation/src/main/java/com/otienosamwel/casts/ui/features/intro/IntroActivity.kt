package com.otienosamwel.casts.ui.features.intro

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import com.otienosamwel.casts.ui.components.SpaceFill
import com.otienosamwel.casts.ui.components.SpaceLarge
import com.otienosamwel.casts.ui.components.SpaceMedium
import com.otienosamwel.casts.ui.features.auth.AuthActivity
import com.otienosamwel.casts.ui.theme.CastTheme
import kotlinx.coroutines.launch

class IntroActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CastTheme {
                Surface(color = colors.background, modifier = Modifier.fillMaxWidth())
                { AppIntro() }
            }
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun AppIntro() {

    val pagerState = rememberPagerState()

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center
    ) {

        SpaceFill()

        HorizontalPager(count = 2, state = pagerState) { page ->
            Row(modifier = Modifier.wrapContentSize(), horizontalArrangement = Arrangement.Center) {
                when (page) {
                    0 -> Listening()
                    1 -> DiscoverNew()
                }
            }
        }

        SpaceFill()

        IntroText(pagerState = pagerState)

        SpaceLarge()

        BottomControl(pagerState = pagerState)

        SpaceMedium()
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun BottomControl(pagerState: PagerState) {
    val context = LocalContext.current as ComponentActivity
    val scope = rememberCoroutineScope()
    var endText by remember { mutableStateOf("next") }
    endText = if (pagerState.currentPage != 1) "next" else "start"

    Row(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = "skip", modifier = Modifier.clickable {
            scope.launch { pagerState.scrollToPage(1) }
        })

        BottomIndicators(pagerState = pagerState)

        Text(text = endText, modifier = Modifier.clickable {
            scope.launch {
                if (endText == "next") {
                    pagerState.animateScrollToPage(pagerState.currentPage + 1)
                } else {
                    with(context) {
                        startActivity(Intent(this, AuthActivity::class.java))
                        finish()
                    }
                }
            }
        })
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun BottomIndicators(pagerState: PagerState) {
    Box(modifier = Modifier.wrapContentSize()) {
        Row(
            modifier = Modifier
                .width(30.dp)
                .align(Alignment.Center),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            (0..1).forEach {
                val color =
                    if (pagerState.currentPage == it) colors.onSecondary else colors.primaryVariant
                val animate by animateColorAsState(targetValue = color)
                Box(
                    modifier = Modifier
                        .size(12.dp)
                        .clip(CircleShape)
                        .background(animate)
                )
            }
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun IntroText(pagerState: PagerState) {
    val introText = listOf("Listen to your favourite podcasts anywhere.", "Discover new podcasts.")
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = introText[pagerState.currentPage], style = MaterialTheme.typography.h6)
    }
}

@Preview
@Composable
fun AppIntroPreview() {
    CastTheme {
        Surface(color = colors.background) { AppIntro() }
    }
}