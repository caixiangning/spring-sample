package org.spring.ioc.xml.bean.scope;

import org.junit.Test;
import org.spring.ioc.xml.bean.scope.dao.AccountDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.Assert;

/**
 *
 * 测试Bean的作用域Scope
 *
 * @author CaiXiangning 
 * @date May 14, 2017 
 * @email caixiangning@gmail.com
 */
public class BeanScopeTest {
	
	/**
	 * 默认单例模式，不使用scope等同于scope="singleton"
	 */
	@Test
	public void testDefault(){
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("xml/bean/scope/bean-scope.xml");
		AccountDao accountDao1 = ctx.getBean("accountDao", AccountDao.class);
		System.out.println("hashcode of accountDao1:" + accountDao1.hashCode());
		AccountDao accountDao2 = ctx.getBean("accountDao", AccountDao.class);
		System.out.println("hashcode of accountDao2:" + accountDao2.hashCode());
		Assert.assertEquals(accountDao1.hashCode(), accountDao2.hashCode());
	}
	
	
	/**
	 * 测试单例(singleton)模式：单个ioc容器只创建一次实例对象
	 */
	@Test
	public void testSingleton(){
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("xml/bean/scope/bean-scope.xml");
		AccountDao accountDao1 = ctx.getBean("accountDao1", AccountDao.class);
		System.out.println("hashcode of accountDao1:" + accountDao1.hashCode());
		AccountDao accountDao2 = ctx.getBean("accountDao1", AccountDao.class);
		System.out.println("hashcode of accountDao2:" + accountDao2.hashCode());
		Assert.assertEquals(accountDao1.hashCode(), accountDao2.hashCode());
	}

	
	/**
	 * 测试prototype模式：每次请求/每次使用创建新实例
	 */
	@Test
	public void testPrototype(){
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("xml/bean/scope/bean-scope.xml");
		AccountDao accountDao1 = ctx.getBean("accountDao2", AccountDao.class);
		System.out.println("hashcode of accountDao1:" + accountDao1.hashCode());
		AccountDao accountDao2 = ctx.getBean("accountDao2", AccountDao.class);
		System.out.println("hashcode of accountDao2:" + accountDao2.hashCode());
		Assert.assertNotSame(accountDao1, accountDao2);
	}
}
