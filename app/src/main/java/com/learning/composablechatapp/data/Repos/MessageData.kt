package com.learning.composablechatapp.data.Repos

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class MessageData(
    val MessageText: String,
    val SenderId: Int= 0
)
{
    var checked by mutableStateOf(SenderId)
}
