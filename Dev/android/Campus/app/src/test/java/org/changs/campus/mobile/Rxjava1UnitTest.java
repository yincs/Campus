package org.changs.campus.mobile;

import org.junit.Test;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by yincs on 2016/11/9.
 */

public class Rxjava1UnitTest {

    @Test
    public void test() {
        long str = System.currentTimeMillis();
        Observable.just("aa")
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(String s) {
                        System.out.println("onNext " + s);
                    }
                });

        System.out.println("use time = " + (System.currentTimeMillis() - str));
    }
}
