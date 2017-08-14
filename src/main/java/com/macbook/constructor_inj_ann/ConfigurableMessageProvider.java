package com.macbook.constructor_inj_ann;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("messageProvider")
public class ConfigurableMessageProvider implements MessageProvider {
	private String message;
		
	@Autowired
//TODO hard codding of message
//	public ConfigurableMessageProvider(
//			@Value("Annotation configurable message") String message) {
	//TODO message from xml config
	public ConfigurableMessageProvider(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}

}
