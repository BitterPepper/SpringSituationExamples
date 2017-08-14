package com.macbook.factory.bean;

import java.security.MessageDigest;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MessageDigestExample {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("META-INF/spring/app-factoryBean.xml");
		ctx.refresh();
		MessageDigester digester = (MessageDigester) ctx.getBean("digester");
		digester.digest("Hello World");

		MessageDigest digest = (MessageDigest) ctx.getBean("shaDigest");
		// getting factory
		MessageDigestFactoryBean factoryBean = (MessageDigestFactoryBean) ctx.getBean("&shaDigest");
		try {
			MessageDigest shaDigest = factoryBean.getObject();
			System.out.println(shaDigest.digest("Hello world".getBytes()));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}