package com.tp.bakery.model;

public class Dessert {
    Integer dessertId;
    String name;
    String Description;

    public Dessert(){}

    public Dessert(Dessert that){
        this.dessertId=that.dessertId;
        this.name= that.name;
        this.Description= that.Description;
    }

    public Integer getDessertId() {
        return dessertId;
    }

    public void setDessertId(Integer dessertId) {
        this.dessertId = dessertId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }
}
