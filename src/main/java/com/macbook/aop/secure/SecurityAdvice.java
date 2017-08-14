package com.macbook.aop.secure;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class SecurityAdvice implements MethodBeforeAdvice {
	private SecurityManager securityManager;

	public SecurityAdvice() {
		this.securityManager = new SecurityManager();
	}

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		UserInfo user = securityManager.getLoggedOnUser();

		if (user == null) {
			System.out.println("No user authenticated");
			throw new SecurityException("You must login before attempting to invoke the method: " + method.getName());
		} else if ("Serg".equals(user.getUserName())) {
			System.out.println("Logged in user is Serg - ОКАУ ! ");
		} else {
			System.out.println("Logged in user is " + user.getUserName()+ " NOT GOOD :( ");
			throw new SecurityException(
					"User" + user.getUserName() + " is not allowed access to method " + method.getName());
		}
	}
}
