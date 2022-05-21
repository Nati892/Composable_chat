package com.learning.composablechatapp.AppUi

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.learning.composablechatapp.AppUi.GeneralComponents.PersonalChatBottomBar
import com.learning.composablechatapp.AppUi.PersonalChatScreenComponents.PersonalChatScreenViewModel
import com.learning.composablechatapp.Repos.MessageData

@Composable
fun PersonalChatsScreen(
    viewModel: PersonalChatScreenViewModel,
    navHost: NavHostController,
) {
    val state = viewModel.state





    Scaffold(
        bottomBar = {
            PersonalChatBottomBar { arg ->
                //state.value.Messages.add(MessageData(arg,0))
                state.value.isLoading=!state.value.isLoading

            }
        }
    ) { inner ->
        Box(
            modifier = Modifier.padding(
                paddingValues = PaddingValues(0.dp, 0.dp, 0.dp, inner.calculateBottomPadding())
            )
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxWidth()
            ) {
                item { Text(text = state.value.isLoading.toString()) }
                items(items = state.value.Messages) {
                    ChatMessage(it.MessageText);
                }


            }
        }

    }

}