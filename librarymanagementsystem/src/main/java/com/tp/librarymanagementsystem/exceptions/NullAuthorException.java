package com.tp.librarymanagementsystem.exceptions;

public class NullAuthorException extends Exception{
    public NullAuthorException( String message) {
        super( message );
    }

    public NullAuthorException( String message, Throwable innerException  ){
        super( message, innerException );
    }
}
