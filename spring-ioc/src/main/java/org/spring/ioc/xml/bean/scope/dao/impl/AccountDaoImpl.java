package org.spring.ioc.xml.bean.scope.dao.impl;

import org.spring.ioc.xml.bean.scope.dao.AccountDao;

/**
 *
 * 模拟数据访问层接口实现类
 *
 * @author CaiXiangning 
 * @date May 13, 2017 
 * @email caixiangning@gmail.com
 */
public class AccountDaoImpl implements AccountDao {
	
	@Override
	public void getById(long id) {
		// TODO Auto-generated method stub
		System.out.println("调用Dao层接口           ：根据id获取账号方法");
	}
}
