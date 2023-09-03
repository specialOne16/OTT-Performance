package com.specialone16.composenestedlazy.features.comments

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun FlattenComment(
    commentCount: Int,
    replyPerCommentCount: Int,
    modifier: Modifier = Modifier,
    withButton: Boolean = false
) {
    LazyColumn(modifier) {
        items(commentCount * replyPerCommentCount) {
            if (it % (replyPerCommentCount + 1) == 0) {
                ImageWithText(
                    upperText = "a_nice_user_$it",
                    lowerText = "this is a nice comment"
                )
            } else {
                ImageWithText(
                    modifier = Modifier.padding(start = 48.dp, top = 8.dp, bottom = 8.dp),
                    upperText = "an_even_nicer_user_$it",
                    lowerText = "this is a nice reply"
                )
            }
        }
    }
}
