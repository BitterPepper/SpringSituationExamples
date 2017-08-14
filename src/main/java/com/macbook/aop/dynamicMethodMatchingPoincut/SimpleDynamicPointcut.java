package com.macbook.aop.dynamicMethodMatchingPoincut;

import java.lang.reflect.Method;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;

public class SimpleDynamicPointcut extends DynamicMethodMatcherPointcut {
	@Override
	public boolean matches(Method method, Class<?> cls) {
		System.out.println("Static check for " + method.getName());
		return ("foo".equals(method.getName()));
	}

	@Override
	public boolean matches(Method method, Class<?> cls, Object[] args) {
		System.out.println("Dynamic check for " + method.getName());
		int x = (int) args[0];
		return (x != 100);
	}
	
	@Override
	public ClassFilter getClassFilter(){
		return new ClassFilter(){
			public boolean matches(Class<?> cls){
				return (cls == SampleBean.class);
			}
		};
	}
}
