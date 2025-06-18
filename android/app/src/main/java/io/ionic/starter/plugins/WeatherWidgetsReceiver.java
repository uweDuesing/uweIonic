package io.ionic.starter.plugins;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.widget.RemoteViews;
import android.util.Log;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import io.ionic.starter.R;
import android.app.PendingIntent;
import android.content.Intent;
public class WeatherWidgetsReceiver extends AppWidgetProvider {

  private static final String TAG = "WeatherWidget";

  static void updateAppWidget(Context context, AppWidgetManager appWidgetManager, int appWidgetId) {

    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
    String currentTime = sdf.format(new Date());

    RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget_hello_world);

    views.setTextViewText(R.id.widget_title, "Title!");

    // Create an Intent to launch the app
    Intent launchIntent = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
    if (launchIntent != null) {
      PendingIntent pendingIntent = PendingIntent.getActivity(
        context,
        0,
        launchIntent,
        PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE
      );

      // Set the click action on the whole widget or a specific view
      views.setOnClickPendingIntent(R.id.widget_container, pendingIntent);
    }

    appWidgetManager.updateAppWidget(appWidgetId, views);
    Log.d(TAG, "Widget updated with ID: " + appWidgetId + " at " + currentTime);
  }

  @Override
  public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
    Log.d(TAG, "onUpdate called with " + appWidgetIds.length + " widgets");

    // Update each widget instance
    for (int appWidgetId : appWidgetIds) {
      updateAppWidget(context, appWidgetManager, appWidgetId);
    }
  }

  @Override
  public void onEnabled(Context context) {
    // Called when the first widget is created
    Log.d(TAG, "First widget enabled");
  }

  @Override
  public void onDisabled(Context context) {
    // Called when the last widget is removed
    Log.d(TAG, "Last widget disabled");
  }

  @Override
  public void onDeleted(Context context, int[] appWidgetIds) {
    // Called when widget instances are deleted
    Log.d(TAG, "Widgets deleted: " + appWidgetIds.length);
  }
}
