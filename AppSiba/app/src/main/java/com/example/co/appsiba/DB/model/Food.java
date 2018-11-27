package com.example.co.appsiba.db.model;

public class Food {

    private int id;
    private String name;
    private int foodTypeId;
    private Float calorie;
    private Float carbohydrate;
    private Float protein;
    private Float fat;
    private Float natrium;
    private String smallImageLocation;
    private String bigImageLocation;
    private String ingredients;

    public Food() {
    }

    public Food(int id, String name, int foodTypeId, Float calorie, Float carbohydrate, Float protein, Float fat, Float natrium, String smallImageLocation, String bigImageLocation, String ingredients) {
        this.id = id;
        this.name = name;
        this.foodTypeId = foodTypeId;
        this.calorie = calorie;
        this.carbohydrate = carbohydrate;
        this.protein = protein;
        this.fat = fat;
        this.natrium = natrium;
        this.smallImageLocation = smallImageLocation;
        this.bigImageLocation = bigImageLocation;
        this.ingredients = ingredients;
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

    public int getFoodTypeId() {
        return foodTypeId;
    }

    public void setFoodTypeId(int foodTypeId) {
        this.foodTypeId = foodTypeId;
    }

    public Float getCalorie() {
        return calorie;
    }

    public void setCalorie(Float calorie) {
        this.calorie = calorie;
    }

    public Float getCarbohydrate() {
        return carbohydrate;
    }

    public void setCarbohydrate(Float carbohydrate) {
        this.carbohydrate = carbohydrate;
    }

    public Float getProtein() {
        return protein;
    }

    public void setProtein(Float protein) {
        this.protein = protein;
    }

    public Float getFat() {
        return fat;
    }

    public void setFat(Float fat) {
        this.fat = fat;
    }

    public Float getNatrium() {
        return natrium;
    }

    public void setNatrium(Float natrium) {
        this.natrium = natrium;
    }

    public String getSmallImageLocation() {
        return smallImageLocation;
    }

    public void setSmallImageLocation(String smallImageLocation) {
        this.smallImageLocation = smallImageLocation;
    }

    public String getBigImageLocation() {
        return bigImageLocation;
    }

    public void setBigImageLocation(String bigImageLocation) {
        this.bigImageLocation = bigImageLocation;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }
}

