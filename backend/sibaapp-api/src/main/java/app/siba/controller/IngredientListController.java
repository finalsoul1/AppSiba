package app.siba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import app.siba.model.IngredientList;
import app.siba.service.IngredientListService;

@RestController
@RequestMapping(value="ingredientList")
public class IngredientListController {

	@Autowired
	private IngredientListService ingredientListService;
	
	
	@RequestMapping(value = {"/list"}, 
	method = RequestMethod.GET, 
	produces = { "application/json;charset=utf-8" })
	@ResponseBody
	public List<IngredientList> getList() {
		//IngredientSubSubCategoryJson ingredientSubSubCategory = new IngredientSubSubCategoryJson();
		//ingredientSubSubCategory.setTotalCnt(ingredientSubSubCategoryService.getTotalCount());
		//ingredientSubSubCategory.setList(ingredientSubSubCategoryService.getList());
		return ingredientListService.getList();
	}
	
	@GetMapping("/totalCount")
	@ResponseBody
	public long getTotalCount() {
		return ingredientListService.getTotalCount();
	}
	
}
