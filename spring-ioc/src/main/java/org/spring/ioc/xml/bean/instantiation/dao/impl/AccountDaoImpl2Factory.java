package org.spring.ioc.xml.bean.instantiation.dao.impl;

import org.spring.ioc.xml.bean.instantiation.dao.AccountDao;

/**
 *
 * AccountDaoImpl2类的静态工厂实现类
 *
 * @author CaiXiangning 
 * @date May 13, 2017 
 * @email caixiangning@gmail.com
 */
public class AccountDaoImpl2Factory implements AccountDao {
	
	// 使用饿汉单例模式创建对象
	private static AccountDaoImpl2 accountDaoImpl2 = new AccountDaoImpl2();
	
	// 私有构造函数可以防止外部实例化
	private AccountDaoImpl2Factory(){
		
	}

	// 静态工厂方法(返回实例化对象)
	public static AccountDaoImpl2 createInstance(){
		return accountDaoImpl2;
	}
	
	@Override
	public void getById(long id) {
		// TODO Auto-generated method stub
		System.out.println("调用Dao层接口：根据id获取账号方法");
	}
}
