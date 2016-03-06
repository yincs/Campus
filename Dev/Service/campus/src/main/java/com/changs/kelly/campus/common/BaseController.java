package com.changs.kelly.campus.common;

import com.changs.kelly.campus.entity.ResponseData;
import com.changs.kelly.campus.entity.ResponseMapping;

public class BaseController {

	protected ResponseData getSuccessResponseData(Object data) {
		return new ResponseData(0, ResponseMapping.getDes(0), data);
	}

	protected ResponseData getErrorResponseData(int errorCode) {
		return new ResponseData(errorCode, ResponseMapping.getDes(errorCode), null);
	}
}
