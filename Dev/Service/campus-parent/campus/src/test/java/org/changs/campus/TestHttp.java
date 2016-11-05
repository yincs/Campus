package org.changs.campus;

import org.junit.Before;
import org.junit.Test;

public class TestHttp {
	// private static Retrofit retrofit;

	@Before
	public void setup() {
		// OkHttpClient okHttpClient = new OkHttpClient();
		// okHttpClient.interceptors().add(new HttpLoggingInterceptor());
		// retrofit = new
		// Retrofit.Builder().baseUrl("http://localhost:8080/campus")// 传递url
		// .client(okHttpClient).addConverterFactory(JacksonConverterFactory.create())//
		// 添加转换器
		// .build();
	}

	@Test
	public void testLogin() throws Exception {
		// System.out.println("哈哈1");
		//
		// Account account = new Account();
		// account.setAccount("adc");
		// account.setPasswd("1231");
		// System.out.println("哈哈3");
		// Call<String> call = retrofit.create(HttpLogin.class).login(account);
		// // Response<String> response = call.execute();
		// call.enqueue(new Callback<String>() {
		//
		// @Override
		// public void onResponse(Response<String> response, Retrofit retrofit)
		// {
		// System.out.println("onResponse = " + response.body());
		// }
		//
		// @Override
		// public void onFailure(Throwable t) {
		// System.out.println("onFailure");
		// }
		// });
		// System.out.println("哈哈2");
		// Thread.sleep(10000);
	}
}
