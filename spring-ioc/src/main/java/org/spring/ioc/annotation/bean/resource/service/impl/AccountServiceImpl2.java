package org.spring.ioc.annotation.bean.resource.service.impl;

import javax.annotation.Resource;

import org.spring.ioc.annotation.bean.resource.dao.AccountDao;
import org.spring.ioc.annotation.bean.resource.service.AccountService;
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
public class AccountServiceImpl2 implements AccountService{
	
	// @Resource（这个注解属于J2EE的），默认安照名称进行装配，名称可以通过name属性进行指定， 
	// 如果没有指定name属性，当注解写在字段上时，默认取字段名进行按照名称查找
	@Resource
	private AccountDao  accountDaoImpl2;

	/**
	 * 模拟根据id获取账号方法
	 * @param id
	 */
	@Override
	public void getById(long id) {
		// TODO Auto-generated method stub
		System.out.println("调用Service层接口：根据id获取账号方法");
		// 业务逻辑层调用数据访问层接口
		accountDaoImpl2.getById(id);
	}
}
