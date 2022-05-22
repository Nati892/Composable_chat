package com.learning.composablechatapp.AppUi

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.learning.composablechatapp.AppUi.GeneralComponents.PersonalChatBottomBar
import com.learning.composablechatapp.AppUi.PersonalChatScreen.Components.ChatScreenTopBar
import com.learning.composablechatapp.AppUi.PersonalChatScreen.ScreenState.PersonalChatScreenViewModel
import com.learning.composablechatapp.AppUi.PersonalChatScreen.ScreenState.rememberChatScreenState
import com.learning.composablechatapp.data.Repos.MessageData
import kotlinx.coroutines.launch

@Composable
fun PersonalChatsScreen(
    viewModel: PersonalChatScreenViewModel,
    navHost: NavHostController,
) {
    val States= rememberChatScreenState()

    Scaffold(
        bottomBar = {
            PersonalChatBottomBar { arg ->
                viewModel.add(MessageData(arg, 0))

                States.coroutineScope.launch {
                    States.LazyColumnState.scrollToItem(viewModel.state.size - 1)
                }

            }
        },
        topBar = { ChatScreenTopBar(contantName = viewModel.params.contact) }

    ) { inner ->
        Box(
            modifier = Modifier.padding(
                paddingValues = PaddingValues(0.dp, 0.dp, 0.dp, inner.calculateBottomPadding())
            )
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                state = States.LazyColumnState
            ) {
                items(viewModel.state) {
                    ChatMessage(it);
                }
            }
        }
    }
}