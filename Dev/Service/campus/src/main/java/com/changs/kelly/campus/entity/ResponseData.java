package com.changs.kelly.campus.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ResponseData {

	private Object data;

	private int resultCode = -1;

	private String resultDes = "没有设置返回描述";

	public ResponseData() {
	}

	public ResponseData(int resultCode, String resultDes, Object data) {
		this.resultCode = resultCode;
		this.resultDes = resultDes;
		this.data = data;
	}

	public int getResultCode() {
		return resultCode;
	}

	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultDes() {
		return resultDes;
	}

	public void setResultDes(String resultDes) {
		this.resultDes = resultDes;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
