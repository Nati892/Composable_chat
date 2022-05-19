package com.learning.composablechatapp.AppUi

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.learning.composablechatapp.Repos.FakeMessagesRepo

@Composable
fun PersonalChatsScreen(
    navHost: NavHostController,
) {

    LazyColumn(
        modifier = Modifier.fillMaxWidth()
    ) {
        items(items = FakeMessagesRepo().getTextMessages()) {
            ChatMessage(it.Text);
        }


    }
}