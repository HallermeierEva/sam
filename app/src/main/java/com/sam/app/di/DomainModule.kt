package com.sam.app.di

import com.sam.domain.nlp.ConversationManager
import com.sam.domain.nlp.ConversationManagerImpl
import com.sam.domain.nlp.LlmEngine
import com.sam.domain.nlp.PromptProvider
import com.sam.domain.repository.SessionRepository
import com.sam.domain.repository.TaskRepository
import com.sam.domain.voice.SpeechInputInterface
import com.sam.domain.voice.SpeechOutputInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Provides
    @Singleton
    fun provideConversationManager(
        speechInput: SpeechInputInterface,
        speechOutput: SpeechOutputInterface,
        promptProvider: PromptProvider,
        llmEngine: LlmEngine,
        taskRepository: TaskRepository,
        sessionRepository: SessionRepository
    ): ConversationManager {
        return ConversationManagerImpl(
            speechInput,
            speechOutput,
            promptProvider,
            llmEngine,
            taskRepository,
            sessionRepository
        )
    }
}
