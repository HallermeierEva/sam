package com.sam.domain.nlp

import com.sam.domain.model.SessionType
import com.sam.domain.repository.SessionRepository
import com.sam.domain.repository.TaskRepository
import com.sam.domain.voice.SpeechInputInterface
import com.sam.domain.voice.SpeechOutputInterface
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

class ConversationManagerImpl @Inject constructor(
    private val speechInput: SpeechInputInterface,
    private val speechOutput: SpeechOutputInterface,
    private val promptProvider: PromptProvider,
    private val llmEngine: LlmEngine,
    private val taskRepository: TaskRepository,
    private val sessionRepository: SessionRepository
) : ConversationManager {

    private val managerScope = CoroutineScope(Dispatchers.IO + Job())

    private val _systemResponses = MutableSharedFlow<String>(extraBufferCapacity = 1)
    override val systemResponses: Flow<String> = _systemResponses.asSharedFlow()

    private val _sessionCompleted = MutableStateFlow(false)
    override val sessionCompleted: Flow<Boolean> = _sessionCompleted.asStateFlow()

    private var activeSessionType: SessionType? = null
    private var activeLanguageCode: String = "en"
    private var transcriptBuilder = StringBuilder()

    init {
        speechInput.speechResults.onEach { text ->
            processUserInput(text)
        }.launchIn(managerScope)

        speechInput.errors.onEach { error ->
            val fallback = promptProvider.getFallbackMessage(activeLanguageCode)
            speechOutput.speak(fallback, activeLanguageCode)
            _systemResponses.tryEmit(fallback)
        }.launchIn(managerScope)
    }

    override fun startSession(sessionType: SessionType, languageCode: String, persona: String) {
        activeSessionType = sessionType
        activeLanguageCode = languageCode
        transcriptBuilder.clear()
        _sessionCompleted.value = false

        val greeting = promptProvider.getGreeting(sessionType, languageCode, persona)
        _systemResponses.tryEmit(greeting)

        speechOutput.speak(greeting, languageCode) {
            speechInput.startListening(languageCode)
        }
    }

    override fun processUserInput(text: String) {
        if (activeSessionType == null) return
        transcriptBuilder.append(text).append(" ")

        managerScope.launch {
            val response = llmEngine.generateResponse(text)
            _systemResponses.tryEmit(response)
            speechOutput.speak(response, activeLanguageCode) {
                // Determine if we should continue listening or end based on response
                // For this stub, we just ask for another prompt
                val followUp = promptProvider.getPrompt(activeSessionType!!, activeLanguageCode)
                speechOutput.speak(followUp, activeLanguageCode) {
                    speechInput.startListening(activeLanguageCode)
                }
            }
        }
    }

    override fun endSession() {
        speechInput.stopListening()
        speechOutput.stopSpeaking()

        val type = activeSessionType ?: return
        val transcript = transcriptBuilder.toString()

        managerScope.launch {
            if (type == SessionType.MORNING_PLANNING || type == SessionType.MANUAL) {
                val tasks = llmEngine.parseTasksFromTranscript(transcript)
                tasks.forEach { task ->
                    taskRepository.saveTask(task)
                }
            }

            val session = llmEngine.generateSessionSummary(transcript, type)
            sessionRepository.saveSession(session)

            _sessionCompleted.value = true
            activeSessionType = null
        }
    }

    fun destroy() {
        managerScope.cancel()
        speechInput.destroy()
        speechOutput.shutdown()
    }
}
