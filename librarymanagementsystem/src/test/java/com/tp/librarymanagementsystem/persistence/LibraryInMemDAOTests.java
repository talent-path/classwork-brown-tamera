package com.tp.librarymanagementsystem.persistence;

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
public class LibraryInMemDAOTests {
    @Autowired
    LibraryInMemDAO toTest;

    @BeforeEach
    public void setUp() throws InvalidBookIdException, NullBookIdException, NullTitleException, NullBookObjectException, InvalidTitleException, NullYearException, InvalidYearException, NullAuthorException, InvalidAuthorException {


        List<Book> allBooks = toTest.getAllBooks();
        for (int i = 1; i < allBooks.size(); i++) {

            toTest.DeleteBook(i);
        }


    }


    @Test
    public void addBookGoldenPathTest() {
        try {
            List<String> authors = new ArrayList<>();
            authors.add("libi Zoboi");
            authors.add("Yusef Salaam");

            Book test = new Book(1, "Punching the Air", authors, 2020);
            Book returned = toTest.addBook(test);
            Book validate = toTest.getBookById(1);

            assertEquals(1, returned.getBookId());
            assertEquals(2, returned.getAuthors().size());
            assertEquals("libi Zoboi", returned.getAuthors().get(0));
            assertEquals("Punching the Air", returned.getTitle());
            assertEquals(2020, returned.getYear());

            assertEquals(1, validate.getBookId());
            assertEquals(2, validate.getAuthors().size());
            assertEquals("libi Zoboi", validate.getAuthors().get(0));
            assertEquals("Punching the Air", validate.getTitle());
            assertEquals(2020, validate.getYear());

            List<String> secondAuthors = new ArrayList<>();
            secondAuthors.add("Barack Obama");
            Book test2 = new Book(2, "A Promised Land", secondAuthors, 2020);
            Book returned2 = toTest.addBook(test2);
            Book validate2 = toTest.getBookById(2);

            assertEquals(2, returned2.getBookId());
            assertEquals(1, returned2.getAuthors().size());
            assertEquals("Barack Obama", returned2.getAuthors().get(0));
            assertEquals("A Promised Land", returned2.getTitle());
            assertEquals(2020, returned2.getYear());

            assertEquals(2, validate2.getBookId());
            assertEquals(1, validate2.getAuthors().size());
            assertEquals("Barack Obama", validate2.getAuthors().get(0));
            assertEquals("A Promised Land", validate2.getTitle());
            assertEquals(2020, validate2.getYear());


        } catch (InvalidBookIdException | NullBookIdException | NullTitleException | InvalidTitleException | NullYearException | InvalidYearException | NullAuthorException | InvalidAuthorException | NullBookObjectException e) {
            fail();
        }
    }

    @Test
    public void addBookNullBookObjectTest() {

        assertThrows(NullBookObjectException.class, () -> toTest.addBook(null));
    }

    @Test
    public void addBookNullTitleTest() {
        List<String> authors = new ArrayList<>();
        authors.add("Author 1");
        authors.add("Author 2");
        assertThrows(NullTitleException.class, () -> toTest.addBook(new Book(3, null, authors, 2009)));
    }

    @Test
    public void addBookNullAuthorsTest() {
        assertThrows(NullAuthorException.class, () -> toTest.addBook(new Book(4, "To Kill A Mockingbird", null, 1960)));
    }

    @Test
    public void addBookNullYearTest() {
        List<String> authors = new ArrayList<>();
        authors.add("Mark Twain");
        assertThrows(NullYearException.class, () -> toTest.addBook(new Book(5, "The Adventures Huckleberry Finn", authors, null)));
    }

    @Test
    public void getBooksNullIdTest() {
        assertThrows(NullBookIdException.class, () -> toTest.getBookById(null));
    }

    @Test
    public void getBooksNullTitleTest() {
        assertThrows(NullTitleException.class, () -> toTest.getBooksByTitle(null));
    }

    @Test
    public void getBooksNullAuthorsTest() {
        assertThrows(NullAuthorException.class, () -> toTest.getBooksByAuthor(null));

    }

    @Test
    public void getBooksNullYearTest() {
        assertThrows(NullYearException.class, () -> toTest.getBooksByYear(null));
    }

    @Test
    public void editBookNullIdTest() {
        List<String> authors = new ArrayList<>();
        authors.add("Suzanne Collins");
        assertThrows(NullBookIdException.class, () -> toTest.editBook(null, new Book(1, "Hunger Games: Mocking Jay", authors, 2003)));
    }
    @Test
    public void editBookNullYearTest(){
        List<String> authors = new ArrayList<>();
        authors.add("Suzanne Collins");
        assertThrows(NullYearException.class, () -> toTest.editBook(3, new Book(3, "Hunger Games: Mocking Jay", authors, null)));

    }
    @Test
    public void editBookNullAuthorsTest(){

        assertThrows(NullAuthorException.class, () -> toTest.editBook(3, new Book(3, "Hunger Games: Mocking Jay", null ,1998)));

    }
    @Test
    public void editBookNullTitleTest(){
        List<String> authors = new ArrayList<>();
        authors.add("Suzanne Collins");
        assertThrows(NullTitleException.class, () -> toTest.editBook(3, new Book(3, null, null ,1998)));

    }
    @Test
    public void deleteBookNullIdTest(){
        assertThrows(NullBookIdException.class,()->toTest.DeleteBook(null));
    }

}