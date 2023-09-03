package com.specialone16.composenestedlazy.features.comments

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import kotlin.random.Random

@Composable
fun ImageWithText(
    modifier: Modifier = Modifier,
    icon: String = randomIcon(),
    upperText: String = "username",
    lowerText: String = "message",
) {
    val saveIcon = rememberSaveable { icon }
    Row(modifier) {
        AsyncImage(
            model = "https://cdn-icons-png.flaticon.com/512/$saveIcon.png".also {
                Log.i("ImageWithText", "Image Model => $it")
            },
            contentDescription = null,
            modifier = Modifier.size(48.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Row {
            Column(Modifier.weight(1f)) {
                Text(text = upperText, fontWeight = FontWeight.ExtraBold)
                Text(text = lowerText, fontWeight = FontWeight.Light)
            }
            Icon(Icons.Default.Share, null)
        }
    }
}

fun randomIcon(): String {
    val folder = Random.nextInt(5200, 5300)
    val file = Random.nextInt(100, 999)
    return "$folder/$folder$file"
}
