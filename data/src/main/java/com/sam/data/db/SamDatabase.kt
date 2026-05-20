package com.sam.data.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [TaskEntity::class, SessionEntity::class, UserProfileEntity::class],
    version = 1,
    exportSchema = false
)
abstract class SamDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
    abstract fun sessionDao(): SessionDao
    abstract fun userProfileDao(): UserProfileDao
}
