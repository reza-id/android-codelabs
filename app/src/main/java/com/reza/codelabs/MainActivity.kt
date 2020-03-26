package com.reza.codelabs

import android.app.NotificationManager
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var mNotificationManager: NotificationManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mNotificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager

        alarmToggle.setOnCheckedChangeListener { buttonView, isChecked ->
            var toastMessage = ""
            toastMessage = if (isChecked) {
                "Hurung!!!"
            } else {
                mNotificationManager.cancelAll()
                "Pareummmm!!!"
            }

            Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT).show()
        }
    }
}
