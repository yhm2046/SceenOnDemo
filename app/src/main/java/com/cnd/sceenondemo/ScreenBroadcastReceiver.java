package com.cnd.sceenondemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class ScreenBroadcastReceiver extends BroadcastReceiver {
    private static final String TAG="ScreenBroadcastReceiver:xwg";
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG,"receiver log");
    }
}
