package com.macbook.value_inject_spell_ann;

import org.springframework.stereotype.Component;

@Component("injectSimpleConfig")
public class InjectSimpleConfig {
	private String name = "Sergey";
	private int age = 34;
	private float height = 1.7f;
	private boolean programmer = true;
	private Long ageInSecond = 1000000L;

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

}
