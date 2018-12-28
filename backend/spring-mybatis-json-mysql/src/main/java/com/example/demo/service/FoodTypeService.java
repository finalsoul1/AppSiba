package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.mapper.FoodTypeMapper;
import com.example.demo.model.FoodType;

@Service
public class FoodTypeService {
	@Autowired
	private FoodTypeMapper foodTypeMapper;
	
	public int insertFoodType(FoodType foodType) {
		return foodTypeMapper.insertSelective(foodType);
		
	}
}
