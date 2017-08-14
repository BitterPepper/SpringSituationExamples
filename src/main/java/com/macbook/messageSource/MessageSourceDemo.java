package com.macbook.messageSource;

import java.util.Locale;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MessageSourceDemo {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/app-messageSource.xml");
		ctx.refresh();
		
		Locale english = Locale.ENGLISH;
		Locale czech = new Locale("cs", "CZ");
		
		System.out.println(ctx.getMessage("msg", null, english));
		System.out.println(ctx.getMessage("msg", null, czech));
		
		System.out.println(ctx.getMessage("nameMsg", new Object[]{"Chris", "Schaefer"}, english));
	}
}
