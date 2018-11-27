package com.example.co.appsiba.vo;

public class RefriIngredientVO {

    private int cateId;
    private int Id;
    private String name;
    private String fileName;

    public RefriIngredientVO() {
    }

    public RefriIngredientVO(int cateId, int id, String name, String fileName) {
        this.cateId = cateId;
        Id = id;
        this.name = name;
        this.fileName = fileName;
    }

    public int getCateId() {
        return cateId;
    }

    public void setCateId(int cateId) {
        this.cateId = cateId;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
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
