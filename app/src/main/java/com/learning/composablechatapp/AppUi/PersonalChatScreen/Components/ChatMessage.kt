package com.learning.composablechatapp.AppUi

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.learning.composablechatapp.data.Repos.MessageData

@Composable
fun ChatMessage(
    MessageData: MessageData,
) {

    Row(Modifier.padding(3.dp)) {
        var BoxColor = Color.Cyan

        if (MessageData.SenderId != 0) {// case of received message
            BoxColor = Color.Green
            Spacer(modifier = Modifier.weight(1f))
        }

        Box(
            Modifier
                .background(BoxColor)
                .clip(RoundedCornerShape(topEnd = 16.dp))
        ) {
            Text(
                text = "${MessageData.MessageText}",
                textAlign = if (MessageData.SenderId != 0) TextAlign.Right else TextAlign.Left
            )
        }

    }


}


