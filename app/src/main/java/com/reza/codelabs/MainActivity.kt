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
        val notifyIntent = Intent(this, AlarmReceiver::class.java)
        val alarmIntent = PendingIntent.getBroadcast(this, NOTIFICATION_ID, notifyIntent, PendingIntent.FLAG_UPDATE_CURRENT)

        val alarmManager: AlarmManager? = getSystemService(Context.ALARM_SERVICE) as AlarmManager?

        val isAlarmUp = (PendingIntent.getBroadcast(
            this, NOTIFICATION_ID, notifyIntent,
            PendingIntent.FLAG_NO_CREATE
        ) != null)

        alarmToggle.isChecked = isAlarmUp

        alarmToggle.setOnCheckedChangeListener { buttonView, isChecked ->
            var toastMessage = ""
            toastMessage = if (isChecked) {

                // Set the alarm to start at approximately 2:00 p.m.
                val calendar: Calendar = Calendar.getInstance().apply {
                    timeInMillis = System.currentTimeMillis()
                    set(Calendar.HOUR_OF_DAY, 20)
                    set(Calendar.MINUTE, 48)
                }
                Log.d("REZAAA", "Next notify = ${calendar.time}")
                // With setInexactRepeating(), you have to use one of the AlarmManager interval
                // constants--in this case, AlarmManager.INTERVAL_DAY.
                alarmManager?.setInexactRepeating(
                    AlarmManager.RTC_WAKEUP,
                    calendar.timeInMillis,
                    AlarmManager.INTERVAL_DAY,
                    alarmIntent
                )

                "Hurung!!!"
            } else {
                mNotificationManager.cancelAll()
                alarmManager?.cancel(alarmIntent)

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
}
