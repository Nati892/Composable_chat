package com.learning.composablechatapp.AppUi

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun ChatMessage(
    MessageText: String,
    recieved: Boolean = false,//determines horizontal position of message
) {


    Column() {
        Text(text = "$MessageText", Modifier.background(Color.Cyan))

    }
}


