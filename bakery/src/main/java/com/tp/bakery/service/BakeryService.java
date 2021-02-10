package com.tp.bakery.service;

import com.tp.bakery.model.Dessert;
import com.tp.bakery.persistence.BakeryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BakeryService {
    @Autowired
    BakeryDAO dao;

    public List<Dessert> getAllDesserts() {
        return dao.getAllDesserts();
    }

    public Dessert addDessert(Dessert dessert) {
        return dao.addDessert(dessert);

    }

    public Dessert getDessertById(Integer dessertId) {
        return dao.getDessertById(dessertId);
    }


    public Dessert editDessert(Integer dessertId, Dessert dessert) {
        return dao.editDessert(dessert,dessert);
    }

    public Dessert deleteDessert(Integer dessertId) {
        return dao.deleteDessert(dessertId);
    }
}
