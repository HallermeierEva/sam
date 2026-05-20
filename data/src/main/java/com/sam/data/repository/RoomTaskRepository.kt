package com.sam.data.repository

import com.sam.data.db.TaskDao
import com.sam.data.db.toDomain
import com.sam.data.db.toEntity
import com.sam.domain.model.Task
import com.sam.domain.repository.TaskRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class RoomTaskRepository(private val dao: TaskDao) : TaskRepository {
    override fun getAllTasks(): Flow<List<Task>> {
        return dao.getAllTasks().map { entities -> entities.map { it.toDomain() } }
    }

    override fun getIncompleteTasks(): Flow<List<Task>> {
        return dao.getIncompleteTasks().map { entities -> entities.map { it.toDomain() } }
    }

    override suspend fun saveTask(task: Task) {
        dao.insertTask(task.toEntity())
    }

    override suspend fun updateTaskCompletion(taskId: String, isCompleted: Boolean) {
        dao.updateTaskCompletion(taskId, isCompleted)
    }

    override suspend fun deleteTask(taskId: String) {
        dao.deleteTask(taskId)
    }
}
