package org.spring.ioc.noioc.service;
/**
 *
 * 模拟业务逻辑层接口
 *
 * @author CaiXiangning 
 * @date May 13, 2017 
 * @email caixiangning@gmail.com
 */
public interface AccountService {
	
	/**
	 * 模拟根据id获取账号方法
	 * @param id
	 */
	public void getById(long id);
}
