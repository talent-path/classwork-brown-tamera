package com.tp.bakery.persistence;

import com.tp.bakery.model.Menu;

import java.util.List;

public interface MenuDAO {
    public List<Menu> getAllMenus();

    Menu addMenu(Menu newMenu);

    Menu viewMenuById(Integer menuId);
}
