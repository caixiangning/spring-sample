package org.spring.ioc.noioc;

import org.junit.Test;
import org.spring.ioc.noioc.dao.AccountDao;
import org.spring.ioc.noioc.dao.impl.AccountDaoImpl;
import org.spring.ioc.noioc.service.AccountService;
import org.spring.ioc.noioc.service.impl.AccountServiceImpl1;
import org.spring.ioc.noioc.service.impl.AccountServiceImpl2;

/**
 *
 * 不使用ioc容器，自行装配测试类
 *
 * @author CaiXiangning 
 * @date May 13, 2017 
 * @email caixiangning@gmail.com
 */
public class NoIocTest {
	
	/**
	 * 不使用ioc容器，自行创建和使用设值器装配对象
	 */
	@Test
	public void testNoIocWithSetter(){
		// 不使用ioc容器，需要自行创建数据访问层接口对象
		AccountDao accountDao = new AccountDaoImpl();
		// 不使用ioc容器，需要自行业务逻辑层接口创建对象
		AccountServiceImpl1 accountServiceImpl1 = new AccountServiceImpl1();
		// 通过设值器装配对象
		accountServiceImpl1.setAccountDao(accountDao);
		
		// 接口声明对象，然后通过接口来调用方法
		AccountService accountService = accountServiceImpl1;
		accountService.getById(1);
	}
	
	/**
	 * 不使用ioc容器，自行创建和使用构造器装配对象
	 */
	@Test
	public void testNoIocWithConstructor(){
		// 不使用ioc容器，需要自行创建数据访问层接口对象
		AccountDao accountDao = new AccountDaoImpl();
		// 不使用ioc容器，需要自行业务逻辑层接口创建对象(构建对象同时通过构造器装配对象)
		AccountServiceImpl2 accountServiceImpl12 = new AccountServiceImpl2(accountDao);
		
		// 接口声明对象，然后通过接口来调用方法
		AccountService accountService = accountServiceImpl12;
		accountService.getById(1);
	}
}
