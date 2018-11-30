package app.siba.service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class FoodRecipeServiceTest {

	@Autowired
	private FoodRecipeService foodRecipeService;
	
	//@Test
	public void testGetFoodRecipeList() {
		foodRecipeService.getFoodRecipeList().forEach(recipe -> System.out.println(recipe.getRecipeDesc()));
	}
	
	@Test
	public void testGetTotalCount() {
		System.out.println("총 개수 : "+foodRecipeService.getTotalCount());
	}

}
