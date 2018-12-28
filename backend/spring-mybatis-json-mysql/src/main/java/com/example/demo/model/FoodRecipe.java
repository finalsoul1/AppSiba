package com.example.demo.model;

public class FoodRecipe {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column food_recipe.food_id
	 * @mbg.generated  Mon Nov 26 10:30:33 KST 2018
	 */
	private Integer foodId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column food_recipe.recipe_desc
	 * @mbg.generated  Mon Nov 26 10:30:33 KST 2018
	 */
	private String recipeDesc;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column food_recipe.image_location
	 * @mbg.generated  Mon Nov 26 10:30:33 KST 2018
	 */
	private String imageLocation;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column food_recipe.ord
	 * @mbg.generated  Mon Nov 26 10:30:33 KST 2018
	 */
	private Integer ord;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column food_recipe.food_id
	 * @return  the value of food_recipe.food_id
	 * @mbg.generated  Mon Nov 26 10:30:33 KST 2018
	 */
	public Integer getFoodId() {
		return foodId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column food_recipe.food_id
	 * @param foodId  the value for food_recipe.food_id
	 * @mbg.generated  Mon Nov 26 10:30:33 KST 2018
	 */
	public void setFoodId(Integer foodId) {
		this.foodId = foodId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column food_recipe.recipe_desc
	 * @return  the value of food_recipe.recipe_desc
	 * @mbg.generated  Mon Nov 26 10:30:33 KST 2018
	 */
	public String getRecipeDesc() {
		return recipeDesc;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column food_recipe.recipe_desc
	 * @param recipeDesc  the value for food_recipe.recipe_desc
	 * @mbg.generated  Mon Nov 26 10:30:33 KST 2018
	 */
	public void setRecipeDesc(String recipeDesc) {
		this.recipeDesc = recipeDesc;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column food_recipe.image_location
	 * @return  the value of food_recipe.image_location
	 * @mbg.generated  Mon Nov 26 10:30:33 KST 2018
	 */
	public String getImageLocation() {
		return imageLocation;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column food_recipe.image_location
	 * @param imageLocation  the value for food_recipe.image_location
	 * @mbg.generated  Mon Nov 26 10:30:33 KST 2018
	 */
	public void setImageLocation(String imageLocation) {
		this.imageLocation = imageLocation;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column food_recipe.ord
	 * @return  the value of food_recipe.ord
	 * @mbg.generated  Mon Nov 26 10:30:33 KST 2018
	 */
	public Integer getOrd() {
		return ord;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column food_recipe.ord
	 * @param ord  the value for food_recipe.ord
	 * @mbg.generated  Mon Nov 26 10:30:33 KST 2018
	 */
	public void setOrd(Integer ord) {
		this.ord = ord;
	}
}