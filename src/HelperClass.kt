package ru.maxbarannyk.helpers

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class HelperClass {

    fun logString(message: String?) {
        println(message)
    }

    fun getDateInString(): String {
        return SimpleDateFormat("yyyy.MM.dd_HH.mm.ss", Locale.ENGLISH).format(Date())
    }
}