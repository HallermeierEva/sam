package com.sam.data.repository

import com.sam.data.db.SessionDao
import com.sam.data.db.toDomain
import com.sam.data.db.toEntity
import com.sam.domain.model.Session
import com.sam.domain.repository.SessionRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class RoomSessionRepository(private val dao: SessionDao) : SessionRepository {
    override fun getAllSessions(): Flow<List<Session>> {
        return dao.getAllSessions().map { entities -> entities.map { it.toDomain() } }
    }

    override suspend fun saveSession(session: Session) {
        dao.insertSession(session.toEntity())
    }

    override suspend fun deleteSession(sessionId: String) {
        dao.deleteSession(sessionId)
    }
}
