package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.FoodRecipeMapper;
import com.example.demo.model.FoodRecipe;

@Service
public class FoodRecipeService {

	@Autowired
	private FoodRecipeMapper recipeMapper;
	
	public int insertRecipe(FoodRecipe recipe) {
		return recipeMapper.insertSelective(recipe);
	}
	
}
