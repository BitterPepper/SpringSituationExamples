package com.macbook.jsr330Example;

import org.springframework.context.support.GenericXmlApplicationContext;

public class JavaConfigSimpleExample {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/app-jsr330Example.xml");
		ctx.refresh();
		MessageRenderer renderer = ctx.getBean("messageRenderer", MessageRenderer.class);
		renderer.render();
	}
}
