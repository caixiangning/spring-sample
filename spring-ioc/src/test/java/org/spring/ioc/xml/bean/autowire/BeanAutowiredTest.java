package org.spring.ioc.xml.bean.autowire;

import org.junit.Assert;
import org.junit.Test;
import org.spring.ioc.xml.bean.autowire.dao.AccountDao;
import org.spring.ioc.xml.bean.autowire.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * 测试自动装配Bean
 *
 * @author CaiXiangning
 * @date May 15, 2017
 * @email caixiangning@gmail.com
 */
public class BeanAutowiredTest {

	/**
	 * 
	 * 测试使用byName自动装配模式：
	 * 指定按照属性名称自动装配，只能用于设值注入，如果未找到装配的Bean则不装配并且不抛出异常
	 * (相当于使用默认构造函数构造对象后不调用Setter方法，这里的属性名称指的是setXxx中的xxx而不是私有成员变量的名称，
	 * 并且通常情况下setXxx中Xxx是与属性名称是相同的,参照使用Eclipse自动生成setter。)
	 * 
	 */
	@SuppressWarnings("resource")
	@Test
	public void testAutowiredByName() {
		ApplicationContext context = new ClassPathXmlApplicationContext("xml/bean/autowire/bean-autowire-byname.xml");
		
		Assert.assertNotNull(context.getBean("accountDao1", AccountDao.class));
		Assert.assertNotNull(context.getBean("accountDao2", AccountDao.class));
		
		// 使用ioc容器则不需要手动创建对象和构建对象的依赖关系
		AccountService accountService = context.getBean("accountService1", AccountService.class);
		accountService.getById(1);
	}

	/**
	 * 测试使用byType自动装配模式
	 * 指定按照类型自动装配，只能用于设值注入，如果未找到装配的Bean则不装配并且不抛出异常，但是如果存在多个该类型的Bean，则抛出异常。
	 * (相当于使用默认构造函数构造对象后不调用Setter方法，这里的属性名称指的是setXxx中的xxx而不是私有成员变量的名称，
	 * 并且通常情况下setXxx中Xxx是与属性名称是相同的,参照使用Eclipse自动生成setter。)
	 */
	@SuppressWarnings("resource")
	@Test
	public void testAutowiredByType() {
		ApplicationContext context = new ClassPathXmlApplicationContext("xml/bean/autowire/bean-autowire-bytype.xml");
		
		Assert.assertNotNull(context.getBean("accountDao1", AccountDao.class));
		
		// 使用ioc容器则不需要手动创建对象和构建对象的依赖关系
		AccountService accountService = context.getBean("accountService1", AccountService.class);
		accountService.getById(1);	
	}
}
