package com.reza.codelabs


import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.NotificationCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_deeplink.*

/**
 * A simple [Fragment] subclass.
 */
class DeeplinkFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_deeplink, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tv_text?.text = arguments?.getString("myarg")

        bt_send_notification.setOnClickListener {
            val args = Bundle()
            args.putString("myarg", et_args.text.toString())

            val deeplink = findNavController().createDeepLink()
                .setDestination(R.id.dest_deeplink)
                .setArguments(args)
                .createPendingIntent()

            val notificationManager =
                context?.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                notificationManager.createNotificationChannel(
                    NotificationChannel(
                        "deeplink", "Deep Links", NotificationManager.IMPORTANCE_HIGH
                    )
                )
            }

            val builder = NotificationCompat.Builder(
                context!!, "deeplink"
            )
                .setContentTitle("Navigation")
                .setContentText("Deep link to Android")
                .setSmallIcon(R.drawable.ic_android)
                .setContentIntent(deeplink)
                .setAutoCancel(true)
            notificationManager.notify(0, builder.build())
        }
    }

}
