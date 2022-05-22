package com.learning.composablechatapp.AppUi

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.learning.composablechatapp.data.Repos.MessageData

@Composable
fun ChatMessage(
    MessageData: MessageData,
) {

        Row() {
            if (MessageData.SenderId != 0)
            Spacer(modifier = Modifier.weight(1f))
            Column(

            ) {
                Text(text = "${MessageData.MessageText}", Modifier.background(Color.Cyan))
            }
        }

}


