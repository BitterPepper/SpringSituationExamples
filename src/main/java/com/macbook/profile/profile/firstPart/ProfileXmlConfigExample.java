package com.macbook.profile.profile.firstPart;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

//VM arguments: -Dspring.profiles.active="highschool"
//				-Dspring.profiles.active="kindergarten"
public class ProfileXmlConfigExample {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/*ProfilePart.xml");
		ctx.refresh();
		
		//or ctx.getEnvironment().setActiveProfiles("kindergarten");
		//and use annotation @profile
		
		FoodProviderService foodProviderService = ctx.getBean("foodProviderService", FoodProviderService.class);
		List<Food> lunchSet = foodProviderService.provideLunchSet();
		for(Food food : lunchSet){
			System.out.println("Food: "+ food.getName());
		}
	}
}
