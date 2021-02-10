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
        List<Dessert> allDesserts=template.query("select \"dessertId\", \"dessertName\", \"dessertDescription\" from \"Desserts\";",new BakeryMapper());
        return allDesserts;
    }

    @Override
    public Dessert addDessert(Dessert dessert) {
        Integer dessertId=template.queryForObject("insert into \"Desserts\" (dessertId\", \"dessertName\", \"dessertDescription\")\n" +
                "values (?,?,?) returning \"dessertId\";",new BakeryIdMapper(),dessert.getName(),dessert.getDescription()) ;

        dessert.setDessertId(dessertId);

        return dessert;
    }

    @Override
    public Dessert getDessertById(Integer dessertId) {

        Dessert retreived=template.queryForObject("select \"dessertId\", \"dessertName\", \"dessertDescription\" from \"Desserts\" where \"dessertId\"='"+dessertId+"'",new BakeryMapper());

        return retreived;

    }


    class BakeryIdMapper implements RowMapper<Integer>{

        @Override
        public Integer mapRow(ResultSet resultSet, int i) throws SQLException {
            return resultSet.getInt("dessertId");


        }
    }
    class BakeryMapper implements RowMapper<Dessert> {

        @Override
        public Dessert mapRow(ResultSet resultSet, int i) throws SQLException {
            Dessert mappedDessert = new Dessert();
            mappedDessert.setDessertId( resultSet.getInt("dessertId") );
            mappedDessert.setName( resultSet.getString( "dessertName") );
            mappedDessert.setDescription(resultSet.getString("dessertDescription"));

            return mappedDessert;
        }
    }
}

