package com.sam.app.di

import android.content.Context
import com.sam.context.LocationTimeCommuteDetector
import com.sam.domain.context.CommuteDetector
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ContextModule {

    @Provides
    @Singleton
    fun provideCommuteDetector(
        @ApplicationContext context: Context
    ): CommuteDetector {
        return LocationTimeCommuteDetector(context)
    }
}
