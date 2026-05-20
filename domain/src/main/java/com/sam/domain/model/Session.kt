package com.sam.domain.model

data class Session(
    val id: String,
    val type: SessionType,
    val summary: String?,
    val timestamp: Long
)

enum class SessionType {
    MORNING_PLANNING,
    EVENING_DEBRIEF,
    MANUAL
}
