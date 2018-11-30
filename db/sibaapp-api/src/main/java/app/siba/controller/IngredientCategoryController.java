package app.siba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import app.siba.model.IngredientCategory;
import app.siba.service.IngredientCategoryService;
import app.siba.vo.IngredientCategoryJson;

@RestController
@RequestMapping(value="ingredientCategory")
public class IngredientCategoryController {
	
	@Autowired
	private IngredientCategoryService ingredientCategoryService;
	
	
	@RequestMapping(value = {"/list"}, 
	method = RequestMethod.GET, 
	produces = { "application/json;charset=utf-8" })
	@ResponseBody
	public List<IngredientCategory> getIngredientCategory() {
		//IngredientCategoryJson ingredientCategory = new IngredientCategoryJson();
		//ingredientCategory.setList(ingredientCategoryService.getIngredientCategory());
		//ingredientCategory.setTotalCnt(ingredientCategoryService.getTotalCount());
		return ingredientCategoryService.getIngredientCategory();
	}
	
	@GetMapping("/totalCount")
	@ResponseBody
	public long getTotalCount() {
		return ingredientCategoryService.getTotalCount();
	}
	
}
