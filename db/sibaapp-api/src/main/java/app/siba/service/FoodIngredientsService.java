package app.siba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.siba.mapper.FoodIngredientsMapper;
import app.siba.model.FoodIngredients;
import app.siba.model.FoodIngredientsExample;
import app.siba.model.FoodIngredientsExample.Criteria;

import java.util.List;


@Service
public class FoodIngredientsService {

	@Autowired
	private FoodIngredientsMapper foodIngredientsMapper;
	
	
	public List<FoodIngredients> getList() {
		FoodIngredientsExample example = new FoodIngredientsExample();
		example.setOrderByClause("food_id");
		//example.createCriteria().
		return foodIngredientsMapper.selectByExample(example);
	}
	
	public long getTotalCount() {
		FoodIngredientsExample example = new FoodIngredientsExample();
		return foodIngredientsMapper.countByExample(example);
	}
	
	
	public long searchNameCount(String name) {
		FoodIngredientsExample example = new FoodIngredientsExample();

		//example.createCriteria().andNameLike(name.trim());
		example.createCriteria().andNameNotLike(name.trim());
	
		return foodIngredientsMapper.countByExample(example);
	}
}
