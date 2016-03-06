package com.changs.kelly.campus.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONObject;

import com.changs.kelly.campus.entity.UserBean;

public class JavaTest {
	// private static String jsonMsg = "\"";
	private static String jonMsg = "{\"timeStamp\":\"1442295420941\","
			+ "\"Usertest\":{\"password\":\"ff\",\"age\":\"路路通\"},"
			+ "\"nonceStr\":\"08a18993-6c87-407e-b0db-50538b9b2e4f\"}";

	public static void main(String[] args) {
		System.out.println("sfsdf");
		try {
			testPost();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void testPost() throws IOException {
		URL url = new URL("http://localhost:8080/campus/find");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoInput(true);
		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
		OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
		JSONObject object = new JSONObject();
		object.put("name", "changs");
		object.put("password", "123");
		object.write(writer);
		writer.flush();
		writer.close();
		

		try {
			InputStream stream = conn.getInputStream();
			byte[] bs = new byte[1024];
			StringBuffer buffer = new StringBuffer();
			int length;
			while ((length = stream.read(bs)) != -1) {
				buffer.append(new String(bs, 0, length));
			}
			System.out.println(buffer.toString());

		} catch (IOException e1) {
			e1.printStackTrace();
		}


		System.out.println("ResponseCode = " + conn.getResponseCode());
	}

}
