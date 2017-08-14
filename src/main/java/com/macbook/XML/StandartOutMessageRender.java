package com.macbook.XML;

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
		System.out.println("Done setMessageProvider");
		this.messageProvider = provider;
	}

	@Override
	public MessageProvider getMessageProvider() {
		// TODO Auto-generated method stub
		return this.messageProvider;
	}
	
}
