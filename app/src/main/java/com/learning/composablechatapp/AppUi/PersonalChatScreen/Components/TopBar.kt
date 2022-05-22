package com.learning.composablechatapp.AppUi.PersonalChatScreen.Components

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable

@Composable
fun ChatScreenTopBar(contantName: String) {
    TopAppBar(title = { Text(text = contantName) })
}