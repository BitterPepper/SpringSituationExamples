package com.macbook.aop.aspectj;

import org.springframework.context.support.GenericXmlApplicationContext;

public class AspectJExample {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("META-INF/spring/app-aop_aspectj.xml");
		ctx.refresh();
		
		MessageWriter writer = new MessageWriter();
		writer.writeMessage();
		writer.foo();
	}
}

