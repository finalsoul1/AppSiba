package com.example.co.appsiba.db.model;

public class IngreCate {

    private Long id;
    private String name;

    public IngreCate() {
    }

    public IngreCate(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "IngreCate{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
