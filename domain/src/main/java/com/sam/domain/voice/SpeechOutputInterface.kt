package com.sam.domain.voice

interface SpeechOutputInterface {
    fun speak(text: String, languageCode: String, onComplete: () -> Unit = {})
    fun stopSpeaking()
    fun shutdown()
}
