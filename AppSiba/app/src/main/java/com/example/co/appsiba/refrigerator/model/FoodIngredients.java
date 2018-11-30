package com.example.co.appsiba.refrigerator.model;

public class FoodIngredients {

    private String foodName;
    private String foodType;
    private int foodType2;

    public FoodIngredients(String foodName, String foodType) {

        this.foodName = foodName;
        this.foodType = foodType;
    }

    public FoodIngredients(String foodName, String foodType, int foodType2) {
        this.foodName = foodName;
        this.foodType = foodType;
        this.foodType2 = foodType2;
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

    public int getFoodType2() {
        return foodType2;
    }

    public void setFoodType2(int foodType2) {
        this.foodType2 = foodType2;
    }
}
