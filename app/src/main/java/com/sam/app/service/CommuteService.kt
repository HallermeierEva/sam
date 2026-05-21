package com.sam.app.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.sam.app.notifications.NotificationHelper
import com.sam.domain.context.CommuteDetector
import com.sam.domain.model.CommuteContext
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@AndroidEntryPoint
class CommuteService : Service() {

    @Inject
    lateinit var commuteDetector: CommuteDetector

    private val serviceScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
    private lateinit var notificationHelper: NotificationHelper

    override fun onCreate() {
        super.onCreate()
        notificationHelper = NotificationHelper(this)

        commuteDetector.currentContext
            .onEach { context ->
                when (context) {
                    CommuteContext.MORNING_COMMUTE -> {
                        notificationHelper.showSoftPrompt(
                            "Morning Commute Detected",
                            "Would you like to plan your day, Sam?"
                        )
                    }
                    CommuteContext.EVENING_COMMUTE -> {
                        notificationHelper.showSoftPrompt(
                            "Evening Commute Detected",
                            "Would you like to debrief your day?"
                        )
                    }
                    else -> {
                        // Do nothing
                    }
                }
            }
            .launchIn(serviceScope)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        commuteDetector.startMonitoring()
        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        commuteDetector.stopMonitoring()
        serviceScope.cancel()
    }

    override fun onBind(intent: Intent?): IBinder? = null
}
