package com.sam.voice

import android.content.Context
import android.speech.tts.TextToSpeech
import android.speech.tts.UtteranceProgressListener
import com.sam.domain.voice.SpeechOutputInterface
import java.util.Locale
import java.util.UUID

class AndroidSpeechOutputEngine(context: Context) : SpeechOutputInterface, TextToSpeech.OnInitListener {

    private var tts: TextToSpeech? = null
    private var isInitialized = false
    private var pendingText: String? = null
    private var pendingLanguageCode: String? = null
    private var currentOnComplete: (() -> Unit)? = null

    init {
        tts = TextToSpeech(context, this)
    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            isInitialized = true

            tts?.setOnUtteranceProgressListener(object : UtteranceProgressListener() {
                override fun onStart(utteranceId: String?) {}

                override fun onDone(utteranceId: String?) {
                    currentOnComplete?.invoke()
                    currentOnComplete = null
                }

                override fun onError(utteranceId: String?) {
                    currentOnComplete?.invoke()
                    currentOnComplete = null
                }
            })

            pendingText?.let { text ->
                pendingLanguageCode?.let { lang ->
                    speak(text, lang, currentOnComplete ?: {})
                }
            }
        }
    }

    override fun speak(text: String, languageCode: String, onComplete: () -> Unit) {
        currentOnComplete = onComplete

        if (!isInitialized || tts == null) {
            pendingText = text
            pendingLanguageCode = languageCode
            return
        }

        val locale = Locale(languageCode)
        val result = tts?.setLanguage(locale)

        if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
            onComplete()
            return
        }

        val utteranceId = UUID.randomUUID().toString()
        tts?.speak(text, TextToSpeech.QUEUE_FLUSH, null, utteranceId)
    }

    override fun stopSpeaking() {
        tts?.stop()
        currentOnComplete?.invoke()
        currentOnComplete = null
    }

    override fun shutdown() {
        tts?.stop()
        tts?.shutdown()
        tts = null
        isInitialized = false
    }
}
