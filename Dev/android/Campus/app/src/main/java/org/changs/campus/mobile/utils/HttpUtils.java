package org.changs.campus.mobile.utils;

import android.util.Log;

import org.changs.campus.mobile.base.BaseHttp;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by yincs on 2016/11/5.
 */

public class HttpUtils {
    private static class MyLogger implements HttpLoggingInterceptor.Logger {
        public void log(String message) {
            Log.i("http", message);
        }
    }

    private static Retrofit retrofit;

    static {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new MyLogger());
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(loggingInterceptor);
        OkHttpClient okHttpClient = builder.build();

        retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("http://192.168.1.108:8080/campus/")
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }

    public static <T> T create(final Class<T> service) {
        return retrofit.create(service);
    }

    public static <T extends BaseHttp> T createVerify(final Class<T> service) {
        T t = retrofit.create(service);
        t.execute("ee");
        return t;
    }
}
