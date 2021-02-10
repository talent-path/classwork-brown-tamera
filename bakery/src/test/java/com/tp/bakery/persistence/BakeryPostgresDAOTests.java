package com.tp.bakery.persistence;

import com.tp.bakery.model.Dessert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class BakeryPostgresDAOTests {
    @Autowired
    PostgresBakeryDAO toTest;
    @Autowired
    JdbcTemplate template;

    @BeforeEach
    public void setUp(){
        template.update("truncate \"Menus\",\"Desserts\",\"Orders\",\"DessertMenus\",\"OrderDesserts\" restart identity;");
        template.update("insert into \"Desserts\" (\"dessertName\") values ('Pineapple Cake');");

    }

    @Test
   public void addDessertGoldenPathTest(){

        Dessert partialDessert =new Dessert();
        partialDessert.setName("Pound Cake");
        partialDessert.setDescription("Moist");

        Dessert returned=toTest.addDessert(partialDessert);

        assertEquals( 2, returned.getDessertId() );
        assertEquals( "Pound Cake", returned.getName() );
        assertEquals("Moist",returned.getDescription());






    }
}
