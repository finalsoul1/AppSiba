package com.example.co.appsiba.db.model;

public class Ingredients {

    private int id;
    private int foodId;
    private String name;

    public Ingredients() {
    }

    public Ingredients(int id, int foodId, String name) {
        this.id = id;
        this.foodId = foodId;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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