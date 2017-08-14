package com.macbook.value_inject_ann;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service("injectSimple")
public class InjectSimple {
	@Value("Sergey")
	private String name;
	
	@Value("34")
	private int age;
	
	@Value("1.7")
	private float height;
	
	@Value("true")
	private boolean programmer;
	
	@Value("1000000")
	private Long ageInSecond;
	
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("META-INF/spring/app-value_inject_ann.xml");
		ctx.refresh();
		InjectSimple simple = ctx.getBean("injectSimple", InjectSimple.class);
		System.out.println(simple);
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public void setProgrammer(boolean programmer) {
		this.programmer = programmer;
	}

	public void setAgeInSecond(Long ageInSecond) {
		this.ageInSecond = ageInSecond;
	}

	@Override
	public String toString() {
		return "InjectSimple [name=" + name + ", age=" + age + ", height=" + height + ", programmer=" + programmer
				+ ", ageInSecond=" + ageInSecond + "]";
	}
}
