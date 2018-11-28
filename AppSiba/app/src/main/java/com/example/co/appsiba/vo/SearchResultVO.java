package com.example.co.appsiba.vo;

public class SearchResultVO {

    private int id;
    private String name;
    private String smallImageLocation;

    public SearchResultVO() {
    }

    public SearchResultVO(int id, String name, String smallImageLocation) {
        this.id = id;
        this.name = name;
        this.smallImageLocation = smallImageLocation;
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

    public String getSmallImageLocation() {
        return smallImageLocation;
    }

    public void setSmallImageLocation(String smallImageLocation) {
        this.smallImageLocation = smallImageLocation;
    }

    @Override
    public String toString() {
        return "SearchResultVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", smallImageLocation='" + smallImageLocation + '\'' +
                '}';
    }
}
