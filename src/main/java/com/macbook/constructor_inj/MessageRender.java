package com.macbook.constructor_inj;

public interface MessageRender {
	void render();
	void setMessageProvider(MessageProvider provider);
	MessageProvider getMessageProvider();
}
