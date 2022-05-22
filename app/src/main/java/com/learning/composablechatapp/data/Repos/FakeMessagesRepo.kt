package com.learning.composablechatapp.data.Repos

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


}