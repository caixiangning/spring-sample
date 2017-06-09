package org.spring.ioc.annotation.bean.annotationconfig.service.impl;

import org.spring.ioc.annotation.bean.annotationconfig.dao.AccountDao;
import org.spring.ioc.annotation.bean.annotationconfig.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;


/**
 *
 * 模拟业务逻辑层接口实现类
 *
 * @author CaiXiangning 
 * @date May 13, 2017 
 * @email caixiangning@gmail.com
 */
public class AccountServiceImpl implements AccountService{
	
	private AccountDao  accountDao;
	
	@Autowired
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
