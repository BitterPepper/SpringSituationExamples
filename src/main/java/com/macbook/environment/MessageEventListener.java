package com.macbook.environment;

import org.springframework.context.ApplicationListener;

public class MessageEventListener implements ApplicationListener<MessageEvent> {
	@Override
	public void onApplicationEvent(MessageEvent event) {
		MessageEvent msgEvt = (MessageEvent) event;
		System.out.println("Recieved: " + msgEvt.getMessage());
	}
}
