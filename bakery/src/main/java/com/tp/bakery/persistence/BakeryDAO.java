package com.tp.bakery.persistence;

import com.tp.bakery.execptions.NullDessertObjectException;
import com.tp.bakery.execptions.NulllDessertNameException;
import com.tp.bakery.model.Dessert;

import java.util.List;

public interface BakeryDAO {
    List<Dessert> getAllDesserts();

    Dessert addDessert(Dessert dessert) throws NullDessertObjectException, NulllDessertNameException;

    Dessert getDessertById(Integer dessertId);

    int editDessert(Integer dessertId, Dessert editDessert);

    int deleteDessert(Integer dessertId);
}
