package com.macbook.value_inject_spell_ann;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service("injectSimpleSpel")
public class InjectSimpleSpel {
	@Value("#{injectSimpleConfig.name}")
	private String name;

	@Value("#{injectSimpleConfig.age-1}")
	private int age;
	
	@Value("#{injectSimpleConfig.height}")
	private float height;
	
	@Value("#{injectSimpleConfig.programmer}")
	private boolean programmer;
	
	@Value("#{injectSimpleConfig.ageInSecond}")
	private Long ageInSecond;
	
	@Override
	public String toString() {
		return "InjectSimpleSpel [name=" + name + ", age=" + age + ", height=" + height + ", programmer=" + programmer
				+ ", ageInSecond=" + ageInSecond + "]";
	}
	
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/app-value_inject_spel_ann.xml");
		ctx.refresh();
		InjectSimpleSpel simple = (InjectSimpleSpel)ctx.getBean("injectSimpleSpel");
		System.out.println(simple);
	}
}
