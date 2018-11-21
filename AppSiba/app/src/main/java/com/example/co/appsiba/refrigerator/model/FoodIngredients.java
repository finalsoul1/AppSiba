package com.example.co.appsiba.refrigerator.model;

public class FoodIngredients {

    private String foodName;
    private int foodType;

    public FoodIngredients(String foodName, int foodType) {

        this.foodName = foodName;
        this.foodType = foodType;
    }

    public int getFoodType() {
        return foodType;
    }

    public void setFoodType(int foodType) {
        this.foodType = foodType;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }
}
