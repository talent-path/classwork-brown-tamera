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
    public ResponseEntity getAllBooks() {
        List<Book> books=service.getAllBooks();
        return ResponseEntity.ok(books);

    }

    @GetMapping("/books/{bookId}")
    public ResponseEntity getBookById(@PathVariable Integer bookId) throws NullBookIdException, InvalidBookIdException {
        Book retreivedBook=service.getBookById(bookId);
        return ResponseEntity.ok(retreivedBook);


    }

    @GetMapping("/books/title/{Title}")
    public ResponseEntity getBooksByTitle(@PathVariable String Title) throws NullTitleException, InvalidTitleException {
        List<Book> books=service.getBooksByTitle(Title);
        return ResponseEntity.ok(books);

    }

    @GetMapping("/books/author/{Author}")
    public ResponseEntity getBooksByAuthor(@PathVariable String Author) throws NullAuthorException {
        List<Book> books=service.getBooksByAuthor(Author);
        return ResponseEntity.ok(books);

    }

    @GetMapping("books/year/{Year}")
    public ResponseEntity getBooksByYear(@PathVariable int Year) throws InvalidYearException,NullYearException {
        List<Book> books=service.getBooksByYear(Year);
        return ResponseEntity.ok(books);

    }

    @PostMapping("/books/add")
    public ResponseEntity addBook(@RequestBody Book book) throws InvalidAuthorException, NullTitleException, InvalidYearException, NullYearException, InvalidTitleException, NullAuthorException {
        Book finishedBook= service.addBook(book);
       return ResponseEntity.ok(finishedBook);

    }

    @PutMapping("/books/update/{bookId}")
    public String editBook(@PathVariable Integer bookId, @RequestBody Book request) throws InvalidBookIdException, NullBookIdException {

        service.editBook(bookId, request);
        return "Book " + bookId + "successfully edited";
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
