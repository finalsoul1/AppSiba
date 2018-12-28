package com.example.demo.service;


import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;


import com.example.demo.ObjectToJson;
import com.example.demo.Row;
import com.example.demo.model.FoodType;
import com.example.demo.vo.Food;
import com.example.demo.vo.Ingredient;
import com.example.demo.vo.Recipe;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class FoodServiceTest {

	@Autowired
	private FoodService foodService;
	
	@Autowired
	private FoodIngredientsService ingredientsService;
	
	@Autowired
	private FoodRecipeService recipeService;
	
	@Autowired
	private FoodTypeService foodTypeService;
	
	
	
	//@Transactional
	//@Test
	public void testInsertFood() throws JSONException, IOException {
		ObjectToJson objectToJson = new ObjectToJson();
		List<Row> rows = objectToJson.getJsonData();
		List<Food> list = objectToJson.getFoodList(rows);
		
		System.out.println(list.size());
		
		for(int i=0; i< list.size(); i++) {
			com.example.demo.model.Food food = new com.example.demo.model.Food();
			food.setName(list.get(i).getName()); // 음식 명 
			food.setFoodTypeId(list.get(i).getFoodTypeId());
			food.setCalorie(list.get(i).getCalorie());
			food.setCarbohydrate(list.get(i).getCarbohydrate());
			food.setProtein(list.get(i).getProtein());
			food.setFat(list.get(i).getFat());
			food.setNatrium(list.get(i).getNatrium());
		//	food.setHashTag(list.get(i).getHashTag());
			food.setSmallImageLocation(list.get(i).getSmallImageLocation()); // 이미지 소
			food.setBigImageLocation(list.get(i).getBigImageLocation()); // 이미지 대
			food.setIngredients(list.get(i).getIngredients());
		//	food.setLikeIt(list.get(i).getLikeIt());
			
			int foodId = foodService.insertFood(food);
			System.out.println("key값::: "+foodId);
			
			// Ingredient
			List<Ingredient> in_list = list.get(i).getIngredientList();
			for(int j=0; j < in_list.size(); j++) {
				com.example.demo.model.FoodIngredients ingredients = new com.example.demo.model.FoodIngredients();
				ingredients.setFoodId(foodId);
				ingredients.setName(in_list.get(j).getName());
				ingredientsService.insertIncredients(ingredients); // Ingredient insert
			}
			
			
			// Recipe
			List<Recipe> recipeList = list.get(i).getRecipes();
			for(int j=0; j < recipeList.size(); j++) {
				com.example.demo.model.FoodRecipe recipe = new com.example.demo.model.FoodRecipe();
				recipe.setFoodId(foodId);
				recipe.setImageLocation(recipeList.get(j).getImageLocation());
				recipe.setRecipeDesc(recipeList.get(j).getDesc());
				recipe.setOrd(recipeList.get(j).getOrd());
				recipeService.insertRecipe(recipe); // recipe insert 
				
			}
		}
		
	}
	
	@Test
	public void testParsing() throws JSONException, IOException {
		ObjectToJson objectToJson = new ObjectToJson();
		List<Row> rows = objectToJson.getJsonData();
		List<Food> list = objectToJson.getFoodList(rows);
		
		for(int i=0; i< list.size(); i++) {
			com.example.demo.model.Food food = new com.example.demo.model.Food();
			food.setName(list.get(i).getName()); // 음식 명 
			//food.setCookingTypeId(list.get(i).getCookingTypeId()); // 
			food.setFoodTypeId(list.get(i).getFoodTypeId());
			food.setCalorie(list.get(i).getCalorie());
			food.setCarbohydrate(list.get(i).getCarbohydrate());
			food.setProtein(list.get(i).getProtein());
			food.setFat(list.get(i).getFat());
			food.setNatrium(list.get(i).getNatrium());
			//food.setHashTag(list.get(i).getHashTag());
			food.setSmallImageLocation(list.get(i).getSmallImageLocation()); // 이미지 소
			food.setBigImageLocation(list.get(i).getBigImageLocation()); // 이미지 대
			food.setIngredients(list.get(i).getIngredients());
		//	food.setLikeIt(list.get(i).getLikeIt());
			
			
			// Ingredient
			List<Ingredient> in_list = list.get(i).getIngredientList();
			for(int j=0; j < in_list.size(); j++) {
				com.example.demo.model.FoodIngredients ingredients = new com.example.demo.model.FoodIngredients();
				ingredients.setName(in_list.get(j).getName());
				
			}
			
			
			// Recipe
			List<Recipe> recipeList = list.get(i).getRecipes();
			for(int j=0; j < recipeList.size(); j++) {
				com.example.demo.model.FoodRecipe recipe = new com.example.demo.model.FoodRecipe();
				recipe.setImageLocation(recipeList.get(j).getImageLocation());
				recipe.setRecipeDesc(recipeList.get(j).getDesc());
				recipe.setOrd(recipeList.get(j).getOrd());
			}
			
		}
		
	}

}
