package com.tp.bakery.service;

import com.tp.bakery.execptions.*;
import com.tp.bakery.model.Dessert;
import com.tp.bakery.persistence.DessertDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DessertService {
    @Autowired
    DessertDAO dao;

    public List<Dessert> getAllDesserts() {
        return dao.getAllDesserts();
    }

    public Dessert addDessert(Dessert dessert) throws NullDessertObjectException, NulllDessertNameException, NullDessertDescriptionException {
        return dao.addDessert(dessert);

    }

    public Dessert getDessertById(Integer dessertId) throws NullDessertIdException, InvaildDessertIdException {
        return dao.getDessertById(dessertId);
    }


    public int editDessert(Integer dessertId, Dessert dessert) throws NullDessertIdException, NullDessertObjectException,NulllDessertNameException, NullDessertDescriptionException {
        return dao.editDessert(dessertId,dessert);
    }

    public int deleteDessert(Integer dessertId) throws NullDessertIdException {
        return dao.deleteDessert(dessertId);
    }

    public void addDessertToMenu() {
        dao.addDessertToMenu();
    }
}
