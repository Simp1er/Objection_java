package com.example.objection;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.util.Log;

public class clipboard {
    private final static String CLIPBOARD_SERVICE = "clipboard";
    private final static String TAG = "Objection";
    private static String data;
    public  static void monitor(Context context){

        ClipboardManager  cp = (ClipboardManager) context.getSystemService(CLIPBOARD_SERVICE);
        // const primaryClip = cp.getPrimaryClip();
        ClipData primaryClip = cp.getPrimaryClip();
        if (primaryClip == null || primaryClip.getItemCount() <= 0) {
            return;
        }
        String currentString = primaryClip.getItemAt(0).coerceToText(context).toString();
        if(!currentString.equals(data)){
            Log.i(TAG, "monitor: " + currentString);
        }
        data = currentString;
    }
}
