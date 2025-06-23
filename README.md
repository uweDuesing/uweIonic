# uweIonic
Example Ionic project for the use of a widget for Android


To create the widget involves

1. The actual ionic app
2. Thew created Android project
3. The Capacitor Plugin communicating between Ionic and the android environment https://github.com/uweDuesing/uweIonic/blob/main/android/app/src/main/java/io/ionic/starter/plugins/WidgetPlugin.kt
4. The WeatherWidgetsReceiver (WidgetReceiver) class https://github.com/uweDuesing/uweIonic/blob/main/android/app/src/main/java/io/ionic/starter/plugins/WeatherWidgetsReceiver.java This class ties the app and the widget togeher.
5. The widget class itself https://github.com/uweDuesing/uweIonic/blob/main/android/app/src/main/java/io/ionic/starter/widgets/HelloWorldWidget.java
6. The Layout file for the widget https://github.com/uweDuesing/uweIonic/blob/main/android/app/src/main/res/layout/widget_hello_world.xml
7. Another XML file for the default values https://github.com/uweDuesing/uweIonic/blob/main/android/app/src/main/res/xml/widget_hello_world_info.xml
8. An entry in the manifest file of the android project, referencing the receiver class https://github.com/uweDuesing/uweIonic/blob/b79d87e9690cd81e3b5d7a640ece1baa20dae336/android/app/src/main/AndroidManifest.xml#L27

