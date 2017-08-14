package com.macbook.jpa_spring_data_audit;

import org.springframework.data.domain.AuditorAware;

public class AuditorAwareBean implements AuditorAware<String>{
	@Override
	public String getCurrentAuditor() {
		return "prospring4";
	}
}
