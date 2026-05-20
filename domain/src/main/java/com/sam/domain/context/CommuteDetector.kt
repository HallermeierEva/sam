package com.sam.domain.context

import com.sam.domain.model.CommuteContext
import kotlinx.coroutines.flow.Flow

interface CommuteDetector {
    val currentContext: Flow<CommuteContext>
    fun startMonitoring()
    fun stopMonitoring()
}
