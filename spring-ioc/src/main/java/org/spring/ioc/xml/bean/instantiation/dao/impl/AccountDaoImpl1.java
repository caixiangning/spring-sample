package org.spring.ioc.xml.bean.instantiation.dao.impl;

import org.spring.ioc.xml.bean.instantiation.dao.AccountDao;

/**
 *
 * 模拟数据访问层接口实现类
 *
 * @author CaiXiangning 
 * @date May 13, 2017 
 * @email caixiangning@gmail.com
 */
public class AccountDaoImpl1 implements AccountDao {
	
	public AccountDaoImpl1() {
		// TODO Auto-generated constructor stub
		System.out.println("调用了构造器方法");
	}

	@Override
	public void getById(long id) {
		// TODO Auto-generated method stub
		System.out.println("调用Dao层接口：根据id获取账号方法");
	}
}
