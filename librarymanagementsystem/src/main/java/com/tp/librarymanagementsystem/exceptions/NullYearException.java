package com.tp.librarymanagementsystem.exceptions;

public class NullYearException extends Exception{
    public NullYearException( String message) {
        super( message );
    }

    public NullYearException( String message, Throwable innerException  ){
        super( message, innerException );
    }
}
