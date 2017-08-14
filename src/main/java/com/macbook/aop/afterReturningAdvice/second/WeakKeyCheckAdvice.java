package com.macbook.aop.afterReturningAdvice.second;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class WeakKeyCheckAdvice implements AfterReturningAdvice {
	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		if (target instanceof KeyGenerator && "getKey".equals(method.getName())){
			long key = ((Long) returnValue).longValue();
			
			if (key == KeyGenerator.WEAK_KEY){
				throw new SecurityException(
						"Кеу Generator generated а weak key. Try again");
			}
		}
	}
}
