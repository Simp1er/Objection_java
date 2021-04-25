package com.example.objection;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SHELL {

    public static void exec(String cmd){

        try {
            Process command = Runtime.getRuntime().exec(cmd);

            // read stderr
            InputStreamReader stderrIsr = new InputStreamReader(command.getErrorStream());
            BufferedReader stderrBr = new BufferedReader(stderrIsr);
            StringBuilder stderrSb = new StringBuilder();
            String lineBuffer;
            while ((  lineBuffer = stderrBr.readLine() )!= null){
                stderrSb.append(lineBuffer + "\t");
            }
            Log.i("Objection", "exec stderr: " + stderrSb.toString());
            // read stdout
            InputStreamReader stdoutIsr = new InputStreamReader(command.getInputStream());
            BufferedReader stdoutBr = new BufferedReader(stdoutIsr);
            StringBuilder stdoutSb = new StringBuilder();
            String stdoutLineBuffer;
            while ((  stdoutLineBuffer = stdoutBr.readLine() )!= null){
                stdoutSb.append(stdoutLineBuffer + "\t");
            }
            Log.i("Objection", "exec stdout: " + stdoutSb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
