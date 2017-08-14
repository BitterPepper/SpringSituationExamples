package com.macbook.annotation;

public interface MessageRender {
	void render();
	void setMessageProvider(MessageProvider provider);
	MessageProvider getMessageProvider();
}
