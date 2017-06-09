package org.spring.mvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * 自定义拦截器类
 *
 * @author CaiXiangning 
 * @date Jun 9, 2017 
 * @email caixiangning@gmail.com
 */
public class CommonInterceptor implements HandlerInterceptor{
	
	private static final Logger logger = LoggerFactory.getLogger(CommonInterceptor.class);
	
	// 在请求处理之前调用
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		logger.info("执行顺序：1、preHandle");
		if(request.getParameter("userid") == null){
			return false;
		}
		return true;
	}

	// 在请求处理之后调用，但是在视图渲染之前执行
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		logger.info("执行顺序：3、postHandle");
	}

	// 在请求处理之后调用，在渲染视图之后执行
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		logger.info("执行顺序：5、afterCompletion");
	}
}
