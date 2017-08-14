package com.macbook.jpa_spring_data;

import java.util.List;
import java.util.Set;

import org.springframework.context.support.GenericXmlApplicationContext;

public class SimpleJpaSample {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/app-jpa_spring_data.xml");
		ctx.refresh();

		ContactService contactService = ctx.getBean("springJpaContactService", ContactService.class);

		listContacts("Find all: ", contactService.findAll());
		listContacts("Find Ьу first name: ", contactService.findByFirstName("Chris"));
		listContacts("Find Ьу first and last name: ", contactService.findByFirstNameAndLastName("Chris", "Schaefer"));
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

	private static void listContacts(String message, List<Contact> contacts) {
		System.out.println("");
		System.out.println(message);
		for (Contact contact : contacts) {
			System.out.println(contact);
			System.out.println();
		}
	}
}
