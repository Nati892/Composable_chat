package com.learning.composablechatapp.data.Repos

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
enum class messageType{

}
class MessageData(
    val MessageId:Long=0,
    val SenderId: Long=0,
    val Receiver: Long=0,
    val MessageText: String="",
    val DateTimeObj_sent: Object?=null,
    val DateTimeObj_receivedByServer: Object?=null,
    val DateTimeObj_receivedByUser: Object?=null,
    val DateTimeObj_seenByUser: Object?=null,
    val Forwarded:Boolean=false,
    val Content:Object?=null
    )//TODO DateTimeObjObj, and content obj
{

}
