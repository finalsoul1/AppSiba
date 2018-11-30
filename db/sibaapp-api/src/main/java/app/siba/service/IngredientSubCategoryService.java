package app.siba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.siba.mapper.IngredientSubCategoryMapper;
import app.siba.model.IngredientSubCategory;
import app.siba.model.IngredientSubCategoryExample;

@Service
public class IngredientSubCategoryService {

	@Autowired
	private IngredientSubCategoryMapper ingredientSubCategoryMapper;
	
	public List<IngredientSubCategory> getIngredientSubCategoryList() {
		IngredientSubCategoryExample example = new IngredientSubCategoryExample();
		return ingredientSubCategoryMapper.selectByExample(example);
	}
	
	public long getTotalCount() {
		IngredientSubCategoryExample example = new IngredientSubCategoryExample();
		return ingredientSubCategoryMapper.countByExample(example);
	}
	
}
