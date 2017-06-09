package org.spring.ioc.annotation.bean.autowired.service.impl;

import org.spring.ioc.annotation.bean.autowired.dao.AccountDao;
import org.spring.ioc.annotation.bean.autowired.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * 模拟业务逻辑层接口实现类
 *
 * @author CaiXiangning 
 * @date May 13, 2017 
 * @email caixiangning@gmail.com
 */
@Service
public class AccountServiceImpl3 implements AccountService{
	
	private AccountDao  accountDao;
	
	// @Autowired可以对成员变量、方法和构造函数进行标注，来完成自动装配的工作(根据类型进行装配)
	@Autowired
	public AccountServiceImpl3(AccountDao accountDao) {
		super();
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
