package com.macbook.setter_inj;

public interface MessageRender {
	void render();
	void setMessageProvider(MessageProvider provider);
	MessageProvider getMessageProvider();
}
