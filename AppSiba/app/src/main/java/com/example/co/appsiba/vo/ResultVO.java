package com.example.co.appsiba.vo;

public class ResultVO {
    private int id;
    private  String name;

    public ResultVO() {
    }

    private String  imagelink;

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

    public String getImagelink() {
        return imagelink;
    }

    public void setImagelink(String imagelink) {
        this.imagelink = imagelink;
    }

    public ResultVO(int id, String name, String imagelink) {

        this.id = id;
        this.name = name;
        this.imagelink = imagelink;
    }

    @Override
    public String toString() {
        return "ResultVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", imagelink='" + imagelink + '\'' +
                '}';
    }
}
