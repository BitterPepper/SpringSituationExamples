package com.macbook.jsr330Example;

public interface MessageRenderer {
	void render();
	void setMessageProvider(MessageProvider provider);
	MessageProvider getMessageProvider();
}
