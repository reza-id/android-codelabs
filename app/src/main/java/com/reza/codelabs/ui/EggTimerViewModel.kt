package com.reza.codelabs.ui

import android.app.Application
import android.app.NotificationManager
import androidx.core.content.ContextCompat
import androidx.lifecycle.AndroidViewModel
import com.reza.codelabs.R
import com.reza.codelabs.utils.sendNotification

class EggTimerViewModel(private val app: Application) : AndroidViewModel(app) {

    init {
        // TODO: Step 1.5 get an instance of NotificationManager
        // and call sendNotification

        val notificationManager = ContextCompat.getSystemService(app, NotificationManager::class.java) as NotificationManager
        notificationManager.sendNotification(app.getString(R.string.timer_running), app)
    }
}
