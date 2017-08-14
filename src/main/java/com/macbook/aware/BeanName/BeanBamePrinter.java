package com.macbook.aware.BeanName;

import org.springframework.beans.factory.BeanNameAware;

public class BeanBamePrinter implements BeanNameAware{
	private String beanName;
	
	@Override
	public void setBeanName(String name) {
		this.beanName = name;
	}
	
	public void someOperation(){
		System.out.println("Bean name: "+beanName);
	}
}
