package com.tp.librarymanagementsystem.service;
import com.tp.librarymanagementsystem.exceptions.InvalidBookIdException;
import com.tp.librarymanagementsystem.model.LibraryBook;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class LibraryServiceTests {
    @Autowired
    LibraryService toTest;

    @BeforeEach
    public void setUp() throws InvalidBookIdException {
        List<LibraryBook> allBooks = toTest.getAllBooks();
        for (LibraryBook toRemove : allBooks) {
            toTest.DeleteBook(toRemove.getBookId());
        }
    }

}
