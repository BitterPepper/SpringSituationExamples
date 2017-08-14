package com.macbook.javaConfig;

public interface MessageRenderer {
	void render();
	void setMessageProvider(MessageProvider provider);
	MessageProvider getMessageProvider();
}
