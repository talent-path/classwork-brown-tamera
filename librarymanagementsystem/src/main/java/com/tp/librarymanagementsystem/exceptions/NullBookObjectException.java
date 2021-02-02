package com.tp.librarymanagementsystem.exceptions;

public class NullBookObjectException extends Exception {
    public NullBookObjectException( String message) {
        super( message );
    }

    public NullBookObjectException( String message, Throwable innerException  ){
        super( message, innerException );
    }
}
