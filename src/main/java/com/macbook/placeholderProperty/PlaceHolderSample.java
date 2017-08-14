package com.macbook.placeholderProperty;

import org.springframework.context.support.GenericXmlApplicationContext;

public class PlaceHolderSample {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/app-placeholderProperty.xml");
		ctx.refresh();
	
		AppProperty appProperty = ctx.getBean("appProperty", AppProperty.class);
		System.out.println ("application.home: " + appProperty.getApplicationHome ());
		System.out.println("user.home: " + appProperty.getUserHome());
	}
}
