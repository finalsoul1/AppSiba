package com.example.co.appsiba.db.model;

public class Recipe {

    private int id;
    private int foodId;
    private String recipeDesc;
    private String imageLocation;
    private int ord;

    public Recipe() {
    }

    public Recipe(int id, int foodId, String recipeDesc, String imageLocation, int ord) {
        this.id = id;
        this.foodId = foodId;
        this.recipeDesc = recipeDesc;
        this.imageLocation = imageLocation;
        this.ord = ord;
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

    public String getRecipeDesc() {
        return recipeDesc;
    }

    public void setRecipeDesc(String recipeDesc) {
        this.recipeDesc = recipeDesc;
    }

    public String getImageLocation() {
        return imageLocation;
    }

    public void setImageLocation(String imageLocation) {
        this.imageLocation = imageLocation;
    }

    public int getOrd() {
        return ord;
    }

    public void setOrd(int ord) {
        this.ord = ord;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "foodId=" + foodId +
                ", recipeDesc='" + recipeDesc + '\'' +
                ", imageLocation='" + imageLocation + '\'' +
                ", ord=" + ord +
                '}';
    }
}