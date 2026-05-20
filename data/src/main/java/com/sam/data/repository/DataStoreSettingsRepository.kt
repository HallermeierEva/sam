package com.sam.data.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.sam.domain.repository.SettingsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DataStoreSettingsRepository(
    private val dataStore: DataStore<Preferences>
) : SettingsRepository {

    private object PreferencesKeys {
        val ONBOARDING_COMPLETED = booleanPreferencesKey("onboarding_completed")
        val SELECTED_LANGUAGE = stringPreferencesKey("selected_language")
        val SELECTED_PERSONA = stringPreferencesKey("selected_persona")
        val PROACTIVITY_ENABLED = booleanPreferencesKey("proactivity_enabled")
    }

    override val isOnboardingCompleted: Flow<Boolean> = dataStore.data
        .map { preferences ->
            preferences[PreferencesKeys.ONBOARDING_COMPLETED] ?: false
        }

    override suspend fun setOnboardingCompleted(completed: Boolean) {
        dataStore.edit { preferences ->
            preferences[PreferencesKeys.ONBOARDING_COMPLETED] = completed
        }
    }

    override val selectedLanguage: Flow<String> = dataStore.data
        .map { preferences ->
            preferences[PreferencesKeys.SELECTED_LANGUAGE] ?: "en" // Default to English
        }

    override suspend fun setSelectedLanguage(languageCode: String) {
        dataStore.edit { preferences ->
            preferences[PreferencesKeys.SELECTED_LANGUAGE] = languageCode
        }
    }

    override val selectedPersona: Flow<String> = dataStore.data
        .map { preferences ->
            preferences[PreferencesKeys.SELECTED_PERSONA] ?: "Sam"
        }

    override suspend fun setSelectedPersona(persona: String) {
        dataStore.edit { preferences ->
            preferences[PreferencesKeys.SELECTED_PERSONA] = persona
        }
    }

    override val isProactivityEnabled: Flow<Boolean> = dataStore.data
        .map { preferences ->
            preferences[PreferencesKeys.PROACTIVITY_ENABLED] ?: false
        }

    override suspend fun setProactivityEnabled(enabled: Boolean) {
        dataStore.edit { preferences ->
            preferences[PreferencesKeys.PROACTIVITY_ENABLED] = enabled
        }
    }
}
