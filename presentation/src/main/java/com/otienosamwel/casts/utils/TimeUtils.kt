package com.otienosamwel.casts.utils

object TimeUtils {
    fun Int.toHoursAndMinutes(): String {
        return if (this < 60) {
            "$this seconds"
        } else {
            val hours = if (this / 3600 > 0) "${this / 3600} hours" else ""
            val minutes = (this % 3600)  // remaining seconds after converting to hours
            val minutesString = if (minutes / 60 > 0) "${minutes / 60} minutes" else ""
            "$hours $minutesString"
        }
    }
}