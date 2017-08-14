package com.macbook.jpa_hibernate;

import java.util.List;

public interface ContactService {
    List<Contact> findAll();
    List<Contact> findAllWithDetail();
    Contact findById(Long id);
    Contact save(Contact contact);
    void delete(Contact contact);
    List<Contact> findByNativeQuery();
    List<Contact> findByCriteriaQuery(String firstName, String lastName);
}
