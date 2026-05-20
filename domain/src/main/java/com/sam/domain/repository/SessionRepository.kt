package com.sam.domain.repository

import com.sam.domain.model.Session
import kotlinx.coroutines.flow.Flow

interface SessionRepository {
    fun getAllSessions(): Flow<List<Session>>
    suspend fun saveSession(session: Session)
    suspend fun deleteSession(sessionId: String)
}
