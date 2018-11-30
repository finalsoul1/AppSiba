package app.siba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import app.siba.model.FoodType;
import app.siba.service.FoodTypeService;
import app.siba.vo.FoodTypeJson;

@RestController
@RequestMapping(value="foodType")
public class FoodTypeController {

	@Autowired
	private FoodTypeService foodTypeService;
	
	@RequestMapping(value = {"/list"}, 
	method = RequestMethod.GET, 
	produces = { "application/json;charset=utf-8" })
	@ResponseBody
	public List<FoodType> getFoodTypeList() {
		//FoodTypeJson foodType = new FoodTypeJson();
		//foodType.setList(foodTypeService.getFoodTypeList());
		//foodType.setTotalCnt(foodTypeService.getTotalCount());
		return foodTypeService.getFoodTypeList();
	}
	
	@GetMapping("/totalCount")
	@ResponseBody
	public long getTotalCount() {
		return foodTypeService.getTotalCount();
	}
	
}
