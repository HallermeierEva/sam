package com.sam.context

import android.content.Context
import com.sam.domain.context.CommuteDetector
import com.sam.domain.model.CommuteContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class LocationTimeCommuteDetector(private val context: Context) : CommuteDetector {

    private val _currentContext = MutableStateFlow(CommuteContext.IDLE)
    override val currentContext: Flow<CommuteContext> = _currentContext.asStateFlow()

    override fun startMonitoring() {
        // Stub: In a real implementation, this would request location updates
        // and check time/geofences.
        _currentContext.value = CommuteContext.UNKNOWN
    }

    override fun stopMonitoring() {
        // Stub: stop location updates
        _currentContext.value = CommuteContext.IDLE
    }
}
