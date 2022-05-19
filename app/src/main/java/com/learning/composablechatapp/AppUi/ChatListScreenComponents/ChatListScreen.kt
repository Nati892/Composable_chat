package com.learning.composablechatapp.AppUi

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.learning.composablechatapp.Navigation.Screen

@Composable
fun ChatListsScreen(
    navHost: NavHostController
) {
    Button(onClick = { navHost.navigate(Screen.PersonalChatsScreen.route) }) {
        Text("Go to chat screen")
    }
}