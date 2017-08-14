package com.macbook.XML;

public interface MessageRender {
	void render();
	void setMessageProvider(MessageProvider provider);
	MessageProvider getMessageProvider();
}
