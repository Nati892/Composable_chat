package com.learning.composablechatapp.Repos

data class ChatMessagesState(
    var isLoading: Boolean = false,
    var Messages: List<MessageData> = emptyList(),
    val error: String = ""
){
    fun addItem(){



    }

}
