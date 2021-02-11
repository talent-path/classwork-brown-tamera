package com.tp.bakery.persistence;


import com.tp.bakery.model.Dessert;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Profile("ServiceTesting")
public class BakeryInMemDAO implements BakeryDAO{

    @Override
    public List<Dessert> getAllDesserts() {
        return null;
    }

    @Override
    public Dessert addDessert(Dessert dessert) {
        return null;
    }

    @Override
    public Dessert getDessertById(Integer dessertId) {
        return null;
    }

    @Override
    public int editDessert(Integer dessertId, Dessert editDessert) {
        return 0;
    }

    @Override
    public int deleteDessert(Integer dessertId) {
        return 0;
    }

    @Override
    public void addDessertToMenu() {

    }
}
