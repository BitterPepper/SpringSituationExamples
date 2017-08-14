package com.macbook.aop.proxyFactoryBean_introduction;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.macbook.aop.isModified.delegatingIntroductionInterceptor.IsModified;
import com.macbook.aop.isModified.delegatingIntroductionInterceptor.TargetBean;

public class ProxyFactoryBeanExample {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("META-INF/spring/app-aop_proxyFactoryBean_introduction.xml");
		ctx.refresh();
		
		TargetBean bean = (TargetBean) ctx.getBean("bean");
		IsModified mod = (IsModified) bean;
		System.out.println("Is TargetBean?: " + (bean instanceof TargetBean) );
		System.out.println("Is IsModified?: " + (bean instanceof IsModified));
		System.out.println("Has been modified?: " + mod.isModified());
		bean.setName("Chris Schaefer");
		System.out.println("Has been modified?: " + mod.isModified());
	}
}
