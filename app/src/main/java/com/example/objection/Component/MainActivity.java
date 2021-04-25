package com.example.objection.Component;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.objection.R;
import com.example.objection.SHELL;
import com.example.objection.hooking_list;

import static com.example.objection.clipboard.monitor;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SHELL.exec("ls");
        hooking_list.listServices(getApplicationContext());
    }

    @Override
    protected void onResume() {
        super.onResume();
        getClipboardData();
    }

    private void getClipboardData() {
        this.getWindow().getDecorView().post(new Runnable() {
            @Override
            public void run() {
                //把获取到的内容打印出来
                monitor(getApplicationContext());
            }
        });
    }

}