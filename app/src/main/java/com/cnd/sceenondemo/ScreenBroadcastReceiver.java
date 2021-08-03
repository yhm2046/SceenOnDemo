package com.cnd.sceenondemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import static com.cnd.sceenondemo.Utils.setNodeString;

public class ScreenBroadcastReceiver extends BroadcastReceiver {
    private static final String TAG="ScreenBroadcastReceiver:xwg";
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (Intent.ACTION_SCREEN_ON.equals(action)) {
            // 亮屏灯灭，value=0
            Log.i(TAG,"ACTION_SCREEN_ON，light off");
            setNodeString("/sys/devices/platform/gpio-ctl/gpio_led1/value","0");
        } else if (Intent.ACTION_SCREEN_OFF.equals(action)) {
            // 息屏灯亮，value=1
            Log.i(TAG,"ACTION_SCREEN_OFF,，light on");
            setNodeString("/sys/devices/platform/gpio-ctl/gpio_led1/value","1");
        } else if (Intent.ACTION_USER_PRESENT.equals(action)) {
            Log.i(TAG,"ACTION_USER_PRESENT");
            // 解锁
        }
    }
}
