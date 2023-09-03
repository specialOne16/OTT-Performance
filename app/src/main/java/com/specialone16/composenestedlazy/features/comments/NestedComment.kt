package com.specialone16.composenestedlazy.features.comments

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun NestedComment(
    commentCount: Int,
    replyPerCommentCount: Int,
    modifier: Modifier = Modifier,
    withButton: Boolean = false
) {
    LazyColumn(modifier.fillMaxWidth()) {
        items(commentCount) {
            Column(modifier.padding(8.dp)) {
                ImageWithText(
                    upperText = "a_nice_user_$it",
                    lowerText = "this is a nice comment"
                )
                if (withButton) {
                    var showReply by rememberSaveable { mutableStateOf(false) }
                    AnimatedVisibility(visible = showReply) {
                        NestedReply(replyPerCommentCount)
                    }
                    TextButton(
                        onClick = { showReply = !showReply },
                        modifier = Modifier.align(Alignment.End)

                    ) { Text(text = "Replies") }
                } else {
                    NestedReply(replyPerCommentCount)
                }
            }
        }
    }
}

@Composable
fun NestedReply(replyCount: Int) {
    Column(Modifier.fillMaxWidth()) {
        repeat(replyCount) {
            ImageWithText(
                modifier = Modifier.padding(start = 48.dp, top = 8.dp, bottom = 8.dp),
                upperText = "an_even_nicer_user_$it",
                lowerText = "this is a nice reply"
            )
        }
    }
}
