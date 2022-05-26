package com.learning.composablechatapp.data.Repos

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow

class FakeMessagesRepo() {
    val list: ArrayList<MessageData> = arrayListOf();
    fun getTextMessages(): List<MessageData> {
        for (i in 1..100) {
            var id = 0
            var Text = "short"

            if (i % 3 == 1)
                Text = " I think this is not so short"
            if (i % 3 == 2)
                Text =
                    "very very very very very very very very very very very very very very very very very very very very very very very very very very very very Long text"
            if (i % 6 > 2)
                id = 1


            var itMessage = MessageData(Text, id)
            list.add(itMessage)

        }
        return list;
    }

    val FakeRecievedMessage = flow<MessageData> {
        var FakeMessageList = listOf<MessageData>(
            MessageData("I need to hack facebook", 1),
            MessageData("do you bitcoin much?", 1),
            MessageData("Can you fix my printer?", 1)
        )
        var i = 0;
        while (true) {
            delay(4000L)
            emit(FakeMessageList[i%FakeMessageList.size])
            i++;
        }
    }


}