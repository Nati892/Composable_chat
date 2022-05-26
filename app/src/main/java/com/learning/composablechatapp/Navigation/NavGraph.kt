package com.learning.composablechatapp.Navigation


import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.learning.composablechatapp.AppUi.ChatListsScreen
import com.learning.composablechatapp.AppUi.PersonalChatScreen.ScreenState.MyViewModelFactory
import com.learning.composablechatapp.AppUi.PersonalChatScreen.ScreenState.ViewModelParams
import com.learning.composablechatapp.AppUi.PersonalChatScreen.ScreenState.rememberChatScreenState
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
            ChatListsScreen(navHost= navHost)
        }
        composable(
            route=Screen.PersonalChatsScreen.route
        ) {
            var screenState= rememberChatScreenState()
            PersonalChatsScreen(viewModel = viewModel(factory = MyViewModelFactory(ViewModelParams("chatname",screenState))),navHost= navHost)
        }
        }

        // todo add more screens
    }
