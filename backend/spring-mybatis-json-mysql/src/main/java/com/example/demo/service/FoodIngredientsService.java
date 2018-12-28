package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.FoodIngredientsMapper;
import com.example.demo.model.FoodIngredients;

@Service
public class FoodIngredientsService {

	@Autowired
	private FoodIngredientsMapper ingredientsMapper;
	
	public int insertIncredients(FoodIngredients ingredients) {
		return ingredientsMapper.insertSelective(ingredients);
	}
}
