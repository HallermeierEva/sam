package com.sam.domain.nlp

import com.sam.domain.model.Session
import com.sam.domain.model.SessionType
import com.sam.domain.model.Task

interface LlmEngine {
    suspend fun generateResponse(prompt: String): String
    suspend fun parseTasksFromTranscript(transcript: String): List<Task>
    suspend fun generateSessionSummary(transcript: String, type: SessionType): Session
}
