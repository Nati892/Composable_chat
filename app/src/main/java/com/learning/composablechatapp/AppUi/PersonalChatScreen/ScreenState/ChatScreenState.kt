package com.learning.composablechatapp.AppUi.PersonalChatScreen.ScreenState

import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.CoroutineScope

@Composable
fun rememberChatScreenState(
    LazyColumnState: LazyListState = rememberLazyListState(),
    coroutineScope: CoroutineScope = rememberCoroutineScope()
) =

    remember(LazyListState, coroutineScope) {
        ScreenState(LazyColumnState, coroutineScope)
    }


class ScreenState(
    val LazyColumnState: LazyListState,
    val coroutineScope: CoroutineScope
) {
    init {}

    @Composable
    fun initComposableStateArgs() {
    }


}