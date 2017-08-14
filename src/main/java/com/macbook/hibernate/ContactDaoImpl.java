package com.macbook.hibernate;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import javax.annotation.Resource;
import java.util.List;

@Transactional
@Repository("сontactDao")
public class ContactDaoImpl implements ContactDao {
	private static final Log LOG = LogFactory.getLog(ContactDaoImpl.class);

	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Contact> findAll() {
		LOG.info("***** triggered Find all");
		return sessionFactory.getCurrentSession().createQuery("from Contact c").list();
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Contact> findAllWithDetail() {
		LOG.info("***** triggered Find all with details");
		return sessionFactory.getCurrentSession().getNamedQuery("Contact.findAllWithDetail").list();
	}

	@Transactional(readOnly = true)
	public Contact findById(Long id) {
		LOG.info("***** triggered Find by id");
		return (Contact) sessionFactory.getCurrentSession().createNamedQuery("Contact.findById").
				setParameter("id", id).uniqueResult();
	}

	public Contact save(Contact contact) {
		LOG.info("***** triggered save");
		sessionFactory.getCurrentSession().saveOrUpdate(contact);
		return contact;
	}

	public void delete(Contact contact) {
		LOG.info("Contact deleted with id: " + contact.getId());
		sessionFactory.getCurrentSession().delete(contact);
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
