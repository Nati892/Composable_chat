package com.learning.composablechatapp.Repos

class FakeMessagesRepo() {
    val list: ArrayList<MessageData> = arrayListOf();
    fun getTextMessages(): List<MessageData> {
        for (i in 1..100)
            list.add(MessageData("Text $i"))
        return list;
    }

    fun Addvalue(item: MessageData) {
        list.add(item)
    }


}