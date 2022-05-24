package com.ecar.util;

import android.util.Log;


import static android.content.ContentValues.TAG;

public class TagUtil {
    public static boolean IS_SHOW_LOG = false;

    /**
     * 显示debug 数据
     *
     * @param str
     */
    public static void showLogDebug(String str) {
        if (IS_SHOW_LOG)
            Log.d(TAG, str);
    }

    /**
     * 显示debug 数据
     *
     * @param str
     */
    public static void showLogDebug(Class context, String str) {
        if (IS_SHOW_LOG)
            Log.d(TAG, "<" + context.getName().toString() + ">--" + str);
    }

    public static void showLogError(String str) {
        if (IS_SHOW_LOG)
            Log.e(TAG, str);
    }

    /**
     * 显示debug 数据
     *
     * @param str
     */
    public static void showLogError(Class context, String str) {
        if (IS_SHOW_LOG)
            Log.e(TAG, "<" + context.getName().toString() + ">--" + str);
    }

    public static void showLogDebug(String tag, String content) {
        if (IS_SHOW_LOG)
            Log.d(tag, content);
    }

    public static void printResult(String result) {
        TagUtil.showLogDebug(result == null ? "加密后结果为空" : "加密后结果".concat(result));
    }
}
