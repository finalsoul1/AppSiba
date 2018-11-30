package app.siba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.siba.mapper.IngredientListMapper;
import app.siba.model.IngredientList;
import app.siba.model.IngredientListExample;

@Service
public class IngredientListService {

	@Autowired
	private IngredientListMapper mapper;
	
	public List<IngredientList> getList() {
		IngredientListExample example = new IngredientListExample();
		return mapper.selectByExample(example);
	}
	
	public long getTotalCount() {
		IngredientListExample example = new IngredientListExample();
		return mapper.countByExample(example);
	}
}
