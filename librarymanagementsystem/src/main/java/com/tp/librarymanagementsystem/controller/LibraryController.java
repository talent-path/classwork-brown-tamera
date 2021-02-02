package com.tp.librarymanagementsystem.controller;

import com.tp.librarymanagementsystem.exceptions.*;
import com.tp.librarymanagementsystem.model.Book;
import com.tp.librarymanagementsystem.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LibraryController {

    @Autowired
    LibraryService service;

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return service.getAllBooks();
    }

    @GetMapping("/books/{bookId}")
    public Book getBookById(@PathVariable Integer bookId) throws NullBookIdException, InvalidBookIdException {
        return service.getBookById(bookId);

    }

    @GetMapping("/books/title/{Title}")
    public List<Book> getBooksByTitle(@PathVariable String Title) throws NullTitleException, InvalidTitleException {
        return service.getBooksByTitle(Title);
    }

    @GetMapping("/books/author/{Author}")
    public List<Book> getBooksByAuthor(@PathVariable String Author) throws NullAuthorException {
        return service.getBooksByAuthor(Author);
    }

    @GetMapping("books/year/{Year}")
    public List<Book> getBooksByYear(@PathVariable int Year) throws InvalidYearException,NullYearException {
        return service.getBooksByYear(Year);
    }

    @PostMapping("/books/add")
    public ResponseEntity addBook(@RequestBody Book book) throws InvalidAuthorException, NullTitleException, InvalidYearException, NullYearException, InvalidTitleException, NullAuthorException {
        Book finishedBook= service.addBook(book);
       return ResponseEntity.ok(finishedBook);

    }

    @PutMapping("/books/update/{bookId}")
    public void editBook(@PathVariable Integer bookId, @RequestBody Book request) throws InvalidBookIdException, NullBookIdException {

        service.editBook(bookId, request);
    }


    @DeleteMapping("/books/delete/{bookId}")
    public String DeleteBook(@PathVariable Integer bookId) {
        try {
            service.DeleteBook(bookId);
            return "Book " + bookId + " successfully deleted.";
        } catch (InvalidBookIdException e) {
            return e.getMessage();
        }


    }
}
