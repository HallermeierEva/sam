package com.sam.domain.voice

import kotlinx.coroutines.flow.Flow

interface SpeechInputInterface {
    val speechResults: Flow<String>
    val errors: Flow<String>
    fun startListening(languageCode: String)
    fun stopListening()
    fun destroy()
}
