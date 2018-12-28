package com.example.co.appsiba.vo;

public class FavoritesVO {

    private  int recipeId;
    private  String recipeName;
    private  String recipefileImage;

    public FavoritesVO() {
    }

    public FavoritesVO(int recipeId, String recipeName, String recipefileImage) {
        this.recipeId = recipeId;
        this.recipeName = recipeName;
        this.recipefileImage = recipefileImage;
    }

    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getRecipefileImage() {
        return recipefileImage;
    }

    public void setRecipefileImage(String recipefileImage) {
        this.recipefileImage = recipefileImage;
    }
}
