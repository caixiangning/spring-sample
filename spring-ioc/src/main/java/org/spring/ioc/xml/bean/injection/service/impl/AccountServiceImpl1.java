package org.spring.ioc.xml.bean.injection.service.impl;

import org.spring.ioc.xml.bean.injection.dao.AccountDao;
import org.spring.ioc.xml.bean.injection.service.AccountService;

/**
 *
 * 模拟业务逻辑层接口实现类1
 *
 * @author CaiXiangning 
 * @date May 13, 2017 
 * @email caixiangning@gmail.com
 */
public class AccountServiceImpl1 implements AccountService{
	
	private AccountDao  accountDao;
	
	// 通过设值器装配Dao层接口对象(xml里面配置)
	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	/**
	 * 模拟根据id获取账号方法
	 * @param id
	 */
	@Override
	public void getById(long id) {
		// TODO Auto-generated method stub
		System.out.println("调用Service层接口：根据id获取账号方法");
		// 业务逻辑层调用数据访问层接口
		accountDao.getById(id);
	}
}
