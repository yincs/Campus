package org.changs.campus.base;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.changs.campus.constants.Global;
import org.changs.campus.exception.CampusException;
import org.springframework.dao.DataAccessException;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

public class BaseController {

	private static final Logger log = Logger.getLogger(BaseController.class);

	/** 基于@ExceptionHandler异常处理 */
	@ExceptionHandler
	public @ResponseBody AppResp<Object> exp(HttpServletRequest request, Exception ex) {
		log.debug("exp" + ex);
		AppResp<Object> responseInfo = new AppResp<>(Global.CODE.ERROR, Global.DES.ERROR);
		if (ex instanceof CampusException) {
			responseInfo.setDes(ex.getMessage());
		} else if (ex instanceof HttpMessageConversionException) {
			responseInfo.setDes("非法参数");
		} else if (ex instanceof BindException) {
			BindException bindException = (BindException) ex;
			BindingResult result = bindException.getBindingResult();
			handleBindException(responseInfo, result);
		} else if (ex instanceof MethodArgumentNotValidException) {
			MethodArgumentNotValidException exception = (MethodArgumentNotValidException) ex;
			BindingResult result = exception.getBindingResult();
			handleBindException(responseInfo, result);
		} else if (ex instanceof HttpMediaTypeNotSupportedException) {
			responseInfo.setDes("请求类型错误");
		} else if (ex instanceof DataAccessException) {
			responseInfo.setDes("数据库操作异常");
		}
		return responseInfo;
	}

	private void handleBindException(AppResp<Object> responseInfo, BindingResult result) {
		List<ObjectError> allErrors = result.getAllErrors();
		StringBuilder sb = new StringBuilder();
		sb.append("参数错误[");
		final int size = allErrors.size();
		for (int i = 0; i < size; i++) {
			sb.append(allErrors.get(i).getDefaultMessage());
			if (i < size - 1)
				sb.append("&&");
		}
		sb.append("]");
		responseInfo.setDes(sb.toString());
	}

}
