package com.learning.composablechatapp.Navigation


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.learning.composablechatapp.AppUi.ChatListsScreen
import com.learning.composablechatapp.AppUi.PersonalChatScreenComponents.PersonalChatScreenViewModel
import com.learning.composablechatapp.AppUi.PersonalChatsScreen


@Composable
fun NavGraph(
    navHost: NavHostController,
) {
    NavHost(
        navController = navHost,
        startDestination = Screen.ChatListsScreen.route
    ) {
        composable(
           route=Screen.ChatListsScreen.route
        ) {
            ChatListsScreen(navHost)
        }
        composable(
            route=Screen.PersonalChatsScreen.route
        ) {
            PersonalChatsScreen(PersonalChatScreenViewModel(),navHost)
        }
        }

        // todo add more screens
    }
