package com.macbook.profile.profile.firstPart;

import java.util.ArrayList;
import java.util.List;

public class FoodProviderServiceImpl implements FoodProviderService{
	
	@Override
	public List<Food> provideLunchSet(){
		List<Food> lunchSet = new ArrayList<Food>();
		lunchSet.add(new Food("Milk"));
		lunchSet.add(new Food("Biscuits"));
		return lunchSet;
	}
}
