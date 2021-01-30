package com.tp.librarymanagementsystem.persistence;

import com.tp.librarymanagementsystem.exceptions.*;
import com.tp.librarymanagementsystem.model.LibraryBook;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class LibraryInMemDAOTests {
    @Autowired
    LibraryInMemDAO toTest;

    @BeforeEach
    public void setUp() {

        try {
            List<LibraryBook> allBooks = toTest.getAllBooks();
            for (LibraryBook toRemove : allBooks) {
                toTest.DeleteBook(toRemove.getBookId());
            }
            List<String> Authors = new ArrayList<>();
            Authors.add("Obama");
            LibraryBook test = new LibraryBook(0, "A Promised Land", Authors, 2020);
            toTest.addBook(test);
        } catch (InvalidBookIdException | InvalidYearException | InvalidAuthorException | NullTitleException e) {
            fail();
        }
    }

    @Test
    public void getBookGoldenPathTest() {
        try {
            LibraryBook test = toTest.getBookById(0);
            // System.out.println(test.getTitle());
            assertTrue(test.getTitle().equals("A Promised Land"));
            assertEquals(0, test.getBookId());
            assertEquals(2020, test.getYear());
            assertEquals(1, test.getAuthor().size());

        } catch (InvalidBookIdException | NullBookIdException e) {
            fail();
        }

    }

    @Test
    public void addBookGoldenPathTest() {
        try {
            List<String> authors = new ArrayList<>();
            authors.add("libi Zoboi");
            authors.add("Yusef Salaam");

            LibraryBook test = new LibraryBook(2, "Punching the Air", authors, 2020);
            toTest.addBook(test);
            assertEquals("Punching the Air", toTest.getBookById(2).getTitle());
        } catch (InvalidBookIdException | NullBookIdException | InvalidAuthorException | InvalidYearException | NullTitleException e) {
            fail();

        }


    }
}
