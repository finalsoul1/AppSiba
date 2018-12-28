package app.siba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import app.siba.model.FoodIngredients;
import app.siba.service.FoodIngredientsService;
import app.siba.vo.FoodIngredientsJson;

import java.util.List;


@RestController
@RequestMapping("ingredients")
public class FoodIngredientsController {

	@Autowired
	private FoodIngredientsService foodIngredientsService;
	
	@RequestMapping(value = {"/list"}, 
	method = RequestMethod.GET, 
	produces = { "application/json;charset=utf-8" })
	@ResponseBody
	public List<FoodIngredients> getList() {
		//FoodIngredientsJson foodIngredients = new FoodIngredientsJson();
		//foodIngredients.setTotalCnt(foodIngredientsService.getTotalCount());
		//foodIngredients.setList(foodIngredientsService.getList());
		//foodIngredientsService.getTotalCount();
		return foodIngredientsService.getList();
	}
	
	@GetMapping("/totalCount")
	public long getTotalCount() {
		return foodIngredientsService.getTotalCount();
	}
}
