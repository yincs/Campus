package org.changs.campus.mobile;

import org.junit.Test;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;
import rx.schedulers.Schedulers;


/**
 * Created by yincs on 2016/11/7.
 */

public class RxUnitTest {

    private void logThreadName(String tag) {
        System.out.println(tag + ":" + Thread.currentThread());
    }

    private void logObject(String tag, Object obj) {
        String result;
        if (obj == null) {
            result = "null";
        } else {
            result = obj.toString();
        }
        System.out.println(tag + ":" + result);
    }

    @Test
    public void primer() {
        long str = System.currentTimeMillis();

        final Observable<String> observable1 = Observable.just("aa");
        final Subscriber<String> subscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                System.out.println(s);
            }
        };
        observable1.subscribe(subscriber);


        System.out.println("use time = " + (System.currentTimeMillis() - str));


        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void primer1() {
        long str = System.currentTimeMillis();

        Observable<String> observable1 = Observable.just("aa");
        Observable<String> observable2 = observable1.filter(new Func1<String, Boolean>() {
            @Override
            public Boolean call(String s) {
                return true;
            }
        });
        Observable<String> observable3 = observable2.filter(new Func1<String, Boolean>() {
            @Override
            public Boolean call(String s) {
                return true;
            }
        });
        Observable<String> observable4 = observable3.filter(new Func1<String, Boolean>() {
            @Override
            public Boolean call(String s) {
                return true;
            }
        });
        Observable<String> observable5 = observable4.filter(new Func1<String, Boolean>() {
            @Override
            public Boolean call(String s) {
                return true;
            }
        });

        Subscriber<String> subscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                System.out.println(s);
            }
        };
        observable5.subscribe(subscriber);


        System.out.println("use time = " + (System.currentTimeMillis() - str));


        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    class MyFunc1 implements Func1<String, Boolean> {

        String tag;

        public MyFunc1(int tag) {
            this.tag = "func" + tag;
        }

        @Override
        public Boolean call(String s) {
            logThreadName(tag);
            return true;
        }
    }


    @Test
    public void primer2() {
        long str = System.currentTimeMillis();
        Observable<String> observable = Observable.just("aa");
        observable = observable.subscribeOn(Schedulers.io()).asObservable();
        observable = observable.observeOn(Schedulers.io());
        observable = observable.filter(new MyFunc1(1));
        observable = observable.observeOn(Schedulers.newThread());
        observable = observable.filter(new MyFunc1(1));
        observable = observable.observeOn(Schedulers.computation());
        observable = observable.filter(new MyFunc1(1));
        observable = observable.observeOn(Schedulers.newThread());
        observable = observable.filter(new MyFunc1(1));
        observable = observable.observeOn(Schedulers.io());
        observable.subscribe(new Subscriber<String>() {

            @Override
            public void onStart() {
                logThreadName("onStart");
            }

            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                logThreadName("onNext");
            }
        });


        System.out.println("use time = " + (System.currentTimeMillis() - str));


        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
