package com.reza.codelabs

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.os.Bundle
import android.widget.RemoteViews
import androidx.navigation.NavDeepLinkBuilder

class DeepLinkAppWidgetProvider : AppWidgetProvider() {
    override fun onUpdate(
        context: Context?,
        appWidgetManager: AppWidgetManager?,
        appWidgetIds: IntArray?
    ) {
        val remoteViews = RemoteViews(
            context?.packageName,
            R.layout.deep_link_appwidget
        )

        val args = Bundle()
        args.putString("myarg", "From Widget")

        val pendingIntent = NavDeepLinkBuilder(context!!)
            .setGraph(R.navigation.nav_graph)
            .setDestination(R.id.dest_deeplink)
            .setArguments(args)
            .createPendingIntent()

        remoteViews.setOnClickPendingIntent(R.id.bt_deeplink, pendingIntent)

        appWidgetManager?.updateAppWidget(appWidgetIds, remoteViews)
    }
}
