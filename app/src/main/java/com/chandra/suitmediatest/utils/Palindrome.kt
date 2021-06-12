package com.chandra.suitmediatest.utils

object Palindrome {

    fun isPalindrome(palindrome: String): Boolean {
        val string = palindrome.replace("\\s".toRegex(), "").lowercase()
        for (i in string.indices){
            val indexReverse = string.length - 1 - i
            if (string[i] != string[indexReverse]){
                return false
            }

        }
        return true
    }





}