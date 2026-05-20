package com.sam.domain.repository

import com.sam.domain.model.Task
import kotlinx.coroutines.flow.Flow

interface TaskRepository {
    fun getAllTasks(): Flow<List<Task>>
    fun getIncompleteTasks(): Flow<List<Task>>
    suspend fun saveTask(task: Task)
    suspend fun updateTaskCompletion(taskId: String, isCompleted: Boolean)
    suspend fun deleteTask(taskId: String)
}
