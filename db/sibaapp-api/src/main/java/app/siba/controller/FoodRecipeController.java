package app.siba.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import app.siba.model.FoodRecipe;
import app.siba.service.FoodRecipeService;
import app.siba.vo.FoodRecipeJson;

@RestController
@RequestMapping(value="recipe")
public class FoodRecipeController {

	@Autowired
	private FoodRecipeService foodRecipeService;
	
	@RequestMapping(value = {"/list"}, 
	method = RequestMethod.GET, 
	produces = { "application/json;charset=utf-8" })
	@ResponseBody
	public List<FoodRecipe> getFoodRecipeList() {
		return foodRecipeService.getFoodRecipeList();
	}
	
	
	@GetMapping("/totalCount")
	@ResponseBody
	public long getTotalCount() {
		return foodRecipeService.getTotalCount();
	}
}
