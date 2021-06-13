package com.chandra.suitmediatest.utils

object PrimeNumber {
    fun checkPrimeNumber(month: Int): Boolean {
        var prime = true

        for (i in 2..month / 2) {
            if (month % i == 0) {
                prime = false
                break
            }
        }
        return prime
    }
}