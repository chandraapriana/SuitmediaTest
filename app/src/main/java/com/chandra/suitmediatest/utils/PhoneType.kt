package com.chandra.suitmediatest.utils

object PhoneType {
    fun getPhoneType(date: Int): String =
        when {
            date % 2 == 0 && date % 3 == 0 -> {
                "IOS"
            }
            date % 2 == 0 -> {
                "BlackBerry"
            }
            date % 3 == 0 -> {
                "Android"
            }
            else -> {
                "Feature Phone"
            }
        }

}