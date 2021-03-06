package com.daoyixun.irobot;

import android.app.Application;
import android.content.Context;

import com.daoyixun.robot.IpsMapRobotSDK;


/**
 * author:chen
 * time:2017/10/11
 * desc:
 */
public class App extends Application {

    private static App app;
    public static Context context;

    @Override
    public void onCreate() {
        context = this;
        super.onCreate();
        IpsMapRobotSDK.init(new IpsMapRobotSDK.Configuration.Builder(context)
                .debug(true)
                .vioceCallBack(true)
                //预览模式下不需要激活码
//                .preview()
                .build());
    }

}
