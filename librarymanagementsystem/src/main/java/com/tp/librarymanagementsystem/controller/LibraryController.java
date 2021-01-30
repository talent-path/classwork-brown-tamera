package com.tp.librarymanagementsystem.controller;

import com.tp.librarymanagementsystem.exceptions.*;
import com.tp.librarymanagementsystem.model.LibraryBook;
import com.tp.librarymanagementsystem.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class LibraryController {

    @Autowired
    LibraryService service;

    @GetMapping("/books")
    public List<LibraryBook> getAllBooks(){
        return service.getAllBooks();
    }
    @GetMapping("/books/{bookId}")
    public LibraryBook getBookById(@PathVariable Integer bookId) throws  NullBookIdException,InvalidBookIdException {
        return service.getBookById(bookId);

    }
    @GetMapping("/books/title/{Title}")
    public List<LibraryBook> getBookByTitle(@PathVariable String Title) throws NullTitleException {
        return service.getBookByTitle(Title);
    }
    @GetMapping("/books/author/{Author}")
    public List<LibraryBook> getBookByAuthor(@PathVariable String Author) throws NullAuthorException {
        return service.getBookByAuthor(Author);
    }

    @GetMapping("books/year/{Year}")
    public List<LibraryBook> getBookByYear(@PathVariable int Year) throws InvalidYearException {
        return service.getBookByYear(Year);
    }
    @PostMapping("/books/add")
    public LibraryBook addBook(@RequestBody LibraryBook book) throws InvalidAuthorException, NullTitleException, InvalidYearException, NullYearException {
        return service.addBook(book);
    }
    @PutMapping("/books/update/{bookId}")
        public void UpdateBook(@PathVariable Integer bookId,@RequestBody LibraryBook request ) throws InvalidBookIdException, NullBookIdException {
            service.UpdateBook(bookId,request);
        }


    @DeleteMapping("/books/delete/{bookId}")
    public void DeleteBook(@PathVariable Integer bookId) throws InvalidBookIdException {
        service.DeleteBook(bookId);
    }




}
