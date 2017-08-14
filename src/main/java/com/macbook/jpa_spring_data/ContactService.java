package com.macbook.jpa_spring_data;

import java.util.List;

public interface ContactService {
    List<Contact> findAll();
    List<Contact> findByFirstName(String firstName);
    List<Contact> findByFirstNameAndLastName(String firstName, String lastName);
}
