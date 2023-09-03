package com.specialone16.composenestedlazy.features.comments

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

sealed interface CommentImplementationAttr {
    object Nested : CommentImplementationAttr
    object Flatten : CommentImplementationAttr
}

@Composable
fun CommentImplementation(
    attr: CommentImplementationAttr,
    modifier: Modifier = Modifier,
    commentCount: Int = 20,
    replyPerCommentCount: Int = 30
) {
    when (attr) {
        CommentImplementationAttr.Flatten -> FlattenComment(
            commentCount = commentCount,
            replyPerCommentCount = replyPerCommentCount,
            modifier = modifier

        )

        CommentImplementationAttr.Nested -> NestedComment(
            commentCount = commentCount,
            replyPerCommentCount = replyPerCommentCount,
            modifier = modifier
        )
    }
}
