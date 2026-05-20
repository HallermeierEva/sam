package com.sam.data.repository

import com.sam.data.db.UserProfileDao
import com.sam.data.db.toDomain
import com.sam.data.db.toEntity
import com.sam.domain.model.UserProfile
import com.sam.domain.repository.UserProfileRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class RoomUserProfileRepository(private val dao: UserProfileDao) : UserProfileRepository {
    override fun getUserProfile(): Flow<UserProfile?> {
        return dao.getUserProfile().map { it?.toDomain() }
    }

    override suspend fun saveUserProfile(profile: UserProfile) {
        dao.insertUserProfile(profile.toEntity())
    }
}
