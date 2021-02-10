package com.tp.bakery.execptions;

public class NullDessertObject extends Exception {
    public NullDessertObject(String message){
        super(message);
    }
    public NullDessertObject(String message, Throwable innerexception){
        super(message,innerexception);
    }
}
