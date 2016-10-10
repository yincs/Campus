package org.changs.campus.api;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class ExceptionResolver implements HandlerExceptionResolver {
	@Override
	public ModelAndView resolveException(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2,
			Exception arg3) {

		System.out.println("哎呀哎呀哎呀哎呀哎呀哎呀哎呀哎呀哎呀哎呀哎呀哎呀哎呀哎呀哎呀哎呀哎呀哎呀哎呀");
		return null;
	}

}
