package com.macbook.jdbc.dao_annotation;

import java.sql.Date;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

public class AnnotationJdbcDaoSample {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/app-jdbc_dao_annotation.xml");
		ctx.refresh();
		ContactDao contactDao = ctx.getBean("contactDao", ContactDao.class);

// find all
//		List<Contact> contacts = contactDao.findAll();
//		listContacts(contacts);
// find by first name
//		List<Contact> contacts = contactDao.findByFirstName("Chris");
//		listContacts(contacts);
// update
//		Contact contact = new Contact();
//		contact.setId(1L);
//		contact.setFirstName("Chris");
//		contact.setLastName("John");
//		contact.setBirthDate(new Date(new GregorianCalendar(1977, 10, 1).getTime().getTime()));
//		contactDao.update(contact);		
//		listContacts(contactDao.findAll());
// insert
//		Contact contact = new Contact();
//		contact.setFirstName("Rod");
//		contact.setLastName("Johnson");
//		contact.setBirthDate(new Date(new GregorianCalendar(2001, 10, 1).getTime().getTime()));
//		contactDao.insert(contact);		
//		listContacts(contactDao.findAll());
//	insertWithDetails findAllWithDetail
//		Contact contact = new Contact();
//		contact.setFirstName("Michael");
//		contact.setLastName("Jackson");
//		contact.setBirthDate(new Date(new GregorianCalendar(1964, 10, 1).getTime().getTime()));
//		List<ContactTelDetail> contactTelDetails = new ArrayList<>();
//
//		ContactTelDetail contactTelDetail = new ContactTelDetail();
//		contactTelDetail.setTelType("Home");
//		contactTelDetail.setTelNumber("11111111");
//		contactTelDetails.add(contactTelDetail);
//
//		contactTelDetail = new ContactTelDetail();
//		contactTelDetail.setTelType("Mobile");
//		contactTelDetail.setTelNumber("22222222");
//		contactTelDetails.add(contactTelDetail);
//		
//		contact.setContactTelDetails(contactTelDetails);
//		contactDao.insertWithDetail(contact);
//
//		listContacts(contactDao.findAllWithDetail());
//stored function
		System.out.println(contactDao.findFirstNameById(1L));
	}
	
	private static void listContacts(List<Contact> contacts){
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
