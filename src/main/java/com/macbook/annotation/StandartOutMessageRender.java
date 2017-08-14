package com.macbook.annotation;

import org.springframework.stereotype.Service;

@Service("messageRender")
public class StandartOutMessageRender implements MessageRender{
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
