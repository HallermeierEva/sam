package com.sam.app.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.room.Room
import com.sam.data.db.SamDatabase
import com.sam.data.repository.DataStoreSettingsRepository
import com.sam.data.repository.RoomSessionRepository
import com.sam.data.repository.RoomTaskRepository
import com.sam.data.repository.RoomUserProfileRepository
import com.sam.domain.repository.SessionRepository
import com.sam.domain.repository.SettingsRepository
import com.sam.domain.repository.TaskRepository
import com.sam.domain.repository.UserProfileRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideSettingsRepository(
        @ApplicationContext context: Context
    ): SettingsRepository {
        return DataStoreSettingsRepository(context.dataStore)
    }

    @Provides
    @Singleton
    fun provideSamDatabase(@ApplicationContext context: Context): SamDatabase {
        return Room.databaseBuilder(
            context,
            SamDatabase::class.java,
            "sam_database"
        ).build()
    }

    @Provides
    @Singleton
    fun provideTaskRepository(database: SamDatabase): TaskRepository {
        return RoomTaskRepository(database.taskDao())
    }

    @Provides
    @Singleton
    fun provideSessionRepository(database: SamDatabase): SessionRepository {
        return RoomSessionRepository(database.sessionDao())
    }

    @Provides
    @Singleton
    fun provideUserProfileRepository(database: SamDatabase): UserProfileRepository {
        return RoomUserProfileRepository(database.userProfileDao())
    }
}
