package org.spring.ioc.annotation.bean.resource;

import org.junit.Assert;
import org.junit.Test;
import org.spring.ioc.annotation.bean.resource.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * 
 *
 * @author CaiXiangning 
 * @date May 22, 2017 
 * @email caixiangning@gmail.com
 */
public class ResourceTest {
	
	/**
	 * @Resource（这个注解属于J2EE的），默认安照名称进行装配，名称可以通过name属性进行指定
	 * @Resource（这个注解属于J2EE的），默认安照名称进行装配，名称可以通过name属性进行指定， 
	 * 如果没有指定name属性，当注解写在字段上时，默认取字段名进行按照名称查找，
	 * 如果注解写在setter方法上默认取属性名进行装配。 当找不到与名称匹配的bean时才按照类型进行装配。
	 * 但是需要注意的是，如果name属性一旦指定，就只会按照名称进行装配。
	 */
	@SuppressWarnings("resource")
	@Test
	public void testResource1() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"annotation/bean/resource/spring-resource.xml");
		
		AccountService accountService = context.getBean("accountServiceImpl1", AccountService.class);
		accountService.getById(1);
		Assert.assertNotNull(accountService);
	}
	
	/**
	 * @Resource（这个注解属于J2EE的），默认安照名称进行装配，名称可以通过name属性进行指定， 
		如果没有指定name属性，当注解写在字段上时，默认取字段名进行按照名称查找
	 */
	@SuppressWarnings("resource")
	@Test
	public void testResource2() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"annotation/bean/resource/spring-resource.xml");
		
		AccountService accountService = context.getBean("accountServiceImpl2", AccountService.class);
		accountService.getById(1);
		Assert.assertNotNull(accountService);
	}
	
	/**
	 * @Resource（这个注解属于J2EE的），默认安照名称进行装配，名称可以通过name属性进行指定， 
		如果注解写在setter方法上默认取属性名进行装配
	 */
	@SuppressWarnings("resource")
	@Test
	public void testResource3() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"annotation/bean/resource/spring-resource.xml");
		
		AccountService accountService = context.getBean("accountServiceImpl3", AccountService.class);
		accountService.getById(1);
		Assert.assertNotNull(accountService);
	}
}
