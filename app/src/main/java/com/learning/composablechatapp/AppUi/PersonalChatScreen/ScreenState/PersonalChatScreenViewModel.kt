package com.learning.composablechatapp.AppUi.PersonalChatScreen.ScreenState

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import com.learning.composablechatapp.data.Repos.FakeMessagesRepo
import com.learning.composablechatapp.data.Repos.MessageData

class PersonalChatScreenViewModel constructor(
    val params:ViewModelParams
) : ViewModel() {
    private val _state = FakeMessagesRepo().getTextMessages().toMutableStateList()
    val state: List<MessageData>
        get() = _state


    fun remove(item: MessageData) {
        _state.remove(item)
    }

    fun add(item: MessageData) {
        _state.add(item)
    }

}