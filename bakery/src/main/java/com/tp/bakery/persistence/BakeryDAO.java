package com.tp.bakery.persistence;

import com.tp.bakery.model.Dessert;

import java.util.List;

public interface BakeryDAO {
    List<Dessert> getAllDesserts();

    Dessert addDessert(Dessert dessert);

    Dessert getDessertById(Integer dessertId);

    Dessert editDessert(Dessert dessert, Dessert dessert1);

    Dessert deleteDessert(Integer dessertId);
}
