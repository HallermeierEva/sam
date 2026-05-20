package com.sam.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.sam.domain.model.Session
import com.sam.domain.model.SessionType

@Entity(tableName = "sessions")
data class SessionEntity(
    @PrimaryKey val id: String,
    val type: SessionType,
    val summary: String?,
    val timestamp: Long
)

fun SessionEntity.toDomain() = Session(
    id = id,
    type = type,
    summary = summary,
    timestamp = timestamp
)

fun Session.toEntity() = SessionEntity(
    id = id,
    type = type,
    summary = summary,
    timestamp = timestamp
)
