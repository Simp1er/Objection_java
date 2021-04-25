package com.example.objection;

import android.content.Context;
import android.content.Intent;

public class intent {



    public void startActivity(Context ctx,String className){
        try {
            Class clz = this.getClass().getClassLoader().loadClass(className).getClass();
            Intent intent = new Intent(ctx, clz);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            ctx.startActivity(intent);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void start_Service(Context ctx, String serviceName){
        try {
            Class clz = this.getClass().getClassLoader().loadClass(serviceName).getClass();
            Intent intent = new Intent(ctx, clz);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            ctx.startService(intent);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
