package com.macbook.jpa_hibernate;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("contactSummaryService")
@Repository
@Transactional
public class ContactSummaryServiceImpl implements ContactSummaryService{
	@PersistenceContext
	private EntityManager em;

	@Transactional(readOnly=true)
	@Override
	@SuppressWarnings("unchecked")
	public List<ContactSummary> findAll() {
		List<ContactSummary> result = em.createQuery(
		"select new com.macbook.jpa_hibernate.ContactSummary("
		+ "c.firstName, c.lastName, t.telNumber) "
		+ "from Contact c left join c.contactTelDetails t "
		+ "where t.telType='Home'").getResultList();
		
		return result;
	}
}
