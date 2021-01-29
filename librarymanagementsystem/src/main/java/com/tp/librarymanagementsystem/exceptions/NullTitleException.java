package com.tp.librarymanagementsystem.exceptions;

public class NullTitleException extends Exception {

    public NullTitleException( String message) {
        super( message );
    }

    public NullTitleException( String message, Throwable innerException  ){
        super( message, innerException );
    }
}
