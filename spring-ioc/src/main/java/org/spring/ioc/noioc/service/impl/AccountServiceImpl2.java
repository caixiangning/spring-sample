package org.spring.ioc.noioc.service.impl;

import org.spring.ioc.noioc.dao.AccountDao;
import org.spring.ioc.noioc.service.AccountService;

/**
 *
 * 模拟业务逻辑层接口实现类2
 *
 * @author CaiXiangning 
 * @date May 13, 2017 
 * @email caixiangning@gmail.com
 */
public class AccountServiceImpl2 implements AccountService {

	private AccountDao accountDao;
	
	// 通过构造器装配Dao层接口对象
	public AccountServiceImpl2(AccountDao accountDao) {
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
