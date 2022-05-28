package com.learning.composablechatapp.AppUi

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.learning.composablechatapp.AppUi.GeneralComponents.PersonalChatBottomBar
import com.learning.composablechatapp.AppUi.PersonalChatScreen.Components.ChatScreenTopBar
import com.learning.composablechatapp.AppUi.PersonalChatScreen.Components.DownActionButton
import com.learning.composablechatapp.AppUi.PersonalChatScreen.ScreenState.PersonalChatScreenViewModel
import com.learning.composablechatapp.data.Repos.MessageData

@Composable
fun PersonalChatsScreen(
    viewModel: PersonalChatScreenViewModel,
    navHost: NavHostController,
) {
    var States = viewModel.AppState
    val endReached by remember {
        derivedStateOf {
            (States.LazyColumnState.layoutInfo.visibleItemsInfo.lastOrNull()?.index == States.LazyColumnState.layoutInfo.totalItemsCount - 1)
        }
    }
    if (endReached) {
        LaunchedEffect(Unit) {
            States.showMoreMessageButton.value = false
        }
    }

    Scaffold(
        bottomBar = {
            PersonalChatBottomBar { arg ->
                viewModel.add(MessageData(arg, 0))
                viewModel.scrollMessagesToEnd()
            }
        },
        topBar = { ChatScreenTopBar(contantName = viewModel.params.contact) },
        floatingActionButton = {
            if (States.showMoreMessageButton.value) {
                DownActionButton(viewModel = viewModel)
            }
        }

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

