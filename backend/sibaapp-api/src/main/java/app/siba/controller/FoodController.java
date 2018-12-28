package app.siba.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import app.siba.model.Food;
import app.siba.service.FoodService;
import app.siba.vo.FoodJson;

@RestController
@RequestMapping(value ="food")
public class FoodController {

	@Autowired
	private FoodService foodService;
	
	@RequestMapping(value = {"/list"}, 
	method = RequestMethod.GET, 
	produces = { "application/json;charset=utf-8" })
	@ResponseBody
	public List<Food> getList() {
		return foodService.getList();
	}
	
	@GetMapping("/totalCount")
	@ResponseBody
	public long getTotalCount() {
		return foodService.getTotalCount();
	}
	
}
