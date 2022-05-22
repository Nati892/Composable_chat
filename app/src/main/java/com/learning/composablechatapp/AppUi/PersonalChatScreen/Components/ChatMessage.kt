package com.learning.composablechatapp.AppUi

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.learning.composablechatapp.data.Repos.MessageData

@Composable
fun ChatMessage(
    MessageData: MessageData,
) {

    Row(Modifier.padding(3.dp)) {
        var boxColor = Color.Cyan
        val ClipDp = 8.dp
        var clipTopStart = 0.dp
        var clipTopEnd = ClipDp
        if (MessageData.SenderId != 0) {// case of received message
            boxColor = Color.Green
            Spacer(modifier = Modifier.weight(1f))
            clipTopEnd = 0.dp;
            clipTopStart = ClipDp
        }

        Box(
            Modifier
                .clip(
                    RoundedCornerShape(
                        topStart = clipTopStart,
                        topEnd = clipTopEnd,
                        bottomEnd = ClipDp,
                        bottomStart = ClipDp
                    )
                )
                .background(boxColor)
        ) {
            Text(
                modifier = Modifier.padding(horizontal = 3.dp),
                text = "${MessageData.MessageText.trim()}",
                textAlign = if (MessageData.SenderId != 0) TextAlign.Right else TextAlign.Left
               , fontWeight = FontWeight(300)
            )
        }
    }
}


