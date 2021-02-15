package com.tp.bakery.persistence;

import com.tp.bakery.model.Menu;
import com.tp.bakery.persistence.mappers.DessertMapper;
import com.tp.bakery.persistence.mappers.IntegerMapper;
import com.tp.bakery.persistence.mappers.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class PostgresMenuDAO implements MenuDAO {

    @Autowired
    private JdbcTemplate template;


    @Override
    public List<Menu> getAllMenus() {
        List<Menu> allMenus=template.query("select \"menuId\",\"menuName\" from \"Menus\";",new MenuMapper());
        return allMenus;
    }

    @Override
    public Menu addMenu(Menu newMenu) {
        Integer menuId=template.queryForObject("insert into \"Menus\"(\"menuName\")\n" +
                "values (?) returning \"menuId\";",new IntegerMapper("menuId"),newMenu.getMenuName());
        newMenu.setMenuId(menuId);
        return newMenu;
    }

    @Override
    public Menu viewMenuById(Integer menuId) {
        Menu retrieved=template.queryForObject("select \"Menus\".\"menuId\",\"menuName\",\"Desserts\".\"dessertId\",\"Desserts\".\"dessertName\",\"Desserts\".\"dessertDescription\", \"Desserts\".\"dessertPrice\" from \"DessertMenus\", \"Desserts\",\"Menus\"\n" +
                "where \"Menus\".\"menuId\"="+menuId+";",new MenuMapper());
        return retrieved;
    }
}
