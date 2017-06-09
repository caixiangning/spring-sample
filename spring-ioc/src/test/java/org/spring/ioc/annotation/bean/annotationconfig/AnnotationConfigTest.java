package org.spring.ioc.annotation.bean.annotationconfig;

import org.junit.Test;
import org.spring.ioc.annotation.bean.annotationconfig.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.Assert;

/**
 *
 * 测试装配Bean
 *
 * @author CaiXiangning 
 * @date May 18, 2017 
 * @email caixiangning@gmail.com
 */
public class AnnotationConfigTest {
	
	/**
	 * <bean class="org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor"/>
	 * 激活@Autowired注解传统方式,使得注册到容器中并使用@Autowired注解装配的Bean可以完成自动装配
	 * 不负责自动注册Bean，也就是说Bean还是得在XML文件中声明。
	 */
	@SuppressWarnings("resource")
	@Test
	public void testAutowiredAnnotation(){
		ApplicationContext context = new ClassPathXmlApplicationContext("annotation/bean/annotationconfig/spring-autowired.xml");
		AccountService accountService = context.getBean("accountService", AccountService.class);
		Assert.assertNotNull(accountService);
		accountService.getById(1);
	}
	
	/**
	 * <context:annotation-config/>的作用是向Spring容器注册以下四个BeanPostProcessor：
	AutowiredAnnotationBeanPostProcessor、CommonAnnotationBeanPostProcessor、
	PersistenceAnnotationBeanPostProcessor、RequiredAnnotationBeanPostProcessor
	也就是说激活@Autowired、@Resource、@Required、@PersistenceContext等注解，
	也就是说将注册到容器中并使用这些注解装配的Bean完成自动装配，不负责自动注册Bean，也就是说Bean还是得在XML文件中声明。
	 */
	@SuppressWarnings("resource")
	@Test
	public void testAnnotationConfig(){
		ApplicationContext context = new ClassPathXmlApplicationContext("annotation/bean/annotationconfig/spring-annotation-config.xml");
		AccountService accountService = context.getBean("accountService", AccountService.class);
		Assert.assertNotNull(accountService);
		accountService.getById(1);
	}
	
	
}
