package org.changs.campus.mobile.enhance.subscriber;

import android.util.Log;

import org.changs.campus.mobile.app.AppToast;
import org.changs.campus.mobile.domain.AppRes;
import org.changs.campus.mobile.enhance.exception.CampusException;

import rx.Subscriber;

/**
 * Created by yincs on 2016/11/5.
 */

public abstract class AppSubscriber<T> extends Subscriber<AppRes<T>> {
    private static final String TAG = "AppSubscriber";

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        onFail(e);
    }

    @Override
    public final void onNext(AppRes<T> tAppRes) {
        if (tAppRes.getCode() != 0) {
            throw new CampusException(tAppRes.getDes());
        }
        onSuccess(tAppRes.getData());
    }


    public abstract void onSuccess(T t);

    public abstract void onFail(Throwable e);
}
