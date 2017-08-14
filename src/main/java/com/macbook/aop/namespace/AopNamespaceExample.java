package com.macbook.aop.namespace;

import org.springframework.context.support.GenericXmlApplicationContext;

public class AopNamespaceExample {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("META-INF/spring/app-aop_namespace.xml");
		ctx.refresh();
		
		MyBean myBean = (MyBean) ctx.getBean("myBean");
		myBean.execute();
	}
}
