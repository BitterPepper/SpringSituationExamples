package com.macbook.jpa_spring_data_audit;

import org.springframework.data.repository.CrudRepository;

public interface ContactAuditRepository  extends CrudRepository<ContactAudit, Long>{
}
