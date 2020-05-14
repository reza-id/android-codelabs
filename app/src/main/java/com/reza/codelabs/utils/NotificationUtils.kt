package com.reza.codelabs.utils

import android.app.NotificationManager
import android.content.Context
import androidx.core.app.NotificationCompat
import com.reza.codelabs.R

// Notification ID.
private const val NOTIFICATION_ID = 0
private const val REQUEST_CODE = 0
private const val FLAGS = 0

// TODO: Step 1.1 extension function to send messages (GIVEN)
/**
 * Builds and delivers a notification.
 *
 * @param messageBody, notification text.
 * @param context, activity context.
 */
fun NotificationManager.sendNotification(messageBody: String, context: Context) {

    // TODO: Step 1.2 get an instance of NotificationCompat.Builder
    val builder = NotificationCompat.Builder(context, context.getString(R.string.egg_notification_channel_id))

        // TODO: Step 1.3 set title, text and icon to builder
        .setSmallIcon(R.drawable.cooked_egg)
        .setContentTitle(context.getString(R.string.notification_title))
        .setContentText(messageBody)

    // TODO: Step 1.4 call notify
    notify(NOTIFICATION_ID, builder.build())
}
