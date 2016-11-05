package org.changs.campus.mobile;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    private class MyLogger implements HttpLoggingInterceptor.Logger {

        public void log(String message) {
            System.out.println("message：" + message);
        }
    }

    private OkHttpClient okHttpClient;
    private Retrofit retrofit;

    @Before
    public void setUp() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new MyLogger());
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(loggingInterceptor);
        okHttpClient = builder.build();

        retrofit = new Retrofit.Builder().client(okHttpClient).baseUrl("http://localhost:8080/campus/")
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }

    @Test
    public void testOkHttp() throws Exception {
        Request.Builder requestBuilder = new Request.Builder();
        Request request = requestBuilder
                .post(RequestBody.create(MediaType.parse("Application/json"), "{\"id\":112333}"))
                .url("http://localhost:8080/campus/account/login").tag("test").build();
        ;
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println("onFailure");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                System.out.println("onResponse" + response.body().string());
            }
        });

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
    }

    @Test
    public void testRetrofit() {
        retrofit2.Call<HashMap<String, Object>> login = retrofit.create(HttpLogin.class)
                .login(new Account("yincs", "123456"));
        login.enqueue(new retrofit2.Callback<HashMap<String, Object>>() {

            public void onResponse(retrofit2.Call<HashMap<String, Object>> call,
                                   retrofit2.Response<HashMap<String, Object>> response) {
                System.out.println("onResponse " + response.body().get("des"));
            }

            public void onFailure(retrofit2.Call<HashMap<String, Object>> call, Throwable t) {

                System.out.println("onFailure " + t.getMessage());
            }
        });
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
    }

    @Test
    public void testRxJava() {
        retrofit.create(HttpLoginRx.class).login(new Account("yincs", "123456"))
                .subscribe(new Subscriber<HashMap<String, Object>>() {

                    public void onCompleted() {
                        System.out.println("onCompleted");
                    }

                    public void onError(Throwable arg0) {
                        System.out.println("onError" + arg0.getMessage());
                    }

                    public void onNext(HashMap<String, Object> arg0) {
                        System.out.println("onNext " + arg0.get("des"));
                    }
                }).unsubscribe();
    }

    @Test
    public void testRxJavaObjectT() {
        retrofit.create(HttpLoginRxObjectT.class).login(new Account("yincs", "123456"))
                .filter(new Func1<AppRes<Object>, Boolean>() {//添加通过过滤器
                    @Override
                    public Boolean call(AppRes<Object> objectAppRes) {
                        if (objectAppRes.code != 0) {
                            System.out.println("filter = " + objectAppRes.getDes());
                            throw new RuntimeException(objectAppRes.getDes());
                        }
                        return true;
                    }
                })
                .subscribe(new Subscriber<AppRes<Object>>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("onError" + e.getMessage());
                    }

                    @Override
                    public void onNext(AppRes<Object> appRes) {
                        System.out.println("onNext " + appRes.getDes());
                    }
                });
    }


    @Test
    public void testJackson() throws IOException {
        Account account = new Account("ycs", null);
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);  //不打印null
        String json = mapper.writeValueAsString(account);
        System.out.println(json);

        final Account account1 = mapper.readValue(json, Account.class);
        System.out.println(account1.getAccount() + ":" + account1.getPasswd());
    }

    public interface HttpLogin {
        @POST("account/login")
        retrofit2.Call<HashMap<String, Object>> login(@Body Account account);
    }

    public interface HttpLoginRx {
        @POST("account/login")
        Observable<HashMap<String, Object>> login(@Body Account account);
    }

    public interface HttpLoginRxObjectT {
        @POST("account/login")
        Observable<AppRes<Object>> login(@Body Account account);
    }


    public static class AppRes<T> {
        private int code;
        private String des;
        T data;

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getDes() {
            return des;
        }

        public void setDes(String des) {
            this.des = des;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }
    }

    public static class Account {
        private String account;
        private String passwd;

        public Account() {
        }

        public Account(String account, String passwd) {
            super();
            this.account = account;
            this.passwd = passwd;
        }

        public String getAccount() {
            return account;
        }

        public void setAccount(String account) {
            this.account = account;
        }

        public String getPasswd() {
            return passwd;
        }

        public void setPasswd(String passwd) {
            this.passwd = passwd;
        }
    }

}