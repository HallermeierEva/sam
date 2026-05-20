package com.sam.domain.nlp

import com.sam.domain.model.SessionType
import kotlinx.coroutines.flow.Flow

interface ConversationManager {
    fun startSession(sessionType: SessionType, languageCode: String, persona: String)
    fun processUserInput(text: String)
    fun endSession()
    val systemResponses: Flow<String>
    val sessionCompleted: Flow<Boolean>
}
