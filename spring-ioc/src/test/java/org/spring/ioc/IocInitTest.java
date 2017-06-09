package org.spring.ioc;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import junit.framework.Assert;

/**
 *
 * IoC容器初始化三种方式：文件系统、ClassPath、Web应用
 *
 * @author CaiXiangning
 * @date May 15, 2017
 * @email caixiangning@gmail.com
 */
public class IocInitTest {

	/**
	 * 测试通过文件系统启动IoC容器
	 */
	@Test
	public void testInitIocByFileSystem(){
		FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext(
				"G:/WorkSpace/SpringWorkSpace/spring-sample/spring-ioc/src/main/resources/iocinit/Application-Context.xml");
		Assert.assertNotNull(context);
	}
	
	/**
	 * 测试通过ClassPath启动IoC容器
	 */
	@Test
	public void testInitIocByClassPath(){
		ClassPathXmlApplicationContext context1 = new ClassPathXmlApplicationContext("iocinit/Application-Context.xml");
		Assert.assertNotNull(context1);
		
		ClassPathXmlApplicationContext context2 = new ClassPathXmlApplicationContext("classpath*:iocinit/Application-Context.xml");
		Assert.assertNotNull(context2);
		
		ClassPathXmlApplicationContext context3 = new ClassPathXmlApplicationContext("classpath:iocinit/*-Context.xml");
		Assert.assertNotNull(context3);
	}
}
