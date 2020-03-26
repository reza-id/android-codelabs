package com.reza.codelabs

import android.app.AlarmManager
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : AppCompatActivity() {

    private lateinit var mNotificationManager: NotificationManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mNotificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager

        val alarmManager: AlarmManager? = getSystemService(Context.ALARM_SERVICE) as AlarmManager?

        alarmToggle.setOnCheckedChangeListener { buttonView, isChecked ->
            var toastMessage = ""
            toastMessage = if (isChecked) {

                // Set the alarm to start at approximately 2:00 p.m.
                val calendar: Calendar = Calendar.getInstance().apply {
                    timeInMillis = System.currentTimeMillis()
                    set(Calendar.HOUR_OF_DAY, 22)
                    set(Calendar.MINUTE, 2)
                }
                Log.d("REZAAA", "Next notify = ${calendar.time}")
                // With setInexactRepeating(), you have to use one of the AlarmManager interval
                // constants--in this case, AlarmManager.INTERVAL_DAY.
                alarmManager?.setInexactRepeating(
                    AlarmManager.RTC_WAKEUP,
                    calendar.timeInMillis,
                    AlarmManager.INTERVAL_DAY,
                    intentToService()
                )

                "Hurung!!!"
            } else {
                mNotificationManager.cancelAll()
                alarmManager?.cancel(intentToService())

                "Pareummmm!!!"
            }

            Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT).show()
        }

        bt_startService.setOnClickListener { startService() }
    }

    private fun startService() {
        val serviceIntent = Intent(this, MyForegroundService::class.java)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            startForegroundService(serviceIntent)
        } else {
            startService(serviceIntent)
        }
    }

    private fun intentToService(): PendingIntent {
        val myIntent = Intent(this, MyForegroundService::class.java)
        myIntent.action = ACTION_SCHEDULE
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            PendingIntent.getForegroundService(
                this,
                NOTIFICATION_ID,
                myIntent,
                PendingIntent.FLAG_UPDATE_CURRENT
            )
        } else {
            PendingIntent.getService(
                this,
                NOTIFICATION_ID,
                myIntent,
                PendingIntent.FLAG_UPDATE_CURRENT
            )
        }
    }
}
