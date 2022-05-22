package com.learning.composablechatapp.AppUi.PersonalChatScreen.ScreenState

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MyViewModelFactory(
    private val dbname: ViewModelParams
) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        PersonalChatScreenViewModel(dbname) as T
}