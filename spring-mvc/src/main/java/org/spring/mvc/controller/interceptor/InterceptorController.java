package org.spring.mvc.controller.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * 用于测试拦截器的Controller
 * 测试url：http://localhost:8080/spring-mvc/interceptor/login?userid=1
 * 	        http://localhost:8080/spring-mvc/interceptor/login
 *
 * @author CaiXiangning 
 * @date Jun 9, 2017 
 * @email caixiangning@gmail.com
 */
@Controller
@RequestMapping("/interceptor")
public class InterceptorController {
	
	private static final Logger logger = LoggerFactory.getLogger(InterceptorController.class);
	
	@RequestMapping(value="/login")
	public String getInterceptor(@RequestParam(value="userid") String userId){
		logger.info("执行顺序：2、执行控制器内容");
		return "interceptor";
	}
}
