package app.siba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import app.siba.model.IngredientSubCategory;
import app.siba.service.IngredientSubCategoryService;
import app.siba.vo.IngredientSubCategoryJson;

@RestController
@RequestMapping(value="ingredientSubCategory")
public class IngredientSubCategoryController {

	@Autowired
	private IngredientSubCategoryService ingredientSubCategoryService;
	
	@RequestMapping(value = {"/list"}, 
	method = RequestMethod.GET, 
	produces = { "application/json;charset=utf-8" })
	@ResponseBody
	public List<IngredientSubCategory> getIngredientSubCategoryList() {
		//IngredientSubCategoryJson ingredientSubCategory = new IngredientSubCategoryJson();
		//ingredientSubCategory.setTotalCnt(ingredientSubCategoryService.getTotalCount());
		//ingredientSubCategory.setList(ingredientSubCategoryService.getIngredientSubCategoryList());
		return ingredientSubCategoryService.getIngredientSubCategoryList();
	}
	
	@GetMapping("/totalCount")
	@ResponseBody
	public long getTotalCount() {
		return ingredientSubCategoryService.getTotalCount();
	}
}
