package com.sam.domain.repository

import kotlinx.coroutines.flow.Flow

interface SettingsRepository {
    val isOnboardingCompleted: Flow<Boolean>
    suspend fun setOnboardingCompleted(completed: Boolean)

    val selectedLanguage: Flow<String>
    suspend fun setSelectedLanguage(languageCode: String)

    val selectedPersona: Flow<String>
    suspend fun setSelectedPersona(persona: String)

    val isProactivityEnabled: Flow<Boolean>
    suspend fun setProactivityEnabled(enabled: Boolean)
}
