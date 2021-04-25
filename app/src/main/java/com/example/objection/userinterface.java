package com.example.objection;

public class userinterface {

    public static void screenshot(){
        try {
            ClassLoader loader = userinterface.class.getClassLoader();
            Class<?> activityThread = loader.loadClass("android.app.ActivityThread");
            Class activity = loader.loadClass("android.app.Activity");

            Class activityClientRecord = loader.loadClass("android.app.ActivityThread$ActivityClientRecord");

//
//            Method currentActivityThread_mid = activityThread.getDeclaredMethod("currentActivityThread")
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
