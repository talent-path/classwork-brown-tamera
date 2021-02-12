package com.tp.bakery.persistence.mappers;

import com.tp.bakery.model.Dessert;
import com.tp.bakery.model.Menu;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MenuMapper implements RowMapper<Menu> {
    @Override
    public Menu mapRow(ResultSet resultSet, int i) throws SQLException {
        Menu mappedMenu = new Menu();
        mappedMenu.setMenuId(resultSet.getInt("menuId") );
        mappedMenu.setMenuName(resultSet.getString( "menuName") );

        return mappedMenu;
    }
}
