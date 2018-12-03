package com.example.co.appsiba.recipe;

public class recipe_item {

    private  int recipe_image;
    private  String process;

    public int getRecipe_image() {
        return recipe_image;
    }

    public void setRecipe_image(int recipe_image) {
        this.recipe_image = recipe_image;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    public recipe_item(int recipe_image, String process) {
        this.recipe_image = recipe_image;
        this.process = process;
    }
}
