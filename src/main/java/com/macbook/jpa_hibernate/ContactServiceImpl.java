package com.macbook.jpa_hibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("jpaContactService")
@Repository
@Transactional
public class ContactServiceImpl implements ContactService {
	private static final Log LOG = LogFactory.getLog(ContactServiceImpl.class);
	final static String ALL_CONTACT_NATIVE_QUERY = "select id, first_name, last_name, birth_date, version from contact";

	@PersistenceContext
	private EntityManager em;

	@Transactional(readOnly = true)
	@Override
	public List<Contact> findAll() {
		List<Contact> contacts = em.createNamedQuery("Contact.findAll", Contact.class).getResultList();
		return contacts;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Contact> findAllWithDetail() {
		List<Contact> contacts = em.createNamedQuery("Contact.findAllWithDetail", Contact.class).getResultList();
		return contacts;
	}

	@Transactional(readOnly = true)
	@Override
	public Contact findById(Long id) {
		TypedQuery<Contact> query = em.createNamedQuery("Contact.findById", Contact.class);
		query.setParameter("id", id);
		return query.getSingleResult();
	}

	@Override
	public Contact save(Contact contact) {
		if (contact.getId() == null) {
			LOG.info("Inserting new contact");
			em.persist(contact);
		} else {
			em.merge(contact);
			LOG.info("Updating existing contact");
		}

		LOG.info("Contact saved with id: " + contact.getId());
		return contact;
	}

	@Override
	public void delete(Contact contact) {
		Contact mergedContact = em.merge(contact);
		em.remove(mergedContact);

		LOG.info("Contact with id: " + contact.getId() + " deleted successfully");
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Contact> findByNativeQuery() {
		return em.createNativeQuery(ALL_CONTACT_NATIVE_QUERY, "contactResult").getResultList();
	}

	@Override
	public List<Contact> findByCriteriaQuery(String firstName, String lastName) {
		LOG.info("Finding contact for firstNarne: " + firstName + " and lastNarne: " + lastName);
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Contact> criteriaQuery = cb.createQuery(Contact.class);
		Root<Contact> contactRoot = criteriaQuery.from(Contact.class);
		contactRoot.fetch(Contact_.contactTelDetails, JoinType.LEFT);
		contactRoot.fetch(Contact_.hobbies, JoinType.LEFT);
		criteriaQuery.select(contactRoot).distinct(true);
		Predicate criteria = cb.conjunction();
		if (firstName != null){
			Predicate p = cb.equal(contactRoot.get(Contact_.firstName), firstName);
			criteria = cb.and(criteria, p);
		}
		if (lastName != null){
			Predicate p = cb.equal(contactRoot.get(Contact_.lastName), lastName);
			criteria = cb.and(criteria, p);
		}
		
		criteriaQuery.where(criteria);
		return em.createQuery(criteriaQuery).getResultList();
	}
}
