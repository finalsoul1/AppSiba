package com.example.co.appsiba.db.model;

public class FoodType {

    private Long id;
    private String name;

    public FoodType() {
    }

    public FoodType(Long id, Long ingredientCategoryId, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
