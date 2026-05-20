package com.sam.nlp

import android.content.Context
import com.sam.domain.model.SessionType
import com.sam.domain.nlp.PromptProvider

class AndroidPromptProvider(private val context: Context) : PromptProvider {

    override fun getGreeting(sessionType: SessionType, languageCode: String, persona: String): String {
        return when (languageCode) {
            "fr" -> {
                when (sessionType) {
                    SessionType.MORNING_PLANNING -> "Bonjour! Je suis $persona. Prêt à planifier votre journée?"
                    SessionType.EVENING_DEBRIEF -> "Bonsoir. Comment s'est passée votre journée?"
                    SessionType.MANUAL -> "Bonjour. Comment puis-je vous aider?"
                }
            }
            else -> { // Default to English
                when (sessionType) {
                    SessionType.MORNING_PLANNING -> "Good morning! I'm $persona. Ready to plan your day?"
                    SessionType.EVENING_DEBRIEF -> "Good evening. How was your day?"
                    SessionType.MANUAL -> "Hello. How can I help you?"
                }
            }
        }
    }

    override fun getPrompt(sessionType: SessionType, languageCode: String): String {
        return when (languageCode) {
            "fr" -> "Que voulez-vous accomplir?"
            else -> "What do you want to accomplish?"
        }
    }

    override fun getFallbackMessage(languageCode: String): String {
        return when (languageCode) {
            "fr" -> "Désolé, je n'ai pas compris."
            else -> "Sorry, I didn't catch that."
        }
    }
}
