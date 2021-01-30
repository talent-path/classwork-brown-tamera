package com.tp.librarymanagementsystem.service;
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
public class LibraryServiceTests {
    @Autowired
    LibraryService toTest;

    @BeforeEach
    public void setUp() throws InvalidBookIdException {
        try {
            List<LibraryBook> allBooks = toTest.getAllBooks();
            for (LibraryBook toRemove : allBooks) {
                toTest.DeleteBook(toRemove.getBookId());
            }
            List<String> Authors = new ArrayList<>();
            Authors.add("Obama");
            LibraryBook test = new LibraryBook(0, "A Promised Land", Authors, 2020);
            toTest.addBook(test);
        } catch (InvalidBookIdException | InvalidYearException | InvalidAuthorException | NullTitleException | NullYearException e) {
            fail();
        }
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
        } catch (NullTitleException e) {
            //do nothing
        }
    }

    @Test
    public void getBookByAuthorNull() {
        try {
            List<LibraryBook> test = toTest.getBookByAuthor(null);
            fail();
        } catch (NullAuthorException e) {
            //do nothing
        }
    }

    @Test
    public void getBookByYearInvalidTest() {
        try {
            List<LibraryBook> test = toTest.getBookByYear(0);
            fail();
        } catch (InvalidYearException e) {
            //do nothing
        }
    }

    @Test
    public void getBookByIdTooBigTest() {
        try {
            LibraryBook test = toTest.getBookById(Integer.MAX_VALUE);

        } catch (NullBookIdException e) {
            fail();
        } catch (InvalidBookIdException e) {
            //do nothing
        }
    }

    @Test
    public void getBookByIdTooSmallTest() {
        try {
            LibraryBook test = toTest.getBookById(Integer.MIN_VALUE);

        } catch (NullBookIdException e) {
            fail();
        } catch (InvalidBookIdException e) {
            //do nothing
        }
    }

    @Test
    public void addBookYearTooBigTest() {
        try {
            List<String> authors = new ArrayList<>();
            authors.add("Octavia Butler");
            LibraryBook newBook = new LibraryBook(0, "Fledgling", authors, Integer.MAX_VALUE);
            toTest.addBook(newBook);

        } catch (InvalidAuthorException | NullTitleException | NullYearException e) {
            fail();

        } catch (InvalidYearException e) {
            //do nothing
        }

    }

    @Test
    public void addBookYearTooSmallTest() {
        try {
            List<String> authors = new ArrayList<>();
            authors.add("Octavia Butler");
            LibraryBook newBook = new LibraryBook(0, "Fledgling", authors, Integer.MIN_VALUE);
            toTest.addBook(newBook);

        } catch (InvalidAuthorException | NullTitleException | NullYearException e) {
            fail();

        } catch (InvalidYearException e) {
            //do nothing
        }

    }

    @Test
    public void addBookInvaildAuthorsTest() {
        try {
            List<String> authors = new ArrayList<>();

            LibraryBook book = new LibraryBook(0, "First Book", authors, 2021);
            toTest.addBook(book);

        } catch (NullTitleException | InvalidYearException | NullYearException e) {
            fail();
        } catch (InvalidAuthorException e) {
            //do nothing
        }
    }

    @Test
    public void addBookInvaildTitleTest() {
        try {
            List<String> authors = new ArrayList<>();
            authors.add("Me");
            authors.add("John");
            authors.add("Shannon");
            LibraryBook book = new LibraryBook(1, "", authors, 1997);
            toTest.addBook(book);
        } catch (InvalidAuthorException | NullTitleException | InvalidYearException e) {
            fail();

        } catch (NullYearException e) {
            //do nothing
        }

    }

    @Test
    public void addBookInvalidId() {
        try {
            List<String> authors = new ArrayList<>();
            authors.add("Jane");
            LibraryBook book = new LibraryBook(-999, "Second Book", authors, 2004);
            toTest.addBook(book);
        } catch (InvalidAuthorException | NullTitleException | NullYearException e) {
            e.printStackTrace();

        } catch (InvalidYearException e) {
            //do nothing
        }

    }

    @Test
    public void upadateBookYearTooBig() {
        try {
            List<String> authors = new ArrayList<>();
            authors.add("Author 1");
            authors.add("Author 2");

            LibraryBook UpdatedBook = new LibraryBook(0, "Becoming", authors, 2021);
            toTest.addBook(UpdatedBook);
            UpdatedBook.setYear(2025);
            toTest.UpdateBook(0, UpdatedBook);

        } catch (InvalidAuthorException | NullTitleException | NullYearException | NullBookIdException | InvalidBookIdException e) {
            fail();

        } catch (InvalidYearException e) {
            //do nothing


        }
    }

    @Test
    public void updateBookYearTooSmallTest() {
        try {
            List<String> authors = new ArrayList<>();
            authors.add("Octavia Butler");
            LibraryBook UpdatedBook = new LibraryBook(0, "Fledgling", authors, Integer.MIN_VALUE);
            toTest.addBook(UpdatedBook);
            UpdatedBook.setYear(1990);
            toTest.UpdateBook(0,UpdatedBook);

        } catch (InvalidAuthorException | NullTitleException | NullYearException | NullBookIdException | InvalidBookIdException e) {
            fail();

        } catch (InvalidYearException e) {
            //do nothing
        }

    }
    @Test
    public void updateBookInvaildAuthorsTest(){
         try {
            List<String> authors = new ArrayList<>();
            authors.add("Mike");
            List<String> updateauthors=new ArrayList<>();
            updateauthors.add("");
            LibraryBook UpdatedBook = new LibraryBook(0, "Fledgling", authors, 2020);
            toTest.addBook(UpdatedBook);
            UpdatedBook.setAuthor(updateauthors);
            toTest.UpdateBook(0 ,UpdatedBook);

        } catch (InvalidAuthorException | NullTitleException | NullYearException | NullBookIdException | InvalidBookIdException e) {
            fail();

        } catch (InvalidYearException e) {
            //do nothing
        }
    }

    @Test
    public void updateBookInvaildTitleTest(){
        try {
            List<String> authors = new ArrayList<>();
            authors.add("Mike");

            LibraryBook UpdatedBook = new LibraryBook(0, "Fledgling", authors, 2020);
            toTest.addBook(UpdatedBook);
            UpdatedBook.setTitle("");
            toTest.UpdateBook(0 ,UpdatedBook);

        } catch (InvalidAuthorException | NullTitleException | NullYearException | NullBookIdException | InvalidBookIdException e) {
            fail();

        } catch (InvalidYearException e) {
            //do nothing
        }
    }
    @Test
    public void updateBookInvalidId(){
        try {
            List<String> authors = new ArrayList<>();
            authors.add("Mike");

            LibraryBook UpdatedBook = new LibraryBook(0, "Fledgling", authors, 2020);
            toTest.addBook(UpdatedBook);
            UpdatedBook.setBookId(-1);
            toTest.UpdateBook(0 ,UpdatedBook);

        } catch (InvalidAuthorException | NullTitleException | NullYearException | NullBookIdException | InvalidBookIdException e) {
            fail();

        } catch (InvalidYearException e) {
            //do nothing
        }
    }
}

