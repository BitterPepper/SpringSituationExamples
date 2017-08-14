package com.macbook.aop.nameMatchMethodPointcut;

import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.aop.support.NameMatchMethodPointcutAdvisor;

import com.macbook.aop.staticMethodMatchingPoincut.SimpleAdvice;

public class NamePointcutExample {
	public static void main(String[] args) {
		NameBean target = new NameBean();
		//first variant
		NameMatchMethodPointcut pc = new NameMatchMethodPointcut();
		pc.addMethodName("foo");
		pc.addMethodName("bar");
		Advisor advisor = new DefaultPointcutAdvisor(pc, new SimpleAdvice());
		ProxyFactory pf = new ProxyFactory();
		// or
//		NameMatchMethodPointcutAdvisor advisor = 
//				new NameMatchMethodPointcutAdvisor(new SimpleAdvice());
//		advisor.addMethodName("foo");
//		advisor.addMethodName("bar");

		pf.setTarget(target);
		pf.addAdvisor(advisor);
		NameBean proxy = (NameBean) pf.getProxy();
		
		proxy.foo();
		proxy.foo(999);
		proxy.bar();
		proxy.yup();
	}
}
