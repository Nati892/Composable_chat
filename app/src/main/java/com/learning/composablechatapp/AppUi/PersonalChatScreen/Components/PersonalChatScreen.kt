package com.learning.composablechatapp.AppUi

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.learning.composablechatapp.AppUi.GeneralComponents.PersonalChatBottomBar
import com.learning.composablechatapp.AppUi.PersonalChatScreen.Components.ChatScreenTopBar
import com.learning.composablechatapp.AppUi.PersonalChatScreen.ScreenState.PersonalChatScreenViewModel
import com.learning.composablechatapp.data.Repos.MessageData
import kotlinx.coroutines.launch

@Composable
fun PersonalChatsScreen(
    viewModel: PersonalChatScreenViewModel,
    navHost: NavHostController,
) {

    var listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    Scaffold(
        bottomBar = {
            PersonalChatBottomBar { arg ->
                viewModel.add(MessageData(arg, 0))

                coroutineScope.launch {
                    listState.scrollToItem(viewModel.state.size - 1)
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
                state = listState
            ) {
                items(viewModel.state) {
                    ChatMessage(it);
                }
            }
        }
    }
}