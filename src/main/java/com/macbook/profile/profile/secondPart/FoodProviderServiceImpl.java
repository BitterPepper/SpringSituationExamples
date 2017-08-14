package com.macbook.profile.profile.secondPart;

import java.util.ArrayList;
import java.util.List;

import com.macbook.profile.profile.firstPart.Food;
import com.macbook.profile.profile.firstPart.FoodProviderService;

public class FoodProviderServiceImpl implements FoodProviderService{
	
	@Override
	public List<Food> provideLunchSet(){
		List<Food> lunchSet = new ArrayList<Food>();
		lunchSet.add(new Food("Coke"));
		lunchSet.add(new Food("Hamburger"));
		lunchSet.add(new Food("French Fries"));
		
		return lunchSet;
	}
}
