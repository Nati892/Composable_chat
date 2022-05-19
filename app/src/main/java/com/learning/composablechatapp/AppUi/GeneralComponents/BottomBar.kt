package com.learning.composablechatapp.AppUi.GeneralComponents

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable

@Composable
fun AppBottomBar(
) {
    var BottomText = rememberSaveable { mutableStateOf("") }
    BottomAppBar() {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            TextField(
                value = "${BottomText.value}",
                onValueChange = { text -> BottomText.value = text },
                singleLine = false,
                placeholder = { Text(text = "Message") }

            )

            Button(onClick = { }) {
                Icon(Icons.Default.Send, contentDescription = null)
            }

        }

    }


}