package com.macbook.value_inject_spell_xml;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Service;

public class InjectSimpleSpel {
	private String name;
	private int age;
	private float height;
	private boolean programmer;
	private Long ageInSecond;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public float getHeight() {
		return height;
	}
	public void setHeight(float height) {
		this.height = height;
	}
	public boolean isProgrammer() {
		return programmer;
	}
	public void setProgrammer(boolean programmer) {
		this.programmer = programmer;
	}
	public Long getAgeInSecond() {
		return ageInSecond;
	}
	public void setAgeInSecond(Long ageInSecond) {
		this.ageInSecond = ageInSecond;
	}
	
	
	@Override
	public String toString() {
		return "InjectSimpleSpel [name=" + name + ", age=" + age + ", height=" + height + ", programmer=" + programmer
				+ ", ageInSecond=" + ageInSecond + "]";
	}
	
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/app-value_inject_spel_xml.xml");
		ctx.refresh();
		InjectSimpleSpel simple = ctx.getBean("injectSimpleSpel", InjectSimpleSpel.class);
		System.out.println(simple);
	}
}
