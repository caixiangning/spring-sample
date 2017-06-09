package org.spring.ioc.xml.bean.instantiation.dao.impl;

import org.spring.ioc.xml.bean.instantiation.dao.AccountDao;

/**
 *
 * AccountDaoImpl3类的实例工厂实现类
 *
 * @author CaiXiangning 
 * @date May 15, 2017 
 * @email caixiangning@gmail.com
 */
public class AccountDaoImpl3Factory {
	
	// 使用饿汉单例模式创建对象
	private static AccountDao accountDao = new AccountDaoImpl3();
	
	// 私有构造函数可以防止外部实例化
	private AccountDaoImpl3Factory(){
		
	}
	
	// 实例工厂方法(返回实例化对象)
	public AccountDao createAccountDao(){
		return accountDao;
	}
}
