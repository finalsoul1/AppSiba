package com.example.co.appsiba.refrigerator.model;

public class FoodIngredients {

    private String foodName;
    private String foodType;

    public FoodIngredients(String foodName, String foodType) {

        this.foodName = foodName;
        this.foodType = foodType;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }
}
