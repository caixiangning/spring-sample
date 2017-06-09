package org.spring.ioc.xml.bean.lifecycle;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * 重写Bean生命周期：初始化、销毁测试类(全局Bean)
 *
 * @author CaiXiangning
 * @date May 15, 2017
 * @email caixiangning@gmail.com
 */
public class BeanDefaultLifeCycleTest {
	
	// 这里不使用ApplicationContext而使用ClassPathXmlApplicationContext声明是
	// 因为ApplicationContext没有定义销毁的方法
	private ClassPathXmlApplicationContext context;
	
	/**
	 * 启动IoC容器
	 */
	@Before
	public void before() {
		this.context = new ClassPathXmlApplicationContext("xml/bean/lifecycle/bean-defaultlifecycle.xml");
		context.start();
		
	}

	/**
	 * 销毁IoC容器
	 */
	@After
	public void after() {
		context.close();
	}

	/**
	 * 测试使用根节点beans标签所指定的Bean全局初始化和销毁方法
	 * bean不指定init-method和destroy-method则初始化和销毁时使用使用全局默认指定的方法,
	        而如果bean指定init-method和destroy-method则初始化和销毁时使用bean标签中指定的方法，
	        而不使用全局默认指定的方法
	 */
	@Test
	public void testDefaultInitDestroy() {
		
	}
}
