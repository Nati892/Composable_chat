package com.learning.composablechatapp.AppUi.PersonalChatScreen.ScreenState

import com.learning.composablechatapp.data.Repos.MessageData

data class ChatMessagesState(
    var isLoading: Boolean = false,
    var Messages: List<MessageData> = emptyList(),
    val error: String = ""
){
}
