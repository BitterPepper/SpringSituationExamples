package com.macbook.hibernate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringHibernateSample {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/app-hibernate.xml");
		ctx.refresh();

		ContactDao contactDao = ctx.getBean("сontactDao", ContactDao.class);
		// find all
		// listContacts(contactDao.findAll());

		// find by id
		// List<Contact> contacts = new ArrayList<>();
		// contacts.add(contactDao.findById(1L));
		// listContactsWithDetail(contacts);

		// save or update
		// Contact contact = new Contact();
		// contact.setFirstName("Michael");
		// contact.setLastName("Jackson");
		// contact.setBirthDate(new Date());
		// ContactTelDetail contactTelDetail = new
		// ContactTelDetail("Home","1111111111");
		// contact.addContactTelDetail(contactTelDetail);
		// contactTelDetail = new ContactTelDetail("Mobile", "2222222222");
		// contact.addContactTelDetail(contactTelDetail);
		// contactDao.save(contact);
		// listContactsWithDetail(contactDao.findAllWithDetail());

		// update
//		Contact contact = contactDao.findById(1L);
//		contact.setFirstName("Kim Fung");
//		Set<ContactTelDetail> contactTels = contact.getContactTelDetails();
//		ContactTelDetail toDeleteContactTel = null;
//		for (ContactTelDetail contactTel : contactTels) {
//			if (contactTel.getTelType().equals("Home")) {
//				toDeleteContactTel = contactTel;
//			}
//		}
//		contact.removeContactTelDetail(toDeleteContactTel);
//		contactDao.save(contact);
//		listContactsWithDetail(contactDao.findAllWithDetail());
		
//		delete
		Contact contact = contactDao.findById(1L);
		contactDao.delete(contact);
		listContactsWithDetail(contactDao.findAllWithDetail());
	}

	private static void listContactsWithDetail(List<Contact> contacts) {
		System.out.println("");
		System.out.println("Listing contacts with details:");
		for (Contact contact : contacts) {
			System.out.println(contact);

			if (contact.getContactTelDetails() != null) {
				for (ContactTelDetail contactTelDetail : contact.getContactTelDetails()) {
					System.out.println(contactTelDetail);
				}
			}
			if (contact.getHobbies() != null) {
				for (Hobby hobby : contact.getHobbies()) {
					System.out.println(hobby);
				}
			}
			System.out.println();
		}
	}

	private static void listContacts(List<Contact> contacts) {
		System.out.println("");
		System.out.println("Listing contacts without details:");
		for (Contact contact : contacts) {
			System.out.println(contact);
			System.out.println();
		}
	}
}
