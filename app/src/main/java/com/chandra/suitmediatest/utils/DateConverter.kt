package com.chandra.suitmediatest.utils

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

class DateConverter(date: String) {
    @SuppressLint("SimpleDateFormat")
    private val format = SimpleDateFormat("yyyy-MM-dd")
    private val dateFormat: Date = format.parse(date)
    private val calendar: Calendar = Calendar.getInstance(TimeZone.getDefault())

    init {
        calendar.time = dateFormat
    }

    fun getDate(): Int {
        return calendar.get(Calendar.DATE)
    }

    fun getMonth(): Int {
        return calendar.get(Calendar.MONTH) + 1
    }

}