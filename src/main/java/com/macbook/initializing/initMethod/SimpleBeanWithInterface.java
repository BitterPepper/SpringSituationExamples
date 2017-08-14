package com.macbook.initializing.initMethod;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SimpleBeanWithInterface {
	private static final String DEFAULT_NAME = "Sergio";
	private String name;
	private int age = Integer.MIN_VALUE;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void init(){
		System.out.println("Initializing bean");
		
		if (name == null){
			System.out.println("Using default name");
			name = DEFAULT_NAME;
		}
		if (age == Integer.MIN_VALUE){
			throw new IllegalArgumentException("Set age"+ SimpleBeanWithInterface.class);
		}
	}
	
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("META-INF/spring/app-initMethod.xml");
		ctx.refresh();
		
		SimpleBeanWithInterface simpleBean1 = getBean("simpleBean1", ctx);
		SimpleBeanWithInterface simpleBean2 = getBean("simpleBean2", ctx);
		SimpleBeanWithInterface simpleBean3 = getBean("simpleBean3", ctx);
	}
	
	private static SimpleBeanWithInterface getBean(String beanName, ApplicationContext ctx){
		try{
			SimpleBeanWithInterface bean = (SimpleBeanWithInterface) ctx.getBean(beanName);
			System.out.println(bean);
			return bean;
		}catch (BeanCreationException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String toString() {
		return "SimpleBean [name=" + name + ", age=" + age + "]";
	}
}
