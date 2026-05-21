package com.sam.ui.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sam.domain.repository.SettingsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnboardingViewModel @Inject constructor(
    private val settingsRepository: SettingsRepository
) : ViewModel() {

    fun setLanguage(language: String) {
        viewModelScope.launch {
            settingsRepository.setSelectedLanguage(language)
        }
    }

    fun setPersona(persona: String) {
        viewModelScope.launch {
            settingsRepository.setSelectedPersona(persona)
        }
    }

    fun setProactivity(enabled: Boolean) {
        viewModelScope.launch {
            settingsRepository.setProactivityEnabled(enabled)
        }
    }

    fun completeOnboarding() {
        viewModelScope.launch {
            settingsRepository.setOnboardingCompleted(true)
        }
    }
}
