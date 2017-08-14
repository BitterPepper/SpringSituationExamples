package com.macbook.setter_inj_ann;

import org.springframework.context.support.GenericXmlApplicationContext;

public class DeclareSpringComponents {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/app-setter_inj_ann.xml");
		ctx.refresh();
		MessageRender messageRender = ctx.getBean("messageRender", MessageRender.class);
		messageRender.render();
	}
}
