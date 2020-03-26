package com.reza.codelabs

import android.app.PendingIntent
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.IBinder
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

const val ACTION_SCHEDULE = "com.telkom.traceandcare.ACTION_SCHEDULE"

class MyForegroundService : Service() {

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        val notificationIntent = Intent(this, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0)

        if (intent?.action == ACTION_SCHEDULE) {
            pendingIntentNotification(this)
        } else {
            val notification = NotificationCompat.Builder(this, CHANNEL_ID)
                .setContentTitle("Selamat! Anda sedang ikut berkontribusi!")
                .setContentText("Restart handphone Anda jika notifikasi ini menghilang.")
                .setSmallIcon(R.drawable.ic_stars)
                .setContentIntent(pendingIntent)
                .build()

            startForeground(NOTIFICATION_ID, notification)
        }

        // TODO: doing some work here in the background

        return START_STICKY
    }

    private fun pendingIntentNotification(context: Context) {
        val contentIntent = Intent(context, MainActivity::class.java)
        val contentPendingIntent = PendingIntent.getActivity(context, NOTIFICATION_ID, contentIntent, PendingIntent.FLAG_UPDATE_CURRENT)

        val builder = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_stars)
            .setContentTitle("HOREEEE")
            .setContentText("Ini alarm dari Pending Intent")
            .setContentIntent(contentPendingIntent)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setAutoCancel(true)
            .setDefaults(NotificationCompat.DEFAULT_ALL)

        with(NotificationManagerCompat.from(this)) {
            // notificationId is a unique int for each notification that you must define
            notify(NOTIFICATION_ID, builder.build())
        }
    }

    override fun onBind(intent: Intent?): IBinder? = null

}