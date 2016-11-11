package org.changs.campus.mobile;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by yincs on 2016/11/11.
 */

@SuppressWarnings("Convert2MethodRef")
public class RxJavaAlgorithmUnitTest {


    /**
     * 取5~10个随机数字（0~10），然后过滤出小于2的元素；接着进行排序，最后获得了排序后的列表
     */

    @Test
    public void testMap() {
        Observable.just("hello map operator")
                .map(s -> 2016)
                .map(String::valueOf)
                .subscribe(System.out::println);
    }

    @Test
    public void testFrom() {
        List<String> s = Arrays.asList("Java", "Android", "Ruby", "Ios", "Swift");
        Observable.from(s)
                .subscribe(System.out::println);
    }


    @Test
    public void testFlatMap() {
        List<String> s = Arrays.asList("Java", "Android", "Ruby", "Ios", "Swift");
        Observable.just(s)
                .flatMap(strings -> Observable.from(s))
                .subscribe(System.out::println);
    }


    @Test
    public void testFilter() {
        List<String> s = Arrays.asList("Java", "Android", "Ruby", "Ios", "Swift");
        Observable.just(s)
                .flatMap(new Func1<List<String>, Observable<String>>() {
                    @Override
                    public Observable<String> call(List<String> strings) {
                        System.out.println("flatMap " + strings);
                        return Observable.from(strings);
                    }
                })
                .filter(new Func1<String, Boolean>() {
                    @Override
                    public Boolean call(String s) {
                        System.out.println("filter " + s);
                        return true;
                    }
                })
                .take(4)

                .doOnNext(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        System.out.println("doOnNext " + s);
                    }
                })
                .subscribe(o -> {
                    System.out.println("Action1 = " + o);
                });

    }


    Observable<List<String>> query(String text) {
        final ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(text + "1");
        arrayList.add(text + "2");
        arrayList.add(text + "3");
        arrayList.add(text + "4");
        return Observable.just(arrayList);
    }

    Observable<String> getTitle(String url) {
        return Observable.just(url + "的标题");
    }

    @Test
    public void testFlatMap1() {
        final Subscription subscribe = query("Hello, world!")
                .doOnUnsubscribe(() -> System.out.println("取消订阅了"))
                .subscribeOn(Schedulers.io())
                .flatMap(list -> {
                    System.out.println("flatMap");
                    return Observable.from(list);
                })
                .flatMap(url -> {
                    System.out.println("flatMap2");
                    return Observable.just(url + "的标题");
                })
                .filter(url -> url.contains("4") || url.contains("3"))
                .take(1)
                .subscribe(System.out::println);


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//                .flatMap(list -> Observable.from(list))
//                .subscribe(url -> System.out.println(url));

//                .flatMap(new Func1<List<String>, Observable<String>>() {
//                    @Override
//                    public Observable<String> call(List<String> strings) {
//                        return Observable.from(strings);
//                    }
//                })
//                .subscribe(new Action1<String>() {
//                    @Override
//                    public void call(String s) {
//                        System.out.println(s);
//                    }
//                });
    }

    @Test
    public void testInterval() {
        final Subscription subscription = Observable.interval(1, TimeUnit.SECONDS)
                .doOnUnsubscribe(() -> System.out.println("取消订阅了"))
                .subscribe(time -> {
                    System.out.println(Thread.currentThread());
                    System.out.println(time);
                });
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        subscription.unsubscribe();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
