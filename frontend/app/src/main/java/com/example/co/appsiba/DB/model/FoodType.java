package com.example.co.appsiba.db.model;

public class FoodType {

    private int id;
    private String name;

    public FoodType() {
    }

    public FoodType(int id, int ingredientCategoryId, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
