package com.macbook.setter_inj;

import org.springframework.context.support.GenericXmlApplicationContext;

public class DeclareSpringComponents {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("META-INF/spring/app-setter_inj.xml");
		ctx.refresh();
		MessageRender messageProvider = ctx.getBean("messageRender", MessageRender.class);
		messageProvider.render();
	}
}
