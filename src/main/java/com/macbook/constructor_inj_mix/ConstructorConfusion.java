package com.macbook.constructor_inj_mix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.GenericXmlApplicationContext;

public class ConstructorConfusion {
	private String someValue;

	public ConstructorConfusion(String someValue) {
		System.out.println("ConstructorConfusion string called");
		this.someValue = someValue;
	}
	
	//TODO for annotation. Permitted only for one constructor
	@Autowired
	public ConstructorConfusion(int someValue) {
		System.out.println("ConstructorConfusion int called");
		this.someValue = "Number:" + Integer.valueOf(someValue);
	}
	
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("META-INF/spring/app-constructor_inj_mix.xml");
		ctx.refresh();
		ConstructorConfusion cc = ctx.getBean("constructorConfusion", ConstructorConfusion.class);
		System.out.println(cc);
	}

	@Override
	public String toString() {
		return "ConstructorConfusion [someValue=" + someValue + "]";
	}
}
