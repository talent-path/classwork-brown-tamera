package com.tp.librarymanagementsystem.service;

import com.tp.librarymanagementsystem.exceptions.*;
import com.tp.librarymanagementsystem.model.LibraryBook;
import com.tp.librarymanagementsystem.persistence.LibraryDAO;
import com.tp.librarymanagementsystem.persistence.LibraryInMemDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class LibraryService {
    @Autowired
    LibraryDAO dao;

    public List<LibraryBook> getAllBooks() {
        return dao.getAllBooks();
    }

    public LibraryBook getBookById(Integer bookId) throws  NullBookIdException,InvalidBookIdException {
        return dao.getBookById(bookId);
    }

    public List<LibraryBook> getBookByTitle(String title) throws NullTitleException {
        return dao.getBookByTitle(title);
    }

    public List<LibraryBook> getBookByAuthor(String author) throws NullAuthorException {
        return dao.getBookByAuthor(author);
    }

    public List<LibraryBook> getBookByYear(int year) throws InvalidYearException {
        return dao.getBookByYear(year);
    }

    public void UpdateBook(Integer bookId, LibraryBook NewBook) throws InvalidBookIdException, NullBookIdException {
        dao.UpdateBook(bookId,NewBook);
    }

    public void DeleteBook(Integer bookId) throws InvalidBookIdException {
        dao.DeleteBook(bookId);
    }

    public LibraryBook addBook(LibraryBook book) throws InvalidAuthorException, NullTitleException, InvalidYearException, NullYearException {
        return dao.addBook(book);
    }
}
