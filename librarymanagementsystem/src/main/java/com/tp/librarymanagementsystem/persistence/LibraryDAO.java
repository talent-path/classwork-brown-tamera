package com.tp.librarymanagementsystem.persistence;

import com.tp.librarymanagementsystem.exceptions.*;
import com.tp.librarymanagementsystem.model.Book;

import java.util.List;

public interface LibraryDAO {

    List<Book> getAllBooks();
    Book getBookById(Integer bookId) throws NullBookIdException, InvalidBookIdException;

    List<Book> getBooksByTitle(String Title) throws NullTitleException, InvalidTitleException;

     List<Book> getBooksByAuthor(String Author) throws NullAuthorException;

     List<Book> getBooksByYear(Integer Year) throws InvalidYearException,NullYearException;

     Book editBook(Integer bookId, Book NewBook) throws InvalidBookIdException, NullBookIdException, NullAuthorException, NullYearException, NullTitleException;

     void DeleteBook(Integer bookId) throws InvalidBookIdException, NullBookIdException;


    Book addBook(Book book) throws InvalidAuthorException, InvalidYearException,
            NullYearException, NullTitleException,InvalidTitleException,NullAuthorException,NullBookObjectException;
}
