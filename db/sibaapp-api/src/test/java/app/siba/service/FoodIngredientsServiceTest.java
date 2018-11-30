package app.siba.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import app.siba.model.IngredientList;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class FoodIngredientsServiceTest {
	
	@Autowired
	private IngredientListService isscService;
	
	@Autowired
	private FoodIngredientsService foodIngredientsService;
	

	@Test
	public void testGetList() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTotalCount() {
		fail("Not yet implemented");
	}

	@Test
	public void testSearchNameCount() {
		
		List<IngredientList> list = isscService.getList();
		
		for(IngredientList issc : list) {
			long cnt = foodIngredientsService.searchNameCount(issc.getName());
			System.out.println(issc.getName() +" : "+ cnt);
		}
	}

}
