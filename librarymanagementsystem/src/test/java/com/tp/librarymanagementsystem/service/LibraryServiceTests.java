package com.tp.librarymanagementsystem.service;

import com.tp.librarymanagementsystem.exceptions.*;
import com.tp.librarymanagementsystem.model.LibraryBook;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

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
        } catch (InvalidBookIdException | InvalidYearException | InvalidAuthorException | NullTitleException | NullYearException | InvalidTitleException | NullAuthorException e) {
            fail();
        }
    }
    @Test
    public void getBookByYearInvalidTest() {
        try {
            List<LibraryBook> test = toTest.getBookByYear(-1);
            fail();
        } catch (InvalidYearException | NullYearException e) {
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
    public void addBookEmptyTitleTest() {
        try {
            List<String> authors = new ArrayList<>();
            authors.add("Jim");
            LibraryBook book = new LibraryBook(1, "", authors, 1997);
            toTest.addBook(book);
        } catch (InvalidAuthorException | NullTitleException | InvalidYearException | NullYearException e) {
            fail();

        } catch (InvalidTitleException e) {
            //do nothing
        } catch (NullAuthorException e) {
            e.printStackTrace();
        }

    }
    @Test
    public void addBookEmptyAuthorTest(){
        try {
            List<String> authors = new ArrayList<>();
            authors.add("");
            authors.add("");
            authors.add("");
            LibraryBook book = new LibraryBook(1, "Hunger Games", authors, 1997);
            toTest.addBook(book);
        } catch (InvalidAuthorException | NullTitleException | InvalidYearException | NullYearException e) {
            fail();

        } catch (InvalidTitleException e) {
            //do nothing
        } catch (NullAuthorException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void addBookYearTooBigTest() {
        try {
            List<String> authors = new ArrayList<>();
            authors.add("Octavia Butler");
            LibraryBook newBook = new LibraryBook(0, "Fledgling", authors,3000) ;
            toTest.addBook(newBook);
            System.out.println(toTest.getAllBooks().get(1).getYear());



        } catch (InvalidAuthorException | NullTitleException | NullYearException | InvalidTitleException | NullAuthorException e) {
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

        } catch (InvalidAuthorException | NullTitleException | NullYearException | InvalidTitleException | NullAuthorException e) {
            fail();

        } catch (InvalidYearException e) {
            //do nothing
        }

    }
    @Test
    public void addBookInvalidIdTest() {
        try {
            List<String> authors = new ArrayList<>();
            authors.add("Jane");
            LibraryBook book = new LibraryBook(-999, "Second Book", authors, 2004);
            toTest.addBook(book);
        } catch (InvalidAuthorException | NullTitleException | NullYearException | InvalidTitleException | NullAuthorException e) {
            e.printStackTrace();

        } catch (InvalidYearException e) {
            //do nothing
        }

    }

    @Test
    public void upadateBookYearTooBigTest() {
        try {
            List<String> authors = new ArrayList<>();
            authors.add("Author 1");
            authors.add("Author 2");

            LibraryBook UpdatedBook = new LibraryBook(0, "Becoming", authors, 2021);
            toTest.addBook(UpdatedBook);
            UpdatedBook.setYear(2078);
            toTest.UpdateBook(9, UpdatedBook);

            assertEquals(2078,UpdatedBook.getYear());

        } catch (InvalidAuthorException | NullTitleException | NullYearException | NullBookIdException | InvalidBookIdException | InvalidTitleException | NullAuthorException e) {
            fail();

        } catch (InvalidYearException e) {
            //do nothing


        }
    }

    @Test
    public void updateBookYearTooSmallTest() {
        try {
            List<String> authors = new ArrayList<>();
            authors.add("Mike");
            List<String> updateauthors=new ArrayList<>();
            updateauthors.add("");
            LibraryBook UpdatedBook = new LibraryBook(0, "Fledgling", authors, Integer.MIN_VALUE);
            toTest.addBook(UpdatedBook);
            UpdatedBook.setAuthor(updateauthors);
            toTest.UpdateBook(4,UpdatedBook);

        } catch (InvalidAuthorException | NullTitleException | NullYearException | NullBookIdException | InvalidBookIdException | InvalidTitleException | NullAuthorException e) {
            fail();

        } catch (InvalidYearException e) {
            //do nothing
        }
        try {
            List<String> authors = new ArrayList<>();
            authors.add("Octavia Butler");
            LibraryBook UpdatedBook = new LibraryBook(0, "Fledgling", authors, -1);
            toTest.addBook(UpdatedBook);
            UpdatedBook.setYear(1990);
            toTest.UpdateBook(3,UpdatedBook);

        } catch (InvalidAuthorException | NullTitleException | NullYearException | NullBookIdException | InvalidBookIdException | InvalidTitleException | NullAuthorException e) {
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

        } catch (InvalidAuthorException | NullTitleException | NullYearException | NullBookIdException | InvalidBookIdException | InvalidTitleException | NullAuthorException e) {
            fail();

        } catch (InvalidYearException e) {
            //do nothing
        }
    }

    @Test
    public void updateBookEmptyTitleTest(){
        try {
            List<String> authors = new ArrayList<>();
            authors.add("Mike");

            LibraryBook UpdatedBook = new LibraryBook(0, "That's So Raven", authors, 2020);
            toTest.addBook(UpdatedBook);
            UpdatedBook.setTitle("");
            toTest.UpdateBook(5, UpdatedBook);


            assertEquals("", toTest.getAllBooks().get(0).getTitle());

        } catch (InvalidAuthorException | NullTitleException | NullYearException | NullBookIdException | InvalidBookIdException | InvalidYearException | NullAuthorException e) {
            fail();


        }catch (InvalidTitleException e){
            //do nothing
        }
    }
    @Test
    public void updateBookInvalidIdTest() {
        try {
            List<String> authors = new ArrayList<>();
            authors.add("Mike");

            LibraryBook UpdatedBook = new LibraryBook(0, "Fledgling", authors, 2020);
            toTest.addBook(UpdatedBook);
            UpdatedBook.setBookId(-1);
            toTest.UpdateBook(0, UpdatedBook);

        } catch (InvalidAuthorException | NullTitleException | NullYearException | NullBookIdException | InvalidBookIdException | InvalidTitleException | NullAuthorException e) {
            fail();

        } catch (InvalidYearException e) {
            //do nothing

        }
    }
}

