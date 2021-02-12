package com.tp.bakery.model;

import java.util.List;

public class Menu {
    Integer menuId;
    String menuName;
    List<Dessert> allDessert;

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public List<Dessert> getAllDessert() {
        return allDessert;
    }

    public void setAllDessert(List<Dessert> allDessert) {
        this.allDessert = allDessert;
    }
}
