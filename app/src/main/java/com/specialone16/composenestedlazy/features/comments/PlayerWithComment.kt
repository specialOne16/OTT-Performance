package com.specialone16.composenestedlazy.features.comments

import android.net.Uri
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTagsAsResourceId
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import com.specialone16.composenestedlazy.ui.theme.ComposeNestedLazyTheme

fun ComponentActivity.playerWithComment() {
    val player: Player = ExoPlayer.Builder(this).build()
    player.addMediaItem(
        MediaItem.fromUri(
            Uri.parse(
                "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"
            )
        )
    )
    player.prepare()
    player.playWhenReady = true

    setContent {
        ComposeNestedLazyTheme {
            PlayerWithComment(playerView = player)
        }
    }
}


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun PlayerWithComment(playerView: Player) {
    Column {
        AndroidView(
            factory = { context ->
                PlayerView(context).also {
                    it.player = playerView
                }
            },
            modifier = Modifier.aspectRatio(16 / 9f)
        )
        CommentImplementation(
            attr = CommentImplementationAttr.Nested,
            modifier = Modifier
                .semantics { testTagsAsResourceId = true }
                .testTag("Comments")
                .weight(1f)
        )
        TextField(value = "Type here...", onValueChange = {}, modifier = Modifier.fillMaxWidth())
    }
}
