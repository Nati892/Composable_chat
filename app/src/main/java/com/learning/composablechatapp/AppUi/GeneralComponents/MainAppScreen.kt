package com.learning.composablechatapp.AppUi.GeneralComponents

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.learning.composablechatapp.Navigation.NavGraph
import com.learning.composablechatapp.ui.theme.ComposableChatAppTheme


@Composable
fun App() {
    ComposableChatAppTheme {
        val navController = rememberNavController()

        Scaffold(

        ) {
            NavGraph(navHost = navController)
        }

    }
}