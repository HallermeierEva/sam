package com.sam.domain.nlp

import com.sam.domain.model.SessionType

interface PromptProvider {
    fun getGreeting(sessionType: SessionType, languageCode: String, persona: String): String
    fun getPrompt(sessionType: SessionType, languageCode: String): String
    fun getFallbackMessage(languageCode: String): String
}
