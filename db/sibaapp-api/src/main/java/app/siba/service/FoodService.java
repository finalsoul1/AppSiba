package app.siba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.siba.mapper.FoodMapper;
import app.siba.model.Food;
import app.siba.model.FoodExample;

@Service
public class FoodService {

	@Autowired
	private FoodMapper foodMapper;
	
	public List<Food> getList() {
		FoodExample example = new FoodExample();
		example.setOrderByClause("id");
		return foodMapper.selectByExample(example);
	}
	
	public long getTotalCount() {
		FoodExample example = new FoodExample();
		return foodMapper.countByExample(example);
	}
}
