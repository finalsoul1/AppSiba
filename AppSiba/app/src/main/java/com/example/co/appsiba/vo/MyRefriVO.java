package com.example.co.appsiba.vo;

public class MyRefriVO {

    private int ingredientListId;
    private String name;
    private String fileName;

    public MyRefriVO() {
    }

    public MyRefriVO(int ingredientListId, String name, String fileName) {
        this.ingredientListId = ingredientListId;
        this.name = name;
        this.fileName = fileName;
    }

    public int getIngredientListId() {
        return ingredientListId;
    }

    public void setIngredientListId(int ingredientListId) {
        this.ingredientListId = ingredientListId;
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
