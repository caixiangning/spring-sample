package org.spring.ioc.xml.bean.instantiation;

import org.junit.Test;
import org.spring.ioc.xml.bean.instantiation.dao.AccountDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.Assert;

/**
 *
 * 测试Bean实例化三种方式：默认构造器、静态工厂方法、普通工厂方法
 *
 * @author CaiXiangning
 * @date May 15, 2017
 * @email caixiangning@gmail.com
 */
public class BeanInstantiationTest {

	/**
	 * Bean实例化：使用默认构造器(无参构造器)
	 */
	@Test
	public void InstantiationWithConstructor() {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("xml/bean/instantiation/bean-instantiation.xml");
		AccountDao accountDao1 = context.getBean("accountDaoImpl1", AccountDao.class);
		Assert.assertNotNull(accountDao1);
	}

	/**
	 * Bean实例化：使用静态工厂方法
	 */
	@Test
	public void InstantiationWithStaticFactoryMethod() {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("xml/bean/instantiation/bean-instantiation.xml");
		AccountDao accountDao2 = context.getBean("accountDaoImpl2", AccountDao.class);
		Assert.assertNotNull(accountDao2);
	}

	/**
	 * Bean实例化：使用实例工厂方法
	 */
	@Test
	public void InstantiationWithStaticFactoryMethod1() {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("xml/bean/instantiation/bean-instantiation.xml");
		AccountDao accountDao2 = context.getBean("accountDaoImpl3", AccountDao.class);
		Assert.assertNotNull(accountDao2);
	}
}
