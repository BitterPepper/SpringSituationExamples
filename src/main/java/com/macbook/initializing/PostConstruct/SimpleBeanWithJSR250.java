package com.macbook.initializing.PostConstruct;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SimpleBeanWithJSR250{
	private static final String DEFAULT_NAME = "Sergio";
	private String name;
	private int age = Integer.MIN_VALUE;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	@PostConstruct
	public void init(){
		System.out.println("Initializing bean");
		
		if (name == null){
			System.out.println("Using default name");
			name = DEFAULT_NAME;
		}
		if (age == Integer.MIN_VALUE){
			throw new IllegalArgumentException("Set age"+ SimpleBeanWithJSR250.class);
		}
	}
	
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("META-INF/spring/app-initializingAnnPostConstruct.xml");
		ctx.refresh();
		
		SimpleBeanWithJSR250 simpleBean1 = getBean("simpleBean1", ctx);
		SimpleBeanWithJSR250 simpleBean2 = getBean("simpleBean2", ctx);
		SimpleBeanWithJSR250 simpleBean3 = getBean("simpleBean3", ctx);
	}
	
	private static SimpleBeanWithJSR250 getBean(String beanName, ApplicationContext ctx){
		try{
			SimpleBeanWithJSR250 bean = (SimpleBeanWithJSR250) ctx.getBean(beanName);
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
