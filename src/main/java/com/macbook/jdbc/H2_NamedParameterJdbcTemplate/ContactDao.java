package com.macbook.jdbc.H2_NamedParameterJdbcTemplate;

import java.util.List;

public interface ContactDao {
	String findFirstNameById(Long id);
	
	List<Contact> findAll();
	
	List<Contact> findAllWithDetail();
}
