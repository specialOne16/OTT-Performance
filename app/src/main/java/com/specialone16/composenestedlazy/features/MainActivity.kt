package com.specialone16.composenestedlazy.features

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.specialone16.composenestedlazy.features.comments.playerWithComment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        playerWithComment()
    }
}
