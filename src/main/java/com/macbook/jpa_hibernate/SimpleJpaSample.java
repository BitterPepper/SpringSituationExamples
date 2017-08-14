package com.macbook.jpa_hibernate;

import java.util.List;
import java.util.Set;

import org.springframework.context.support.GenericXmlApplicationContext;

public class SimpleJpaSample {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/app-jpa_hibernate.xml");
		ctx.refresh();

		ContactService contactService = ctx.getBean("jpaContactService", ContactService.class);
		// find all
		// listContacts(contactService.findAll());

		// find all with details
		// List<Contact> contacts = contactService.findAllWithDetail();
		// listContactsWithDetail(contacts);

		// find with conditions
		// ContactSummaryUntypeImpl contactSummaryUntype =
		// ctx.getBean("contactSummaryUntype", ContactSummaryUntypeImpl.class);
		// contactSummaryUntype.displayAllContactSummary();

		// find summary and transform
		// ContactSummaryService contactSummaryService =
		// ctx.getBean("contactSummaryService", ContactSummaryService.class);
		// List<ContactSummary> contacts = contactSummaryService.findAll();
		// for (ContactSummary contactSurnmary : contacts) {
		// System.out.println(contactSurnmary);
		// }

		// save
		// Contact contact = new Contact();
		// contact.setFirstName("Michael");
		// contact.setLastName("Jackson");
		// contact.setBirthDate(new Date());
		// ContactTelDetail contactTelDetail = new ContactTelDetail("Home",
		// "1111111111");
		// contact.addContactTelDetail(contactTelDetail);
		// contactTelDetail = new ContactTelDetail("MoЬile", "2222222222");
		// contact.addContactTelDetail(contactTelDetail);
		// contactService.save(contact);
		// listContactsWithDetail(contactService.findAllWithDetail());

		// update
		// Contact contact = contactService.findById(1L);
		// System.out.println("");
		// System.out.println("Contact with id 1:" + contact);
		// System.out.println("");
		// contact.setFirstName("Justin");
		// Set<ContactTelDetail> contactTels = contact.getContactTelDetails();
		// ContactTelDetail toDeleteContactTel = null;
		// for (ContactTelDetail contactTel : contactTels) {
		// if (contactTel.getTelType().equals("Home")) {
		// toDeleteContactTel = contactTel;
		// }
		// }
		// contactTels.remove(toDeleteContactTel);
		// contactService.save(contact);
		// listContactsWithDetail(contactService.findAllWithDetail());

		// delete
		// Contact contact = contactService.findById(1L);
		// contactService.delete(contact);
		// listContactsWithDetail(contactService.findAllWithDetail());

		// native query
//		listContacts(contactService.findByNativeQuery());
		
		// criteria query
		List<Contact> contacts = contactService. findByCriteriaQuery("John", "Smith");
		listContactsWithDetail(contacts);
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
