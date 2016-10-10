package org.changs.campus.api;

public class Response<T> {
	public static final String msg_success = "success";

	private int code;
	private T data;
	private String message;

	public Response(T data) {
		super();
		this.data = data;
		this.code = 0;
		this.message = msg_success;
	}

	public Response(int code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
