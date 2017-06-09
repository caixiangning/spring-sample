package org.spring.ioc.annotation.bean.annotationconfig.dao;

/**
 *
 * 模拟数据访问层接口
 *
 * @author CaiXiangning 
 * @date May 12, 2017 
 * @email caixiangning@gmail.com
 */
public interface AccountDao {
	/**
	 * 模拟根据id获取账号方法
	 * @param id
	 * @return
	 */
	public void getById(long id);
}
