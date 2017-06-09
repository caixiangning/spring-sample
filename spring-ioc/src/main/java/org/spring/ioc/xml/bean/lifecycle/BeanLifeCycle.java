package org.spring.ioc.xml.bean.lifecycle;
/**
 *
 * 测试重写Bean生命周期：初始化、销毁
 *
 * @author CaiXiangning 
 * @date May 15, 2017 
 * @email caixiangning@gmail.com
 */
public class BeanLifeCycle {
	
	/**
	 * Bean初始化执行方法：通过<bean>元素的init-method属性的值来指定Bean初始化执行的方法名称
	 */
	public void init(){
		System.out.println("Bean初始化执行操作");
	}
	
	/**
	 * Bean销毁执行方法：通过<bean>元素的destroy-method的值来指定Bean销毁执行的方法名称
	 */
	public void destroy(){
		System.out.println("Bean销毁执行操作");
	}
	
	/**
	 * 其他业务方法
	 */
	public void doSomething(){
		System.out.println("****************调用业务方法****************");
	}
}
