package com.tp.bakery.persistence;

import com.tp.bakery.model.Dessert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PostgresBakeryDAO implements BakeryDAO{
    @Autowired
    JdbcTemplate template;

    @Override
    public List<Dessert> getAllDesserts() {
        List<Dessert> allDesserts=template.query("Select \"dessertId\",\"dessertName\" from \"Desserts\";",new BakeryMapper());
        return allDesserts;
    }

    @Override
    public Dessert addDessert(Dessert dessert) {
        return null;
    }
    class BakeryMapper implements RowMapper<Dessert> {

        @Override
        public Dessert mapRow(ResultSet resultSet, int i) throws SQLException {
            Dessert mappedDessert = new Dessert();
            mappedDessert.setDessertId( resultSet.getInt("dessertId") );
            mappedDessert.setName( resultSet.getString( "dessertName") );

            return mappedDessert;
        }
    }
}

