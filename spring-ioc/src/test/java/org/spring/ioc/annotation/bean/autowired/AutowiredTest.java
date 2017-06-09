package org.spring.ioc.annotation.bean.autowired;

import org.junit.Assert;
import org.junit.Test;
import org.spring.ioc.annotation.bean.autowired.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * 测试使用@Autowired注解来完成自动装配工作
 *
 * @author CaiXiangning
 * @date May 19, 2017
 * @email caixiangning@gmail.com
 */
public class AutowiredTest {

	/**
	 * @Autowired可以对成员变量、方法和构造函数进行标注，来完成自动装配的工作(根据类型进行装配)
		@Autowired对成员变量进行标注的时候，可以省略setter方法
	 */
	@SuppressWarnings("resource")
	@Test
	public void testAutowired1() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"annotation/bean/autowired/spring-autowired.xml");
		
		AccountService accountService = context.getBean("accountServiceImpl1", AccountService.class);
		/*accountService.getById(1);*/
		Assert.assertNotNull(accountService);
	}
	
	/**
	 * @Autowired可以对成员变量、方法和构造函数进行标注，来完成自动装配的工作(根据类型进行装配)
	 * 测试@Autowired标注在setter方法上
	 */
	@SuppressWarnings("resource")
	@Test
	public void testAutowired2() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"annotation/bean/autowired/spring-autowired.xml");
		
		AccountService accountService = context.getBean("accountServiceImpl2", AccountService.class);
		/*accountService.getById(1);*/
		Assert.assertNotNull(accountService);
	}
	
	/**
	 * @Autowired可以对成员变量、方法和构造函数进行标注，来完成自动装配的工作(根据类型进行装配)
	 * 测试@Autowired标注在构造函数上
	 */
	@SuppressWarnings("resource")
	@Test
	public void testAutowired3() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"annotation/bean/autowired/spring-autowired.xml");
		
		AccountService accountService = context.getBean("accountServiceImpl3", AccountService.class);
		accountService.getById(1);
		Assert.assertNotNull(accountService);
	}
	
	/**
	 * 使用@Autowired注解如果想使用名称装配可以结合@Qualifier注解进行使用
	 */
	@SuppressWarnings("resource")
	@Test
	public void testAutowired4() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"annotation/bean/autowired/spring-autowired.xml");
		
		AccountService accountService = context.getBean("accountServiceImpl4", AccountService.class);
		accountService.getById(1);
		Assert.assertNotNull(accountService);
	}
}
