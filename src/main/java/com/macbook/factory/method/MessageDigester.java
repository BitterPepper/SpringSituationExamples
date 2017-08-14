package com.macbook.factory.method;

import java.security.MessageDigest;

public class MessageDigester {
	MessageDigest digest1;
	MessageDigest digest2;
	
	public void setDigest1(MessageDigest digest){
		this.digest1 = digest;
	}

	public void setDigest2(MessageDigest digest){
		this.digest2 = digest;
	}
	
	public void digest(String msg){
		System.out.println("Using digest 1");
		digest(msg, digest1);

		System.out.println("Using digest 2");
		digest(msg, digest2);
	}
	
	private void digest(String msg, MessageDigest digest){
		System.out.println("Using alogrithm: " + digest. getAlgorithm ());
		digest.reset();
		byte[] bytes = msg.getBytes();
		byte[] out = digest.digest(bytes);
		System.out.println(out);
	}
}
