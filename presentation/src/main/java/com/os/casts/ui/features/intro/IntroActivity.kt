package com.os.casts.ui.features.intro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.os.casts.ui.theme.CastTheme

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

    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        HorizontalPager(count = 3, state = pagerState) { page ->
            Row(modifier = Modifier.wrapContentSize(), horizontalArrangement = Arrangement.Center) {
                Text(text = "Page:  $page")
            }
        }
        Box(modifier = Modifier.weight(1f)) {
            Row(
                modifier = Modifier
                    .width(50.dp)
                    .align(Alignment.Center),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                (0..2).forEach {
                    val color =
                        if (pagerState.currentPage == it) colors.onSecondary else colors.primaryVariant
                    val animate by animateColorAsState(targetValue = color)
                    Box(
                        modifier = Modifier
                            .size(10.dp)
                            .clip(CircleShape)
                            .background(animate)
                    )
                }
            }
        }
    }
}


@Preview
@Composable
fun AppIntroPreview() {
    CastTheme {
        Surface(color = colors.background) { AppIntro() }
    }
}