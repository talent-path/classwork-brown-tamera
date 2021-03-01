package com.tp.librarymanagementsystem.controller;

import com.tp.librarymanagementsystem.exceptions.*;
import com.tp.librarymanagementsystem.model.Book;
import com.tp.librarymanagementsystem.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity getBookById(@PathVariable Integer bookId){
        Book retreivedBook;
        try {
            retreivedBook = service.getBookById(bookId);
        } catch (NullBookIdException | InvalidBookIdException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        return ResponseEntity.ok(retreivedBook);


    }

    @GetMapping("/books/title/{Title}")
    public ResponseEntity getBooksByTitle(@PathVariable String Title)  {
        List<Book> books;
        try {
            books = service.getBooksByTitle(Title);
        } catch (NullTitleException | InvalidTitleException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        return ResponseEntity.ok(books);

    }

    @GetMapping("/books/author/{Author}")
    public ResponseEntity getBooksByAuthor(@PathVariable String Author){
        List<Book> books;
        try {
            books = service.getBooksByAuthor(Author);
        } catch (NullAuthorException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        return ResponseEntity.ok(books);

    }

    @GetMapping("books/year/{Year}")
    public ResponseEntity getBooksByYear(@PathVariable int Year) {
        List<Book> books;
        try {
            books = service.getBooksByYear(Year);
        } catch (InvalidYearException | NullYearException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        return ResponseEntity.ok(books);

    }

    @PostMapping("/books/add")
    public ResponseEntity addBook(@RequestBody Book book) {
        Book finishedBook;
        try {
            finishedBook = service.addBook(book);

        } catch (InvalidAuthorException | NullTitleException | InvalidYearException | NullYearException | InvalidTitleException | NullAuthorException | NullBookObjectException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        return ResponseEntity.ok(finishedBook);

    }

    @PutMapping("/books/update/{bookId}")
    public String editBook(@PathVariable Integer bookId, @RequestBody Book request) {

        try {
            service.editBook(bookId, request);
        } catch (InvalidBookIdException | NullBookIdException | NullAuthorException | NullYearException | NullTitleException e) {
            return "Cannot update book with id " + bookId;
        }
          return "Book with id " + bookId + "edited";
    }


    @DeleteMapping("/books/delete/{bookId}")
    public String DeleteBook(@PathVariable Integer bookId) {
        try {
            service.DeleteBook(bookId);
            return "Book " + bookId + " successfully deleted.";
        } catch (InvalidBookIdException | NullBookIdException e) {
            return e.getMessage();
        }


    }
}
