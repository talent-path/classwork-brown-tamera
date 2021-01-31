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
            LibraryBook test2= new LibraryBook(1,"Becoming",Authors,2019);
            toTest.addBook(test2);
        } catch (InvalidBookIdException | InvalidYearException | InvalidAuthorException | NullTitleException | InvalidTitleException | NullYearException | NullAuthorException e) {
            fail();
        }
    }

    @Test
    public void getBookGoldenPathTest() {
        try {
            LibraryBook test = toTest.getBookById(0);
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

            LibraryBook test = new LibraryBook(1, "Punching the Air", authors, 2020);
            toTest.addBook(test);

            assertEquals("Punching the Air", toTest.getAllBooks().get(3).getTitle());
        } catch (InvalidAuthorException | InvalidYearException | NullTitleException | InvalidTitleException | NullYearException | NullAuthorException e) {
            fail();

        }


    }
    @Test
    public void addBookNullTitleTest(){
        try {
            List<String> authors = new ArrayList<>();
            authors.add("Me");
            authors.add("John");
            authors.add("Shannon");
            LibraryBook book = new LibraryBook(0, null, authors, 1997);
            toTest.addBook(book);
        } catch (InvalidAuthorException | InvalidTitleException | InvalidYearException | NullYearException | NullAuthorException e) {
            fail();

        } catch (NullTitleException e) {
            //do nothing
        }
    }
    @Test
    public void addBookNullAuthorsTest() {
        try {
            LibraryBook book = new LibraryBook(0, "First Book", null, 2021);
            toTest.addBook(book);

        } catch (NullTitleException | InvalidYearException | NullYearException | InvalidTitleException e) {
            fail();
        } catch (NullAuthorException | InvalidAuthorException |NullPointerException e) {
            //do nothing
        }
    }
    @Test
    public void addBookNullYearTest(){
        List<String> authors=new ArrayList<>();
        authors.add("Tyler Perry");
        authors.add("Tamera");
        try {
            LibraryBook book = new LibraryBook(0, "First Book", authors, null);
            toTest.addBook(book);

        } catch (NullTitleException | InvalidYearException | NullAuthorException | InvalidTitleException | InvalidAuthorException e) {
            fail();
        } catch (NullYearException e) {
            //do nothing
        }
    }
    @Test
    public void DeleteBookGoldenPath() throws InvalidBookIdException {
        toTest.DeleteBook(1);
    }
    @Test
    public void getBookByIdNullTest() {
        try {
            LibraryBook test = toTest.getBookById(null);
            fail();
        } catch (NullBookIdException e) {

        } catch (InvalidBookIdException e) {
            //do nothing
        }

    }
    @Test
    public void getBookByTitleNullTest() {
        try {
            List<LibraryBook> test = toTest.getBookByTitle(null);
            fail();
        } catch (NullTitleException | InvalidTitleException e) {
            //do nothing
        }
    }
    @Test
    public void getBookByAuthorNullTest() {
        try {
            List<LibraryBook> test = toTest.getBookByAuthor(null);
            fail();
        } catch (NullAuthorException e) {
            //do nothing
        }
    }



}
