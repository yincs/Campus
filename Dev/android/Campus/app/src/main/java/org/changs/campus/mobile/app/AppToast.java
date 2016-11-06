package org.changs.campus.mobile.app;

import android.widget.Toast;

/**
 * Created by yincs on 2016/11/5.
 */

public class AppToast {

    public static void tip(String msg) {
        Toast.makeText(MyApplication.getContext(), msg, Toast.LENGTH_SHORT).show();
    }

}
