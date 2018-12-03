package com.example.co.appsiba.db.model;

public class IngreSubCate {

    private int id;
    private int ingredientCategoryId;
    private String name;

    public IngreSubCate() {
    }

    public IngreSubCate(int id, int ingredientCategoryId, String name) {
        this.id = id;
        this.ingredientCategoryId = ingredientCategoryId;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIngredientCategoryId() {
        return ingredientCategoryId;
    }

    public void setIngredientCategoryId(int ingredientCategoryId) {
        this.ingredientCategoryId = ingredientCategoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
