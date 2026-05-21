package com.sam.app.di

import android.content.Context
import com.sam.domain.voice.SpeechInputInterface
import com.sam.domain.voice.SpeechOutputInterface
import com.sam.voice.AndroidSpeechInputEngine
import com.sam.voice.AndroidSpeechOutputEngine
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object VoiceModule {

    @Provides
    @Singleton
    fun provideSpeechInputInterface(
        @ApplicationContext context: Context
    ): SpeechInputInterface {
        return AndroidSpeechInputEngine(context)
    }

    @Provides
    @Singleton
    fun provideSpeechOutputInterface(
        @ApplicationContext context: Context
    ): SpeechOutputInterface {
        return AndroidSpeechOutputEngine(context)
    }
}
