package com.macbook.annotation;

import org.springframework.context.support.GenericXmlApplicationContext;

public class DeclareSpringComponents {
	
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("META-INF/spring/app-annotation.xml");
		ctx.refresh();
		MessageProvider messageProvider = ctx.getBean("messageProvider", MessageProvider.class);
		System.out.println(messageProvider.getMessage());
	}
}
