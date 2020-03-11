package com.reza.codelabs

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.os.Bundle
import android.widget.RemoteViews

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

        appWidgetManager?.updateAppWidget(appWidgetIds, remoteViews)
    }
}
