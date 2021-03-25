package com.example.lotteryone;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    /* Essentials for starting with Android Studio

    The min sdk version is the minimum version of the Android operating system required to run your application.
    The target sdk version is the version of Android that your app was created to run on.
    The compile sdk version is the the version of Android that the build tools uses to compile and build the application in order to release, run, or debug.
    Usually the compile sdk version and the target sdk version are the same.
    The formula is minSdkVersion <= targetSdkVersion <= compileSdkVersion

    Android APK creation process: https://www.quora.com/What-exactly-happens-during-an-Android-APK-creation-build-process

    Build options in Android Studio: https://developer.android.com/studio/run

    Git and Github integration in Android Studio: https://www.youtube.com/watch?v=bcduIvadmPo

    Debugging with Android Studio: https://www.youtube.com/watch?v=nBaL78HC0ls

    Where is R.java (Project view)? app/build/generated/not_namespaced_r_class_sources/debug/r/com/example/lotteryone/R.java

    Essentials for Debugging:
    Step Over command: This command lets the application execute the next action. If the action involves a call to an operation, it does not step into its implementation (it steps over it instead).
    Step Into command: This command lets the application execute the next action. If the action involves a call to an operation, it steps into its implementation and breaks the execution on the first action of that implementation.
    Step Out command: This command lets the application execute until the currently executed operation implementation is returned.
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
