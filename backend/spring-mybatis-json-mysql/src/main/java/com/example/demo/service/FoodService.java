package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.FoodMapper;
import com.example.demo.model.Food;

@Service
public class FoodService {
	
	@Autowired
	private FoodMapper foodMapper;
	
	public int insertFood(Food food) {
		foodMapper.insertSelective(food);
		return food.getId();
	}
	
	
	
}
