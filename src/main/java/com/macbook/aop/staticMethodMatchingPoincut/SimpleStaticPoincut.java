package com.macbook.aop.staticMethodMatchingPoincut;

import java.lang.reflect.Method;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcut;

public class SimpleStaticPoincut extends StaticMethodMatcherPointcut{
	@Override
	public boolean matches(Method method, Class<?> cls){
		System.out.println("Static check for " + method.getName());
		return ("foo".equals(method.getName()));
	}
	
	@Override
	public ClassFilter getClassFilter(){
		return new ClassFilter(){
			public boolean matches(Class<?> cls){
				return (cls == BeanOne.class);
			}
		};
	}
}
