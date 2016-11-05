package org.changs.retrofit;

import java.io.IOException;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

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

/**
 * Unit test for simple App.
 */
public class AppTest {
	OkHttpClient okHttpClient;
	Retrofit retrofit;

	@Before
	public void setUp() {
		OkHttpClient.Builder builder = new OkHttpClient.Builder();
		HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new MyLogger());
		loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
		builder.addNetworkInterceptor(loggingInterceptor);
		okHttpClient = builder.build();

		retrofit = new Retrofit.Builder().client(okHttpClient).baseUrl("http://localhost:8080/campus/")
				.addConverterFactory(JacksonConverterFactory.create())
				.addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build();
	}

	@Test
	public void testOkHttp() {
		System.out.println("哈哈");
		Request.Builder requestBuilder = new Request.Builder();
		Request request = requestBuilder
				.post(RequestBody.create(MediaType.parse("Application/json"), "{\"id\":112333}"))
				.url("http://localhost:8080/campus/account/login").tag("test").build();
		;
		okHttpClient.newCall(request).enqueue(new Callback() {

			public void onResponse(Call call, Response response) throws IOException {
				System.out.println("onResponse" + response.body().string());
			}

			public void onFailure(Call call, IOException e) {
				System.out.println("onFailure");
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
				System.out.println("onResponse " + response.body().get("code"));
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
	public void testRxjava() {
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
				});
	}

	@Test
	public void testJackson() throws IOException {
		Account account = new Account("ycs", "123456");
		ObjectMapper mapper = new ObjectMapper();
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

	public class AppRes<T> {
		private int code;
		private String des;
		private T data;

		public AppRes() {
			super();
		}

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
}
