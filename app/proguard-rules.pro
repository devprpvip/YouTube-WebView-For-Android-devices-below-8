# Keep WebView
-keep class android.webkit.** { *; }
-keepclassmembers class android.webkit.** { *; }

# Keep MainActivity
-keep class com.youtube.viewer.MainActivity { *; }

# General
-keep class * extends android.app.Activity
-keep class * extends android.webkit.WebViewClient
