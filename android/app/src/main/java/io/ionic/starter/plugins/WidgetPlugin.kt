package io.ionic.starter.plugins

import android.appwidget.AppWidgetManager
import android.content.Context
import android.content.Intent
import com.getcapacitor.Plugin
import com.getcapacitor.PluginCall
import com.getcapacitor.PluginMethod
import com.getcapacitor.annotation.CapacitorPlugin

@CapacitorPlugin(name = "WidgetPlugin")
class WidgetPlugin : Plugin() {

  @PluginMethod
  fun updateWidget(call: PluginCall) {
    val data = call.getString("data") ?: run {
      call.reject("Data is required")
      return
    }
    val intent = Intent(context, WeatherWidgetsReceiver::class.java)
    intent.action = AppWidgetManager.ACTION_APPWIDGET_UPDATE
    context.sendBroadcast(intent)
    val sharedPref = getContext().getSharedPreferences("widget_prefs", Context.MODE_PRIVATE)
    sharedPref.edit().putString("widgetData", data).apply()

    call.resolve()
  }
}
