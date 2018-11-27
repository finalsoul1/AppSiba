package com.example.co.appsiba.db.model;

public class IngreList {

    private int id;
    private int ingredientSubCategoryId;
    private String name;
    private String fileName;

    public IngreList() {
    }

    public IngreList(int id, int ingredientSubCategoryId, String name, String fileName) {
        this.id = id;
        this.ingredientSubCategoryId = ingredientSubCategoryId;
        this.name = name;
        this.fileName = fileName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIngredientSubCategoryId() {
        return ingredientSubCategoryId;
    }

    public void setIngredientSubCategoryId(int ingredientSubCategoryId) {
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
