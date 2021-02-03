package com.tp.librarymanagementsystem.service;

import com.tp.librarymanagementsystem.exceptions.*;
import com.tp.librarymanagementsystem.model.Book;
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
            List<Book> allBooks = toTest.getAllBooks();
            for (int i = 0; i < allBooks.size(); i++) {

                toTest.DeleteBook(i);
            }

//            List<String> Authors = new ArrayList<>();
//            Authors.add("Obama");
//            Book test = new Book(0, "A Promised Land", Authors, 2020);
//            toTest.addBook(test);
        } catch (InvalidBookIdException e) {

        }
    }
    @Test
    public void getBookByYearInvalidTest() {

        assertThrows(InvalidYearException.class,()->toTest.getBooksByYear(-1));
        //assertThrows(NullYearException.class,()->toTest.getBooksByYear(-1));

    }

    @Test
    public void getBookByIdToHighTest() {
        try {
            Book test = toTest.getBookById(Integer.MAX_VALUE);

        } catch (NullBookIdException e) {
            fail();
        } catch (InvalidBookIdException e) {
            //do nothing
        }
    }

    @Test
    public void getBookByIdToLowTest() {
        try {
            Book test = toTest.getBookById(Integer.MIN_VALUE);

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
            Book book = new Book(1, "", authors, 1997);
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
            Book book = new Book(1, "Hunger Games", authors, 1997);
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
    public void addBookYearToLowTest() {
        try {
            List<String> authors = new ArrayList<>();
            authors.add("Octavia Butler");
            Book newBook = new Book(0, "Fledgling", authors,1800) ;
            toTest.addBook(newBook);
            System.out.println(toTest.getAllBooks().get(1).getYear());



        } catch (InvalidAuthorException | NullTitleException | NullYearException | InvalidTitleException | NullAuthorException e) {
            fail();

        } catch (InvalidYearException e) {
            //do nothing
        }

    }

    @Test
    public void addBookYearToHighTest() {
        try {
            List<String> authors = new ArrayList<>();
            authors.add("Octavia Butler");
            Book newBook = new Book(0, "Fledgling", authors, 2078);
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
            Book book = new Book(-999, "Second Book", authors, 2004);
            toTest.addBook(book);
        } catch (InvalidAuthorException | NullTitleException | NullYearException | InvalidTitleException | NullAuthorException e) {
            e.printStackTrace();

        } catch (InvalidYearException e) {
            //do nothing
        }

    }

//    @Test
//    public void editBookYearToHighTest() {
//        try {
//            List<String> authors = new ArrayList<>();
//            authors.add("Author 1");
//            authors.add("Author 2");
//
//            Book UpdatedBook = new Book(0, "Becoming", authors, 2021);
//            toTest.addBook(UpdatedBook);
//            UpdatedBook.setYear(2078);
//            toTest.editBook(9, UpdatedBook);
//
//            assertEquals(2078,UpdatedBook.getYear());
//
//        } catch (InvalidAuthorException | NullTitleException | NullYearException | NullBookIdException | InvalidBookIdException | InvalidTitleException | NullAuthorException e) {
//            fail();
//
//        } catch (InvalidYearException e) {
//            //do nothing
//
//
//        }
//    }
//
//    @Test
//    public void editBookYearToLowTest() {
//        try {
//            List<String> authors = new ArrayList<>();
//            authors.add("Mike");
//            List<String> updateauthors=new ArrayList<>();
//            updateauthors.add("");
//            Book UpdatedBook = new Book(0, "Fledgling", authors, Integer.MIN_VALUE);
//            toTest.addBook(UpdatedBook);
//            UpdatedBook.setAuthor(updateauthors);
//            toTest.editBook(4,UpdatedBook);
//
//        } catch (InvalidAuthorException | NullTitleException | NullYearException | NullBookIdException | InvalidBookIdException | InvalidTitleException | NullAuthorException e) {
//            fail();
//
//        } catch (InvalidYearException e) {
//            //do nothing
//        }
//        try {
//            List<String> authors = new ArrayList<>();
//            authors.add("Octavia Butler");
//            Book UpdatedBook = new Book(0, "Fledgling", authors, -1);
//            toTest.addBook(UpdatedBook);
//            UpdatedBook.setYear(1990);
//            toTest.editBook(3,UpdatedBook);
//
//        } catch (InvalidAuthorException | NullTitleException | NullYearException | NullBookIdException | InvalidBookIdException | InvalidTitleException | NullAuthorException e) {
//            fail();
//
//        } catch (InvalidYearException e) {
//            //do nothing
//        }
//
//    }
//    @Test
//    public void editBookInvaildAuthorsTest(){
//         try {
//            List<String> authors = new ArrayList<>();
//            authors.add("Mike");
//            List<String> updateauthors=new ArrayList<>();
//            updateauthors.add("");
//            Book UpdatedBook = new Book(0, "Fledgling", authors, 2020);
//            toTest.addBook(UpdatedBook);
//            UpdatedBook.setAuthor(updateauthors);
//            toTest.editBook(0 ,UpdatedBook);
//
//        } catch (InvalidAuthorException | NullTitleException | NullYearException | NullBookIdException | InvalidBookIdException | InvalidTitleException | NullAuthorException e) {
//            fail();
//
//        } catch (InvalidYearException e) {
//            //do nothing
//        }
//    }
//
//    @Test
//    public void editBookEmptyTitleTest(){
//        try {
//            List<String> authors = new ArrayList<>();
//            authors.add("Mike");
//
//            Book UpdatedBook = new Book(0, "That's So Raven", authors, 2020);
//            toTest.addBook(UpdatedBook);
//            UpdatedBook.setTitle("");
//            toTest.editBook(5, UpdatedBook);
//
//
//            assertEquals("", toTest.getAllBooks().get(0).getTitle());
//
//        } catch (InvalidAuthorException | NullTitleException | NullYearException | NullBookIdException | InvalidBookIdException | InvalidYearException | NullAuthorException e) {
//            fail();
//
//
//        }catch (InvalidTitleException e){
//            //do nothing
//        }
//    }
//    @Test
//    public void editBookInvalidIdTest() {
//        try {
//            List<String> authors = new ArrayList<>();
//            authors.add("Mike");
//
//            Book UpdatedBook = new Book(0, "Fledgling", authors, 2020);
//            toTest.addBook(UpdatedBook);
//            UpdatedBook.setBookId(-1);
//            toTest.editBook(0, UpdatedBook);
//
//        } catch (InvalidAuthorException | NullTitleException | NullYearException | NullBookIdException | InvalidBookIdException | InvalidTitleException | NullAuthorException e) {
//            fail();
//
//        } catch (InvalidYearException e) {
//            //do nothing
//
//        }
//    }
}

