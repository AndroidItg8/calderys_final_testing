# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

-keepattributes Signature
-keepattributes *Annotation*
-keep class com.squareup.okhttp.** { *; }
-keep interface com.squareup.okhttp.** { *; }
-dontwarn com.squareup.okhttp.**
-dontwarn okhttp3.internal.platform.*

-dontwarn rx.**
-dontwarn retrofit.**
-dontwarn okio.**
-dontwarn retrofit2.Platform$Java8
-keep class retrofit.** { *; }
-keep class ss.com.bannerslider.** { *;}
-dontwarn ss.com.bannerslider.**
-keepclasseswithmembers class * {
    @retrofit.http.* <methods>;
}

-keep class com.google.gson.** { *; }
-keepclassmembers enum * { *; }

-keepattributes *Annotation*
-keepclassmembers class ** {
    @org.greenrobot.eventbus.Subscribe <methods>;
}
-keep enum org.greenrobot.eventbus.ThreadMode { *; }

-keep class com.itg.calderysapp.caldNet.newIndent.intent.model.** { *; }
-keep class com.itg.calderysapp.caldNet.newIndent.Deetails.model.** { *; }
-keep class com.itg.calderysapp.caldNet.newIndent.Deetails.sa_model.** { *; }
-keep class com.itg.calderysapp.caldNet.newIndent.home.model.** { *; }
-keep class com.itg.calderysapp.caldNet.newIndent.createIntent.model.** { *; }
-keep class com.itg.calderysapp.caldNet.newIndent.consignee.model.** { *; }
-keep class com.itg.calderysapp.caldNet.newIndent.addmaterial.model.** { *; }
