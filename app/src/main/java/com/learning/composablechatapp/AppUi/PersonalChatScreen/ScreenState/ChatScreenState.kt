package com.learning.composablechatapp.AppUi.PersonalChatScreen.ScreenState

import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import kotlinx.coroutines.CoroutineScope

@Composable
fun rememberChatScreenState(
    LazyColumnState: LazyListState = rememberLazyListState(),
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    showMoreMessageButton: MutableState<Boolean> = rememberSaveable { mutableStateOf(false) },

) =

    remember(LazyColumnState, coroutineScope) {
        ScreenState(LazyColumnState, coroutineScope, showMoreMessageButton)
    }


class ScreenState(
    val LazyColumnState: LazyListState,
    val coroutineScope: CoroutineScope,
    val showMoreMessageButton: MutableState<Boolean>,
) {



    init {}

    @Composable
    fun initComposableStateArgs() {
    }

}