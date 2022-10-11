package com.himawanmasyaid.scoreboardandroid.common

import java.util.concurrent.TimeUnit


fun Long.convertSecondToMinutes(): Long {
    val  milliseconds: Long = 1000000
    // long minutes = (milliseconds / 1000) / 60;
    return TimeUnit.MILLISECONDS.toMinutes(milliseconds)
}