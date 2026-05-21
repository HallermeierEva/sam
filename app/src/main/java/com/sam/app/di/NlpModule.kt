package com.sam.app.di

import android.content.Context
import com.sam.domain.nlp.PromptProvider
import com.sam.nlp.AndroidPromptProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NlpModule {

    @Provides
    @Singleton
    fun providePromptProvider(
        @ApplicationContext context: Context
    ): PromptProvider {
        return AndroidPromptProvider(context)
    }
}
