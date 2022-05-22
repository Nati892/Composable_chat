package com.learning.composablechatapp.data.Repos

class FakeMessagesRepo() {
    val list: ArrayList<MessageData> = arrayListOf();
    fun getTextMessages(): List<MessageData> {
        for (i in 1..100)
            if (i % 2 == 0)
                list.add(MessageData("Text $i", 0))
            else
                list.add(MessageData("Text $i", 1))
        return list;
    }


}