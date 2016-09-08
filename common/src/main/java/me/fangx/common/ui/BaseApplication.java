package me.fangx.common.ui;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;

/**
 * Created by Administrator on 2016/8/22.
 */

public class BaseApplication extends Application {
    // 获取到主线程的上下文
    private static BaseApplication mContext = null;
    // 获取到主线程的handler
    private static Handler mMainThreadHandler = null;
    // 获取到主线程的looper
    private static Looper mMainThreadLooper = null;
    // 获取到主线程
    private static Thread mMainThead = null;
    // 获取到主线程的id
    private static int mMainTheadId;

    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    private void init() {
        mContext = this;
        mMainThreadHandler = new Handler();
        mMainThreadLooper = getMainLooper();
        mMainThead = Thread.currentThread();
        mMainTheadId = android.os.Process.myTid();
    }

    public static BaseApplication getApplication() {
        return mContext;
    }

    public static Handler getMainThreadHandler() {
        return mMainThreadHandler;
    }

    public static Looper getMainThreadLooper() {
        return mMainThreadLooper;
    }

    public static Thread getMainThread() {
        return mMainThead;
    }

    public static int getMainThreadId() {
        return mMainTheadId;
    }
}
