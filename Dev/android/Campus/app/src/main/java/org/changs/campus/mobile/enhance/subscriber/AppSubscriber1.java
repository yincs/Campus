package org.changs.campus.mobile.enhance.subscriber;

import org.changs.campus.mobile.app.AppToast;
import org.changs.campus.mobile.domain.AppRes;
import org.changs.campus.mobile.enhance.exception.CampusException;

import rx.Subscriber;

/**
 * Created by yincs on 2016/11/5.
 * 有提示错误功能
 */

public abstract class AppSubscriber1<T> extends AppSubscriber<T> {
    private static final String TAG = "AppSubscriber";


    public abstract void onSuccess(T t);

    @Override
    public void onFail(Throwable e) {
        if (e instanceof CampusException) {
            AppToast.tip(e.getMessage());
        }
    }
}
