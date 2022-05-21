package com.learning.composablechatapp.AppUi

import androidx.compose.foundation.background
import androidx.compose.material.Shapes
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun ChatMessage(
    MessageText: String,
    LeftOrRight: Boolean=false,//false-left, true-right
) {
    Text(text = "$MessageText", Modifier.background(Color.Cyan))
}