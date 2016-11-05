package org.changs.retrofit;

import okhttp3.logging.HttpLoggingInterceptor.Logger;

public class MyLogger implements Logger {

	public void log(String message) {
		System.out.println(message);
	}

}
