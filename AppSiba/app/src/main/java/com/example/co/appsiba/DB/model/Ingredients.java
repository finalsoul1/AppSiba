package com.example.co.appsiba.db.model;

public class Ingredients {

    private Long foodId;
    private String name;

    public Ingredients() {
    }

    public Ingredients(Long foodId, String name) {
        this.foodId = foodId;
        this.name = name;
    }

    public Long getFoodId() {
        return foodId;
    }

    public void setFoodId(Long foodId) {
        this.foodId = foodId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
