package com.macbook.setter_inj_ann;

public interface MessageRender {
	void render();
	void setMessageProvider(MessageProvider provider);
	MessageProvider getMessageProvider();
}
