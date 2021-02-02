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
    public void setUp() throws InvalidBookIdException {


        List<Book> allBooks = toTest.getAllBooks();
        for(int i=0; i<allBooks.size();i++){

            toTest.DeleteBook(i);
        }

    }

//            List<String> Authors = new ArrayList<>();
//            Authors.add("Obama");
//            Book test = new Book(0, "A Promised Land", Authors, 2020);
//            toTest.addBook(test);
//            Book test2= new Book(1,"Becoming",Authors,2019);
//            toTest.addBook(test2);

@Test
public void addBookGoldenPathTest() {
    try {
        List<String> authors = new ArrayList<>();
        authors.add("libi Zoboi");
        authors.add("Yusef Salaam");

        Book test = new Book(1, "Punching the Air", authors, 2020);

        Book validate= new Book(toTest.addBook(test));

        List<String> secondAuthors = new ArrayList<>();
        secondAuthors.add("Obama");


        Book test2 = new Book(2, "Becoming", secondAuthors, 2019);

        Book validate2= new Book(toTest.addBook(test2));


            //First Book
        assertEquals("Punching the Air", validate.getTitle());
        assertEquals(2, validate.getAuthor().size());
        assertEquals(1, validate.getBookId());
        assertEquals("libi Zoboi", validate.getAuthor().get(0));
        assertEquals("Yusef Salaam",validate.getAuthor().get(1));
        assertEquals(2020, validate.getYear());

        // Second Book
        assertEquals("Becoming", validate2.getTitle());
        assertEquals(1, validate2.getAuthor().size());
        assertEquals(2, validate2.getBookId());
        assertEquals("Obama", validate.getAuthor().get(0));
        assertEquals(2019,validate2.getYear());

       // assertThrows(InvalidAuthorException.class, ()->toTest.addBook(test));

    } catch (InvalidAuthorException | InvalidYearException | NullTitleException | InvalidTitleException | NullYearException | NullAuthorException e) {
        fail();

    }
}
@Test
public void NullBookObjectTest() throws NullBookObjectException{

      Book test= new Book(null);
      fail();
}



    @Test
    public void getBookGoldenPathTest() {

        try {
            Book test = toTest.getBookById(1);
            System.out.println(test.getTitle());
            assertTrue(test.getTitle().equals("Punching the Air"));
            assertEquals(1, test.getBookId());
            assertEquals(2020, test.getYear());
            assertEquals(2, test.getAuthor().size());

        } catch (InvalidBookIdException | NullBookIdException e) {
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
            Book book = new Book(0, null, authors, 1997);
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
            Book book = new Book(0, "First Book", null, 2021);
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
            Book book = new Book(0, "First Book", authors, null);
            toTest.addBook(book);

        } catch (NullTitleException | InvalidYearException | NullAuthorException | InvalidTitleException | InvalidAuthorException e) {
            fail();
        } catch (NullYearException e) {
            //do nothing
        }
    }
    @Test
    public void DeleteBookGoldenPath() {

        assertThrows(InvalidBookIdException.class,()->toTest.DeleteBook(1));
    }
    @Test
    public void getBookByIdNullTest() {

            assertThrows(NullBookIdException.class,()->toTest.getBookById(null));


    }
    @Test
    public void getBookByTitleNullTest() {


            assertThrows(NullTitleException.class,()->toTest.getBooksByTitle(null));
            assertThrows(InvalidTitleException.class,()->toTest.getBooksByTitle(null));


    }
    @Test
    public void getBookByAuthorNullTest() {
        assertThrows(NullAuthorException.class,()->toTest.getBooksByAuthor(null));
    }



}
