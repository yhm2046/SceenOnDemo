package com.cnd.sceenondemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private static final String TAG="MainActivity:xwg";
    private IntentFilter intentFilter,intentFilter2;
    private MyReceiver receiver;
    private ScreenBroadcastReceiver receiver2;
    private class MyReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            Log.i(TAG,"get the net bradcast..");
        }
    }
    private class ScreenBroadcastReceiver extends BroadcastReceiver {
        private String action = null;
        @Override
        public void onReceive(Context context, Intent intent) {
            action = intent.getAction();
            if (Intent.ACTION_SCREEN_ON.equals(action)) {
                // 开屏
                Log.i(TAG,"ACTION_SCREEN_ON，light off");
            } else if (Intent.ACTION_SCREEN_OFF.equals(action)) {
                // 锁屏
                Log.i(TAG,"ACTION_SCREEN_OFF,，light on");
            } else if (Intent.ACTION_USER_PRESENT.equals(action)) {
                Log.i(TAG,"ACTION_USER_PRESENT");
                // 解锁
            }
        }
    }

    /**
     写入节点值
     **/
    public static boolean setNodeString(String path,String value){
        try {
            BufferedWriter bufWriter = null;
            bufWriter = new BufferedWriter(new FileWriter(path));
            bufWriter.write(value);  // 写入数据
            bufWriter.close();
            Log.e(TAG,"write scuess!");
        } catch (IOException e) {
            e.printStackTrace();
            Log.e(TAG,"write failed!");
            return false;
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG,"onCreate");
//        whether screen is on?
        intentFilter=new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        receiver=new MyReceiver();
        registerReceiver(receiver,intentFilter);

        intentFilter2=new IntentFilter();
        intentFilter2.addAction(Intent.ACTION_SCREEN_ON);
        intentFilter2.addAction(Intent.ACTION_SCREEN_OFF);
        intentFilter2.addAction(Intent.ACTION_USER_PRESENT);
        receiver2=new ScreenBroadcastReceiver();
        registerReceiver(receiver2,intentFilter2);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"onDestory");
        unregisterReceiver(receiver);
        unregisterReceiver(receiver2);
    }
}