package com.macbook.aop.dynamicMethodMatchingPoincut;

import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

import com.macbook.aop.staticMethodMatchingPoincut.SimpleAdvice;

public class DynamicPointcutExample {
	public static void main(String[] args) {
		SampleBean target = new SampleBean();

		Advisor advisor = new DefaultPointcutAdvisor(new SimpleDynamicPointcut(), new SimpleAdvice());
		ProxyFactory pf = new ProxyFactory();
		pf.setTarget(target);
		pf.addAdvisor(advisor);
		SampleBean proxy = (SampleBean) pf.getProxy();

		proxy.foo(1);
		proxy.foo(10);
		proxy.foo(100);
		
		proxy.bar();
		proxy.bar();
		proxy.bar();
	}
}
