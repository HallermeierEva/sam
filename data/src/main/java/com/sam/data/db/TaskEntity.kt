package com.sam.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.sam.domain.model.Task

@Entity(tableName = "tasks")
data class TaskEntity(
    @PrimaryKey val id: String,
    val title: String,
    val description: String?,
    val isCompleted: Boolean,
    val createdAt: Long
)

fun TaskEntity.toDomain() = Task(
    id = id,
    title = title,
    description = description,
    isCompleted = isCompleted,
    createdAt = createdAt
)

fun Task.toEntity() = TaskEntity(
    id = id,
    title = title,
    description = description,
    isCompleted = isCompleted,
    createdAt = createdAt
)
