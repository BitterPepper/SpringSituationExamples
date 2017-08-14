package com.macbook.constructor_inj_ann;

import org.springframework.context.support.GenericXmlApplicationContext;

public class DeclareSpringComponents {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("META-INF/spring/app-constructor_inj_ann.xml");
		ctx.refresh();
		MessageProvider messageProvider = ctx.getBean("messageProvider", MessageProvider.class);
		System.out.println(messageProvider.getMessage());
	}
}
