package com.example.co.appsiba.db.model;

public class Ingredients {

    private int foodId;
    private String name;

    public Ingredients() {
    }

    public Ingredients(int foodId, String name) {
        this.foodId = foodId;
        this.name = name;
    }

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
