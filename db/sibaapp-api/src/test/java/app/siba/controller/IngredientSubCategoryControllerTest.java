package app.siba.controller;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import app.siba.service.IngredientSubCategoryService;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class IngredientSubCategoryControllerTest {

	@Autowired
	private IngredientSubCategoryService ingredientSubCategoryService;
	
	@Test
	public void testGetIngredientSubCategoryList() {
		ingredientSubCategoryService.getIngredientSubCategoryList().forEach(
								category -> System.out.println(category.getName()));
	}

}
