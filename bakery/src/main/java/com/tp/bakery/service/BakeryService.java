package com.tp.bakery.service;

import com.tp.bakery.execptions.NullDessertIdException;
import com.tp.bakery.execptions.NullDessertObjectException;
import com.tp.bakery.execptions.NulllDessertNameException;
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

    public Dessert addDessert(Dessert dessert) throws NullDessertObjectException, NulllDessertNameException {
        return dao.addDessert(dessert);

    }

    public Dessert getDessertById(Integer dessertId) {
        return dao.getDessertById(dessertId);
    }


    public int editDessert(Integer dessertId, Dessert dessert) {
        return dao.editDessert(dessertId,dessert);
    }

    public int deleteDessert(Integer dessertId) throws NullDessertIdException {
        return dao.deleteDessert(dessertId);
    }
}
