package com.learning.composablechatapp.AppUi.PersonalChatScreen.ScreenState

import android.util.Log
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.learning.composablechatapp.data.Repos.FakeMessagesRepo
import com.learning.composablechatapp.data.Repos.MessageData
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class PersonalChatScreenViewModel constructor(
    val params: ViewModelParams,
    val AppState: ScreenState
) : ViewModel() {
    private val _state = emptyList<MessageData>().toMutableStateList()
    val state = _state


    init {
        InitialLoadMessages()
        ReciveMessages()
    }


    fun remove(item: MessageData) {
        _state.remove(item)
    }

    fun add(item: MessageData) {
        _state.add(item)
    }

    val MessagesFlow = flow<MessageData> {
        val MessagesReopList = FakeMessagesRepo().getTextMessages().toList()
        for (m in MessagesReopList) {
            emit(m)
        }
    }

    private fun InitialLoadMessages() {
        viewModelScope.launch {
            while (MessagesFlow == null){
                delay(1L)
                Log.d("TAG", "InitialLoadMessages: delaying")}
            MessagesFlow.collect {
                add(it)

            }
        }
    }


    private fun ReciveMessages() {
        viewModelScope.launch {
            FakeMessagesRepo().FakeRecievedMessage.collect {
                if (it != null) {
                    add(it)
                    NotifyUserNewMessages()
                }
            }
        }
    }

    fun NotifyUserNewMessages() {
        if (state.size > 0)
            viewModelScope.launch {
                if (AppState.LazyColumnState.layoutInfo.visibleItemsInfo.lastOrNull()?.index!! <= AppState.LazyColumnState.layoutInfo.totalItemsCount - 4)
                    AppState.showMoreMessageButton.value = true;
                else
                    scrollMessagesToEnd()
            }
    }

    fun scrollMessagesToEnd() {
        viewModelScope.launch {
            AppState.LazyColumnState.scrollToItem(AppState.LazyColumnState.layoutInfo.totalItemsCount)
        }
    }
}