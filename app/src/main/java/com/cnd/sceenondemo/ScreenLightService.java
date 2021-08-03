package com.cnd.sceenondemo;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class ScreenLightService extends Service {
    private IntentFilter intentFilter2;
    private ScreenBroadcastReceiver receiver2;
    private static final String TAG="ScreenLightService:xwg";
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG,"screenlight service onBind");
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG,"screenlight service oncreate");
        intentFilter2=new IntentFilter();
        intentFilter2.addAction(Intent.ACTION_SCREEN_ON);
        intentFilter2.addAction(Intent.ACTION_SCREEN_OFF);
        intentFilter2.addAction(Intent.ACTION_USER_PRESENT);
        receiver2=new ScreenBroadcastReceiver();
        registerReceiver(receiver2,intentFilter2);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG,"screenlight service onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.i(TAG,"screenlight service onDestroy");
        unregisterReceiver(receiver2);
        super.onDestroy();
    }
}
