package com.netease.toolslibrary.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by jiangcheng on 2018/2/28.
 */

public class ToastUtils {


    /**
     * 显示toast 提示
     * @param context
     * @param msg
     */
    public static void showToastMsg(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }
}
