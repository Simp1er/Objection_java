package com.example.objection;

import android.app.Application;
import android.bluetooth.BluetoothClass;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.util.ArrayMap;
import android.util.Log;

import androidx.annotation.RequiresApi;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;

import static android.content.pm.PackageManager.GET_ACTIVITIES;
import static android.content.pm.PackageManager.GET_RECEIVERS;
import static android.content.pm.PackageManager.GET_SERVICES;

public class hooking_list {
    public static void listActivities(Context ctx){
        try {
            ActivityInfo[] activityInfos =  ctx.getPackageManager()
                    .getPackageInfo(ctx.getPackageName(), GET_ACTIVITIES).activities;
            for (ActivityInfo info:
                 activityInfos) {
                Log.i("Objection", "listActivities: " + info.name);

            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            Log.i("Objection", "listActivities: " + e);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static void listRecviers(Context ctx){

        try {
            Class ActivityThread = Class.forName("android.app.ActivityThread");
            Method currentApplication_mid =  ActivityThread.getDeclaredMethod("currentApplication"); // static
            Field mLoadedApk_fid = Application.class.getDeclaredField("mLoadedApk");
            mLoadedApk_fid.setAccessible(true);
            Object currentApplication = currentApplication_mid.invoke(null,null);
            Object mLoadedApk = mLoadedApk_fid.get(currentApplication);

            Class LoadedApk = Class.forName("android.app.LoadedApk");
            Field mReceivers_fid = LoadedApk.getDeclaredField("mReceivers");
            /*
             private final ArrayMap<Context, ArrayMap<BroadcastReceiver, ReceiverDispatcher>> mReceivers= new ArrayMap<>();
             */
            mReceivers_fid.setAccessible(true);
            ArrayMap<Object,ArrayMap<Object,Object>> mReceviers = ((ArrayMap<Object,ArrayMap<Object,Object>>) mReceivers_fid.get(mLoadedApk));
            for (ArrayMap obj:
                 mReceviers.values()) {
                Set<Object> mReceivers = obj.keySet();
                for (Object mObj:
                     mReceivers) {
                    Log.i("Objection", "Reflection listRecviers: " + mObj.getClass().getName());
                }

            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        try {
            ActivityInfo[] activityInfos =  ctx.getPackageManager()
                    .getPackageInfo(ctx.getPackageName(), GET_RECEIVERS).receivers;
            if(activityInfos != null){
                for (ActivityInfo info:
                        activityInfos) {
                    Log.i("Objection", "listRecviers: " + info.name);

                }
            }

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            Log.i("Objection", "listRecviers: " + e);
        }
    }

    public static void listServices(Context ctx){

        try {
            Class ActivityThread = Class.forName("android.app.ActivityThread");
            Method currentApplication_mid =  ActivityThread.getDeclaredMethod("currentApplication"); // static
            Field mLoadedApk_fid = Application.class.getDeclaredField("mLoadedApk");
            mLoadedApk_fid.setAccessible(true);
            Object currentApplication = currentApplication_mid.invoke(null,null);
            Object mLoadedApk = mLoadedApk_fid.get(currentApplication);

            Class LoadedApk = Class.forName("android.app.LoadedApk");
            Field mServices_fid = LoadedApk.getDeclaredField("mServices");
            /*
             private final ArrayMap<Context, ArrayMap<BroadcastReceiver, ReceiverDispatcher>> mServices= new ArrayMap<>();
             */
            mServices_fid.setAccessible(true);
            ArrayMap<Object,ArrayMap<Object,Object>> mReceviers = ((ArrayMap<Object,ArrayMap<Object,Object>>) mServices_fid.get(mLoadedApk));
            for (ArrayMap obj:
                    mReceviers.values()) {
                Set<Object> mServices = obj.keySet();
                for (Object mObj:
                        mServices) {
                    Log.i("Objection", "Reflection listServices: " + mObj.getClass().getName());
                }

            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        try {
            ServiceInfo[] activityInfos =  ctx.getPackageManager()
                    .getPackageInfo(ctx.getPackageName(), GET_SERVICES).services;
            if(activityInfos != null){
                for (ServiceInfo info:
                        activityInfos) {
                    Log.i("Objection", "listServices: " + info.name);

                }
            }

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            Log.i("Objection", "listServices: " + e);
        }
    }
}
