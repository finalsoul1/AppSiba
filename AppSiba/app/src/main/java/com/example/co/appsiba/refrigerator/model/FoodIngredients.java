package com.example.co.appsiba.refrigerator.model;

public class FoodIngredients {

    private String foodName;

    public FoodIngredients(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }
}
