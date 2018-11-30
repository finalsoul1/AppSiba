package app.siba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.siba.mapper.FoodTypeMapper;
import app.siba.model.FoodType;
import app.siba.model.FoodTypeExample;

@Service
public class FoodTypeService {
	
	@Autowired
	private FoodTypeMapper foodTypeMapper;

	// FoodType 전체 리스트 
	public List<FoodType> getFoodTypeList() {
		FoodTypeExample example = new FoodTypeExample();
		return foodTypeMapper.selectByExample(example);
	}
	
	public long getTotalCount() {
		FoodTypeExample example = new FoodTypeExample();
		return foodTypeMapper.countByExample(example);
	}
}
