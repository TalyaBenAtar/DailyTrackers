package com.example.commontracker

fun Int.toMinutesText(): String {
    return if (this == 1) {
        "$this minute"
    } else {
        "$this minutes"
    }
}