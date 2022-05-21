package com.learning.composablechatapp.AppUi.PersonalChatScreenComponents

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import com.learning.composablechatapp.Repos.ChatMessagesState
import com.learning.composablechatapp.Repos.FakeMessagesRepo
import com.learning.composablechatapp.Repos.MessageData

class PersonalChatScreenViewModel constructor() : ViewModel() {
    private val _state = mutableStateOf(ChatMessagesState())
    val state: State<ChatMessagesState> = _state


//    val state: MutableList<MessageData> = arrayListOf()


//    init {
//        state.toMutableStateList()
//        state.addAll(FakeMessagesRepo().getTextMessages())
//    }

    init {
        _state.value = ChatMessagesState(
            isLoading = false,
            error = "",
            Messages = FakeMessagesRepo().getTextMessages()
        )
    }


}