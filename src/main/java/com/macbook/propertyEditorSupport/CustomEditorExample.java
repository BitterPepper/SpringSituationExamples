package com.macbook.propertyEditorSupport;

import org.springframework.context.support.GenericXmlApplicationContext;

public class CustomEditorExample {
	private Name name;

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public static void main(String[] args) throws Exception{
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("META-INF/spring/app-propertyEditorSupport.xml");
		ctx.refresh();

		CustomEditorExample bean = ctx.getBean("exampleBean", CustomEditorExample.class);
		System.out.println(bean.getName());
	}
}
