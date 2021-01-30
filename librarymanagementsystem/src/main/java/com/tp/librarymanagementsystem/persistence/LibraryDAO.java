package com.tp.librarymanagementsystem.persistence;

import com.tp.librarymanagementsystem.exceptions.*;
import com.tp.librarymanagementsystem.model.LibraryBook;

import java.util.Date;
import java.util.List;

public interface LibraryDAO {
    List<LibraryBook> getAllBooks();
    LibraryBook getBookById(Integer bookId) throws NullBookIdException, InvalidBookIdException;

    List<LibraryBook> getBookByTitle(String Title) throws NullTitleException;

     List<LibraryBook> getBookByAuthor(String Author) throws NullAuthorException;

     List<LibraryBook> getBookByYear(int Year) throws InvalidYearException;

     LibraryBook UpdateBook(Integer bookId,LibraryBook NewBook) throws InvalidBookIdException, NullBookIdException;

     void DeleteBook(Integer bookId) throws InvalidBookIdException;


    LibraryBook addBook(LibraryBook book) throws InvalidAuthorException, InvalidYearException, NullYearException, NullTitleException;
}
