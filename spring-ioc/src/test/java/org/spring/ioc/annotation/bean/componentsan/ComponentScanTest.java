package org.spring.ioc.annotation.bean.componentsan;

import org.junit.Test;
import org.spring.ioc.annotation.bean.componentscan.dao.AccountDao;
import org.spring.ioc.annotation.bean.componentscan.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.Assert;

/**
 *
 * 测试自动发现并注册装配Bean
 *
 * @author CaiXiangning 
 * @date May 18, 2017 
 * @email caixiangning@gmail.com
 */
public class ComponentScanTest {
	
	/**
	 * 	扫描指定包，自动检测类并注册装配相应Bean
	 * (必须使用@Repository、@Service、@Controller、@Component注解类，并使用@Autowired、@Resource、@Required装配类)
		包含 <context:annotation-config/>完成的工作，所以使用该配置就可以不使用<context:annotation-config/>
		类自动发现并注册Bean的条件是：使用@Repository、@Service、@Controller、@Component注解
	 */
	@SuppressWarnings("resource")
	@Test
	public void testComponentScan(){
		ApplicationContext context = new ClassPathXmlApplicationContext("annotation/bean/componentscan/spring-component-scan.xml");
		AccountService accountService = context.getBean("accountServiceImpl", AccountService.class);
		Assert.assertNotNull(accountService);
		accountService.getById(1);
	}
	
	/**
	 * 使用<context:component-scan>自动发现并注册Bean，默认生成的Bean的名字是注解的类的首字母小写的类名
	 * 当然@Repository、@Service、@Controller、@Component这些注解有属性，用于指定Bean的名字(FE:@Repository(accountDao))
	 * 
	 */
	@SuppressWarnings("resource")
	@Test
	public void testComponentScanDefaultBeanName(){
		ApplicationContext context = new ClassPathXmlApplicationContext("annotation/bean/componentscan/spring-component-scan.xml");
		AccountDao accountDao = context.getBean("accountDao", AccountDao.class);
		Assert.assertNotNull(accountDao);
		AccountService accountService = context.getBean("accountServiceImpl", AccountService.class);
		Assert.assertNotNull(accountService);
		accountService.getById(1);
	}
	
	/**
	 * 使用<context:include-filter>进行白名单过滤需要配合使用use-default-filters="false"属性
	 use-default-filters="false"用于禁用自动发现和注册，否则即使使用<context:include-filter>
	 仍然会自动发现并注册其他注解的类
	 */
	@SuppressWarnings("resource")
	@Test
	public void testComponentScanInclude(){
		ApplicationContext context = new ClassPathXmlApplicationContext("annotation/bean/componentscan/spring-component-scan-include.xml");
		AccountDao accountDao = context.getBean("accountDao", AccountDao.class);
		Assert.assertNotNull(accountDao);
		AccountService accountService = null;
		try {
			accountService = context.getBean("accountServiceImpl", AccountService.class);
		} catch (Exception e) {
			// TODO: handle exception
		}
		Assert.assertNull(accountService);
	}
	
	/**
	 * 使用<context:exclude-filter>进行黑名单过滤自动排除指定包下相应的注解
	 */
	@SuppressWarnings("resource")
	@Test
	public void testComponentScanExclude(){
		ApplicationContext context = new ClassPathXmlApplicationContext("annotation/bean/componentscan/spring-component-scan-exclude.xml");
		AccountDao accountDao = context.getBean("accountDao", AccountDao.class);
		Assert.assertNotNull(accountDao);
		AccountService accountService = null;
		try {
			accountService = context.getBean("accountService", AccountService.class);
		} catch (Exception e) {
			// TODO: handle exception
		}
		Assert.assertNull(accountService);
	}
}
