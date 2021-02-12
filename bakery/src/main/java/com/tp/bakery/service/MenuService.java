package com.tp.bakery.service;

import com.tp.bakery.model.Menu;
import com.tp.bakery.persistence.MenuDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {
    @Autowired
    MenuDAO dao;
    public List<Menu> getAllMenus() {
        return dao.getAllMenus();
    }

    public Menu addMenu(Menu newMenu) {
        return dao.addMenu(newMenu);
    }
}
