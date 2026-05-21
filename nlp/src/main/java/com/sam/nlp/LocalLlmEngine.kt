package com.sam.nlp

import com.sam.domain.model.Session
import com.sam.domain.model.SessionType
import com.sam.domain.model.Task
import kotlinx.coroutines.delay
import java.util.UUID

class LocalLlmEngine {

    // This is a stub for the on-device LLM engine.
    suspend fun generateResponse(prompt: String): String {
        // Simulate inference delay
        delay(1000)
        return "I heard: $prompt. This is a generated response."
    }

    suspend fun parseTasksFromTranscript(transcript: String): List<Task> {
        delay(500)
        // Stub: In reality, the LLM extracts tasks from the string.
        if (transcript.contains("buy groceries", ignoreCase = true)) {
            return listOf(
                Task(
                    id = UUID.randomUUID().toString(),
                    title = "Buy groceries",
                    description = "Extracted from session transcript",
                    isCompleted = false,
                    createdAt = System.currentTimeMillis()
                )
            )
        }
        return emptyList()
    }

    suspend fun generateSessionSummary(transcript: String, type: SessionType): Session {
        delay(800)
        // Stub: The LLM summarizes the conversation.
        return Session(
            id = UUID.randomUUID().toString(),
            type = type,
            summary = "Summary of conversation: $transcript",
            timestamp = System.currentTimeMillis()
        )
    }
}
