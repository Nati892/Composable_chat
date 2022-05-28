package com.learning.composablechatapp.AppUi.PersonalChatScreen.Components

import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.runtime.Composable
import com.learning.composablechatapp.AppUi.PersonalChatScreen.ScreenState.PersonalChatScreenViewModel

@Composable
fun DownActionButton(viewModel: PersonalChatScreenViewModel){
    //if not in end and there are items that are not observed
            FloatingActionButton(onClick = { viewModel.scrollMessagesToEnd() }){
                Icon(Icons.Default.KeyboardArrowDown, contentDescription = null)
            }
}