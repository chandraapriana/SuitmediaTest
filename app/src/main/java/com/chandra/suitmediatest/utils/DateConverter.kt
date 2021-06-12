package com.chandra.suitmediatest.utils

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

object DateConverter {
    @SuppressLint("SimpleDateFormat")
    fun getDate(date: String): Int {
        val format = SimpleDateFormat("yyyy-mm-dd")
        val dateFormat = format.parse(date)
        val calendar = Calendar.getInstance(TimeZone.getDefault())
        calendar.time = dateFormat
        return calendar.get(Calendar.DATE)

    }
}