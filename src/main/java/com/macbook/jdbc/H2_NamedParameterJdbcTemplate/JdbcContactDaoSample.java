package com.macbook.jdbc.H2_NamedParameterJdbcTemplate;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

public class JdbcContactDaoSample {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/app-jdbc_h2_NamedParameter_jdbcTemplate.xml");
		ctx.refresh();

		ContactDao contactDao = ctx.getBean("contactDao", ContactDao.class);
		List<Contact> contacts = contactDao.findAll();
		for (Contact contact : contacts) {
			System.out.println(contact);
		}

		contacts = contactDao.findAllWithDetail();
		for (Contact contact : contacts) {
			System.out.println(contact);
			if (contact.getContactTelDetails() != null) {
				for (ContactTelDetail contactTelDetail : contact.getContactTelDetails()) {
					System.out.println("---" + contactTelDetail);
				}
			}
		}
	}
}
