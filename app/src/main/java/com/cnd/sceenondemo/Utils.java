package com.cnd.sceenondemo;

import android.util.Log;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * set node tools:设置节点工具类
 */
public class Utils {
    private static final String TAG="Utils:xwg";
    /**
     写入节点值
     **/
    public static void setNodeString(String path,String value){
        try {
            BufferedWriter bufWriter = null;
            bufWriter = new BufferedWriter(new FileWriter(path));
            bufWriter.write(value);  // 写入数据
            bufWriter.close();
            Log.e(TAG,"write scuess!");
        } catch (IOException e) {
            e.printStackTrace();
            Log.e(TAG,"write failed!");
        }
    }
}
