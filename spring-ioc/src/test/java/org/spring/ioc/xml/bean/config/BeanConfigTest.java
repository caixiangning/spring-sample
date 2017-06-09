package org.spring.ioc.xml.bean.config;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.Assert;

/**
 *
 * Bean相关配置项测试类
 *
 * @author CaiXiangning 
 * @date May 17, 2017 
 * @email caixiangning@gmail.com
 */
public class BeanConfigTest {
	
	/**
	 * 测试不配置Bean的id则默认id是全限定类名(包名.类名)，而不是首字母小写的类名
	 */
	@Test
	public void testBeanNoId(){
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("xml/bean/config/bean-config.xml");
		BeanConfig beanConfig1 = context.getBean("org.spring.ioc.xml.bean.config.BeanConfig", BeanConfig.class);
		Assert.assertNotNull(beanConfig1);
		/*BeanConfig beanConfig2 = context.getBean("beanConfig", BeanConfig.class);
		Assert.assertNotNull(beanConfig2);*/
	}
	
	/**
	 * 测试如果不配置Bean的Scope则默认是singleton模式
	 */
	@Test
	public void testBeanDefaultScope(){
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("xml/bean/config/bean-config.xml");
		BeanConfig beanConfig1 = context.getBean("org.spring.ioc.xml.bean.config.BeanConfig", BeanConfig.class);
		System.out.println("hashcode of beanConfig1" + beanConfig1.hashCode());
		
		BeanConfig beanConfig2 = context.getBean("org.spring.ioc.xml.bean.config.BeanConfig", BeanConfig.class);
		System.out.println("hashcode of beanConfig1" + beanConfig2.hashCode());

		Assert.assertEquals(beanConfig1, beanConfig2);
	}
	
	/**
	 *  测试如果不指定lazy-init则默认Bean是不延迟加载的，容器启动即实例化Bean
	 */
	@SuppressWarnings({ "unused", "resource" })
	@Test
	public void testBeanDefaultLazyInit(){
		ApplicationContext context = new ClassPathXmlApplicationContext("xml/bean/config/bean-config.xml");
	}
	
	/**
	 * 测试如果使用lazy-init="true"则容器启动不实例化Bean，初次使用才会实例化
	 */
	@SuppressWarnings({ "resource", "unused" })
	@Test
	public void testBeanLazyInit(){
		ApplicationContext context = new ClassPathXmlApplicationContext("xml/bean/config/bean-config.xml");
		BeanConfig beanConfig2 = context.getBean("beanConfig2", BeanConfig.class);
	}
}
