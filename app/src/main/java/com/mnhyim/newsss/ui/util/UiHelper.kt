package com.mnhyim.newsss.ui.util

import java.time.Duration
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter

fun Instant.toRelativeTimeString(): String {
    val now = Instant.now()
    val duration = Duration.between(this, now)
    val minutes = duration.toMinutes()
    val hours = duration.toHours()
    val days = duration.toDays()

    return when {
        minutes < 1 -> "Just now"
        minutes < 60 -> "${minutes}m ago"
        hours < 24 -> {
            when {
                hours < 1 -> "${minutes}m ago" // fallback
                hours <= 3 -> "3h ago"
                hours <= 6 -> "6h ago"
                hours <= 9 -> "9h ago"
                else -> "${hours}h ago"
            }
        }

        days == 1L -> "Yesterday"
        days in 2..6 -> "${days}d ago"
        else -> {
            val formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy")
                .withZone(ZoneId.systemDefault())
            formatter.format(this)
        }
    }
}

fun Instant.toFormattedDate(): String {
    val formatter = DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy")
        .withZone(ZoneId.systemDefault())
    return formatter.format(this)
}