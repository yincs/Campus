package org.changs.campus.api;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;

public class HandlerResolver extends ExceptionHandlerExceptionResolver {

	@Override
	protected ModelAndView doResolveHandlerMethodException(HttpServletRequest arg0, HttpServletResponse arg1,
			HandlerMethod arg2, Exception arg3) {
		// TODO Auto-generated method stub

		System.out.println("哈哈哈哈哈哈哈哈哈哈品保侃侃人");
		return super.doResolveHandlerMethodException(arg0, arg1, arg2, arg3);
	}

}
