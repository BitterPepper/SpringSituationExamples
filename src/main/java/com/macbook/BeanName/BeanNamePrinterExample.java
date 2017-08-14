package com.macbook.BeanName;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.macbook.aware.BeanName.BeanBamePrinter;

public class BeanNamePrinterExample {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("META-INF/spring/app-beanNameAware.xml");
		ctx.refresh();

		BeanBamePrinter bean = ctx.getBean("beanBamePrinter", BeanBamePrinter.class);
		bean.someOperation();
	}
}
