package com.tp.bakery.model;

import java.util.List;

public class Order {
    String name;
    String email;
    List<Dessert> BagItems;
    Double totalPrice;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Dessert> getBagItems() {
        return BagItems;
    }

    public void setBagItems(List<Dessert> bagItems) {
        BagItems = bagItems;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
