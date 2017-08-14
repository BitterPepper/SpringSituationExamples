package com.macbook.jpa_spring_data_audit;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;

@Service("contactAuditService")
@Repository
@Transactional
public class ContactAuditServiceImpl implements ContactAuditService{
	@Autowired
	private ContactAuditRepository contactAuditRepository;

	@Override
	@Transactional(readOnly=true)
	public List<ContactAudit> findAll() {
		return Lists.newArrayList(contactAuditRepository.findAll());
	}

	@Override
	public ContactAudit findById(Long id) {
		return contactAuditRepository.findOne(id);
	}

	@Override
	public ContactAudit save(ContactAudit contact) {
		return contactAuditRepository.save(contact);
	}
	
	
}
