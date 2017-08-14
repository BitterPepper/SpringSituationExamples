package com.macbook.jsr330Example;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

@Named("messageRenderer")
@Singleton
public class StandartOutMessageRenderer implements MessageRenderer{
	@Inject
	@Named("messageProvider")
	private MessageProvider messageProvider;

	@Override
	public void render() {
		if (messageProvider == null) {
			throw new RuntimeException("Set message provider");
		}
		System.out.println(messageProvider.getMessage());
	}

	@Override
	public void setMessageProvider(MessageProvider provider) {
		this.messageProvider = provider;
	}

	@Override
	public MessageProvider getMessageProvider() {
		return this.messageProvider;
	}
	
}
