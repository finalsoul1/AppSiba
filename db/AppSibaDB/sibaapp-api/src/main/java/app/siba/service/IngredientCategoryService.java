package app.siba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.siba.mapper.IngredientCategoryMapper;
import app.siba.model.IngredientCategory;
import app.siba.model.IngredientCategoryExample;

@Service
public class IngredientCategoryService {

	@Autowired
	private IngredientCategoryMapper ingredientCategoryMapper;
	

	public List<IngredientCategory> getIngredientCategory() {
		IngredientCategoryExample example = new IngredientCategoryExample();
		return ingredientCategoryMapper.selectByExample(example);
	}
	
	public long getTotalCount() {
		IngredientCategoryExample example = new IngredientCategoryExample();
		return ingredientCategoryMapper.countByExample(example);
	}
	
}
