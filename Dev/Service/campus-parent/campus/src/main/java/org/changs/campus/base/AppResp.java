package org.changs.campus.base;

import org.changs.campus.constants.Global;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class AppResp<T> {
	private int code;
	private T data;
	private String des;

	public AppResp(T data) {
		super();
		this.data = data;
		this.code = Global.CODE.SUCCESS;
		this.des = Global.DES.SUCCESS;
	}

	public AppResp(String des) {
		super();
		this.des = des;
		this.code = Global.CODE.ERROR;
	}

	public AppResp(int code, String des) {
		super();
		this.code = code;
		this.des = des;
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
