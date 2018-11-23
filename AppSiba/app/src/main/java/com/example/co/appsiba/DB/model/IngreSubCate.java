package com.example.co.appsiba.db.model;

public class IngreSubCate {

    private Long id;
    private Long ingredientCategoryId;
    private String name;

    public IngreSubCate() {
    }

    public IngreSubCate(Long id, Long ingredientCategoryId, String name) {
        this.id = id;
        this.ingredientCategoryId = ingredientCategoryId;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIngredientCategoryId() {
        return ingredientCategoryId;
    }

    public void setIngredientCategoryId(Long ingredientCategoryId) {
        this.ingredientCategoryId = ingredientCategoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
