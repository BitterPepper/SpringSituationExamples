package com.macbook.jdbc.cleanJdbc;

import java.util.List;

public interface ContactDao {
	List<Contact> findAll();
	List<Contact> findByFirstName(String firstName);
	String findLastNameById(Long id);
	String findFirstNameById(Long id);
	void insert(Contact contact);
	void update(Long contactId);
	void delete(Long contactIs);
}
