package app.siba.service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class IngredientCategoryServiceTest {

	@Autowired
	private IngredientCategoryService ingredientCategoryService;
	
	@Test
	public void testGetIngredientCategory() {
		ingredientCategoryService.getIngredientCategory().forEach(
									category -> System.out.println(category.getName()));
	}

}
