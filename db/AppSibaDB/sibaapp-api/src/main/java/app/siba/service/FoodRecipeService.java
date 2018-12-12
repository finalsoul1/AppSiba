package app.siba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.siba.mapper.FoodRecipeMapper;
import app.siba.model.FoodRecipe;
import app.siba.model.FoodRecipeExample;

@Service
public class FoodRecipeService {

	@Autowired
	private FoodRecipeMapper foodRecipeMapper;
	
	public List<FoodRecipe> getFoodRecipeList() {
		FoodRecipeExample example = new FoodRecipeExample();
		example.setOrderByClause("food_id");
		return foodRecipeMapper.selectByExample(example);
	}
	
	public long getTotalCount() {
		FoodRecipeExample example = new FoodRecipeExample();
		return foodRecipeMapper.countByExample(example);
	}
}
