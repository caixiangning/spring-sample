package org.spring.ioc.xml.bean.lifecycle;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.spring.ioc.xml.bean.lifecycle.BeanLifeCycle;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * 重写Bean生命周期：初始化、销毁测试类
 *
 * @author CaiXiangning
 * @date May 15, 2017
 * @email caixiangning@gmail.com
 */
public class BeanLifeCycleTest {
	
	// 这里不使用ApplicationContext而使用ClassPathXmlApplicationContext声明是因为
	private ClassPathXmlApplicationContext context;
	
	/**
	 * 启动IoC容器
	 */
	@Before
	public void before() {
		this.context = new ClassPathXmlApplicationContext("xml/bean/lifecycle/bean-lifecycle.xml");
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
	 * 测试重写Bean初始化和销毁方法
	 */
	@Test
	public void testInitDestroy() {
		BeanLifeCycle beanLifeCycle = context.getBean("beanLifeCycle", BeanLifeCycle.class);
		beanLifeCycle.doSomething();
	}
}
