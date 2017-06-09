package org.spring.ioc.xml.bean.injection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.spring.ioc.xml.bean.injection.dao.AccountDao;
import org.spring.ioc.xml.bean.injection.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * 依赖注入两种方式测试类(使用xml构建并装配对象)
 *
 * @author CaiXiangning 
 * @date May 13, 2017 
 * @email caixiangning@gmail.com
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class BeanInjectionTest {
	
	/**
	 * 依赖注入方式1：设值注入
	 */
	@Test
	public void testInjectionBySetter(){
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("xml/bean/injection/bean-injection.xml");
        AccountDao accountDao = ctx.getBean("accountDao1", AccountDao.class);
        accountDao.getById(1);
        // 使用ioc容器则不需要手动创建对象和构建对象的依赖关系
        AccountService accountService = ctx.getBean("accountService1", AccountService.class);
        accountService.getById(1);
	}
	
	/**
	 * 依赖注入方式2：构造器注入
	 */
	@Test
	public void testXmlIocConstructor(){
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("xml/bean/injection/bean-injection.xml");
        AccountDao accountDao = (AccountDao) ctx.getBean("accountDao2");
        accountDao.getById(1);
        // 使用ioc容器则不需要手动创建对象和构建对象的依赖关系
        AccountService accountService = (AccountService) ctx.getBean("accountService2");
        accountService.getById(1);
	}
}
