package com.octacoresoftwares.mito.utils

import java.util.regex.Matcher
import java.util.regex.Pattern

fun isValidEmail(email: String): Boolean {
    val regex =
        "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$"
    val pattern: Pattern = Pattern.compile(regex)
    val matcher: Matcher = pattern.matcher(email)
    return matcher.matches()
}

fun isPhoneNumber(phone: String): Boolean {
    val regex = "^[0]\\d{10}$"
    val pattern = Pattern.compile(regex)
    val matcher = pattern.matcher(phone)
    return matcher.matches()
}