package com.macbook.aop.annotation;

import org.springframework.context.support.GenericXmlApplicationContext;

public class AspectJAnnotationExample {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("META-INF/spring/app-aop_annotation.xml");
		ctx.refresh();
		
		MyBean myBean = (MyBean) ctx.getBean("myBean");
		myBean.execute();
	}
}
