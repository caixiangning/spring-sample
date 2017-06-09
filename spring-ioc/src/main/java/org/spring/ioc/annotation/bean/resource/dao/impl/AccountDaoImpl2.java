package org.spring.ioc.annotation.bean.resource.dao.impl;

import org.spring.ioc.annotation.bean.resource.dao.AccountDao;
import org.springframework.stereotype.Repository;


/**
 *
 * 模拟数据访问层接口实现类
 *
 * @author CaiXiangning 
 * @date May 13, 2017 
 * @email caixiangning@gmail.com
 */
@Repository
public class AccountDaoImpl2 implements AccountDao {
	
	@Override
	public void getById(long id) {
		// TODO Auto-generated method stub
		System.out.println("调用Dao层接口2          ：根据id获取账号方法");
	}
}
