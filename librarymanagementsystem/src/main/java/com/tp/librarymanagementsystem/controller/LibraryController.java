package com.tp.librarymanagementsystem.controller;

import com.tp.librarymanagementsystem.model.LibraryBook;
import com.tp.librarymanagementsystem.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
    public LibraryBook getBookById(@PathVariable bookId){
        return service.getBookById(bookId);

    }


}
