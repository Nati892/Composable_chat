package com.learning.composablechatapp.Navigation

sealed class Screen(val route: String) {
    object ChatListsScreen:Screen("chatlistscreen")
    object PersonalChatsScreen:Screen("personalchatscreen")
}