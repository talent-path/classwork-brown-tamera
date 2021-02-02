package com.tp.librarymanagementsystem.service;

import com.tp.librarymanagementsystem.exceptions.*;
import com.tp.librarymanagementsystem.model.Book;
import com.tp.librarymanagementsystem.persistence.LibraryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService {
    @Autowired
    LibraryDAO dao;

    public List<Book> getAllBooks() {
        return dao.getAllBooks();
    }

    public Book getBookById(Integer bookId) throws  NullBookIdException,InvalidBookIdException {
        return dao.getBookById(bookId);
    }

    public List<Book> getBooksByTitle(String title) throws NullTitleException, InvalidTitleException{
        return dao.getBooksByTitle(title);
    }

    public List<Book> getBooksByAuthor(String author) throws NullAuthorException {
        return dao.getBooksByAuthor(author);
    }

    public List<Book> getBooksByYear(Integer year) throws InvalidYearException,NullYearException {
        return dao.getBooksByYear(year);
    }

    public void editBook(Integer bookId, Book NewBook) throws InvalidBookIdException, NullBookIdException {
        dao.editBook(bookId,NewBook);
    }

    public void DeleteBook(Integer bookId) throws InvalidBookIdException {
        dao.DeleteBook(bookId);
    }

    public Book addBook(Book book) throws InvalidAuthorException, NullTitleException, InvalidYearException, NullYearException, InvalidTitleException, NullAuthorException {
        return dao.addBook(book);
    }
}
