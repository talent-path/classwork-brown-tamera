package com.tp.bakery.model;

import java.util.List;

public class Menu {
    Integer menuId;
    String menuName;
    List<Dessert> DessertItems;

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

    public List<Dessert> getDessertItems() {
        return DessertItems;
    }

    public void setDessertItems(List<Dessert> dessertItems) {
        DessertItems = dessertItems;
    }
}
