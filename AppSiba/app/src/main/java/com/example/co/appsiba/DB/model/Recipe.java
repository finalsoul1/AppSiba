package com.example.co.appsiba.db.model;

public class Recipe {

    private Long foodId;
    private String recipeDesc;
    private String imageLocation;

    public Recipe() {
    }

    public Recipe(Long foodId, String recipeDesc, String imageLocation) {
        this.foodId = foodId;
        this.recipeDesc = recipeDesc;
        this.imageLocation = imageLocation;
    }

    public Long getFoodId() {
        return foodId;
    }

    public void setFoodId(Long foodId) {
        this.foodId = foodId;
    }

    public String getRecipeDesc() {
        return recipeDesc;
    }

    public void setRecipeDesc(String recipeDesc) {
        this.recipeDesc = recipeDesc;
    }

    public String getImageLocation() {
        return imageLocation;
    }

    public void setImageLocation(String imageLocation) {
        this.imageLocation = imageLocation;
    }
}
