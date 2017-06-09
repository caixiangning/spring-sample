package org.spring.ioc.xml.bean.instantiation;

import org.spring.ioc.xml.bean.instantiation.dao.AccountDao;

/**
 *
 * 
 *
 * @author CaiXiangning 
 * @date May 15, 2017 
 * @email caixiangning@gmail.com
 */
public class AccountDaoImpl3Factory {
	private static AccountDao accountDao = new AccountDaoImpl3();
	
	private AccountDaoImpl3Factory(){
		
	}
	
	public AccountDao createAccountDao(){
		return accountDao;
	}
}
