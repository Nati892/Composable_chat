package com.learning.composablechatapp.data.Repos

class FakeMessagesRepo() {
    val list: ArrayList<MessageData> = arrayListOf();
    fun getTextMessages(): List<MessageData> {
        for (i in 1..100)
            list.add(MessageData("Text $i", 0))
        return list;
    }



}