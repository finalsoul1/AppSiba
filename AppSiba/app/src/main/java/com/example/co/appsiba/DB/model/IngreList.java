package com.example.co.appsiba.db.model;

public class IngreList {

    private Long id;
    private Long ingredientSubCategoryId;
    private String name;
    private String fileName;

    public IngreList() {
    }

    public IngreList(Long id, Long ingredientSubCategoryId, String name, String fileName) {
        this.id = id;
        this.ingredientSubCategoryId = ingredientSubCategoryId;
        this.name = name;
        this.fileName = fileName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIngredientSubCategoryId() {
        return ingredientSubCategoryId;
    }

    public void setIngredientSubCategoryId(Long ingredientSubCategoryId) {
        this.ingredientSubCategoryId = ingredientSubCategoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
