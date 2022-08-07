package com.otienosamwel.casts.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.PlayCircle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.otienosamwel.casts.utils.TimeUtils.toHoursAndMinutes
import com.otienosamwel.data.models.Result

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PodcastView(podcast: Result, onPodcastClicked: (podcast: Result) -> Unit) {
    Column(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .clickable(enabled = true, onClick = { onPodcastClicked(podcast) }),

        ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            podcast.image?.let { ImageView(imageUri = it, imageSize = 60.dp) }
            podcast.title_original?.let {
                Text(
                    text = it,
                    style = MaterialTheme.typography.body1,
                    fontWeight = FontWeight.Medium
                )
            }
        }
        podcast.description_original?.let {
            Text(
                text = it,
                maxLines = 3,
                style = MaterialTheme.typography.caption,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(horizontal = 8.dp)
            )
        }

        SpaceSmall()


        Row(
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .fillMaxWidth()
        ) {
            Chip(onClick = {}) { Text(text = "${podcast.audio_length_sec?.toHoursAndMinutes()}") }

            Spacer(modifier = Modifier.weight(1f))

            IconButton(onClick = {}) {
                Icon(imageVector = Icons.Rounded.PlayCircle, contentDescription = "")
            }
        }

        SpaceSmall()

        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Divider(modifier = Modifier.fillMaxWidth(), color = Color.Gray)
        }

    }
}