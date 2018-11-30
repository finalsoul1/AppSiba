package com.example.co.appsiba.vo;

public class RecipeVO {

    private int id;
    private  String name;
    private String  small_image_location;

    public RecipeVO() {
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

    public String getSmall_image_location() {
        return small_image_location;
    }

    public void setSmall_image_location(String small_image_location) {
        this.small_image_location = small_image_location;
    }

    public RecipeVO(int id, String name, String small_image_location) {
        this.id = id;
        this.name = name;
        this.small_image_location = small_image_location;
    }

    @Override
    public String toString() {
        return "RecipeVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", small_image_location='" + small_image_location + '\'' +
                '}';
    }
}
