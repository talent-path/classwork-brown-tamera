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
        for (int i = 0; i < allBooks.size(); i++) {

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
           Book returned= toTest.addBook(test);
            Book validate=toTest.getBookById(1);

            assertEquals(1,returned.getBookId());
            assertEquals(2,returned.getAuthors().size());
            assertEquals("libi Zoboi",returned.getAuthors().get(0));
            assertEquals("Punching the Air",returned.getTitle());
            assertEquals(2020, returned.getYear());






//            assertEquals("Punching the Air", validate.getTitle());
//            assertEquals(2, validate.getAuthors().size());
//            assertEquals("libi Zoboi", authors.get(0));
//            assertEquals("Yusef Salaam", authors.get(1));
//            assertEquals(2020, validate.getYear());
//            assertEquals(1, validate.getBookId());
//
//            List<String> secondAuthors=new ArrayList<>();
//            secondAuthors.add("Obama");
//
//            Book test2=new Book(2,"Becoming",secondAuthors,2019 );
//            toTest.addBook(test2);
//            Book validate2=toTest.getBookById(2);
//            assertEquals("Becoming", validate2.getTitle());
//            assertEquals(1, validate2.getAuthors().size());
//            assertEquals("Obama", secondAuthors.get(0));
//            assertEquals(2019, validate.getYear());
//            assertEquals(2, validate.getBookId());
//
//
//



        } catch (InvalidBookIdException | NullBookIdException | NullTitleException | InvalidTitleException | NullYearException | InvalidYearException | NullAuthorException | InvalidAuthorException e) {
            fail();
        }
    }

//@Test
//public void NullBookObjectTest(){
//
//      assertThrows(NullBookObjectException.class,()->toTest.addBook(null));
//}
//
//
//
//    @Test
//    public void getBookGoldenPathTest() {
//
//        try {
//            Book test = toTest.getBookById(1);
//            System.out.println(test.getTitle());
//            assertTrue(test.getTitle().equals("Punching the Air"));
//            assertEquals(1, test.getBookId());
//            assertEquals(2020, test.getYear());
//            assertEquals(2, test.getAuthor().size());
//
//        } catch (InvalidBookIdException | NullBookIdException e) {
//            fail();
//        }
//
//    }
//
//
//
//    @Test
//    public void addBookNullTitleTest(){
//        try {
//            List<String> authors = new ArrayList<>();
//            authors.add("Me");
//            authors.add("John");
//            authors.add("Shannon");
//            Book book = new Book(0, null, authors, 1997);
//            toTest.addBook(book);
//        } catch (InvalidAuthorException | InvalidTitleException | InvalidYearException | NullYearException | NullAuthorException e) {
//            fail();
//
//        } catch (NullTitleException e) {
//            //do nothing
//        }
//    }
//    @Test
//    public void addBookNullAuthorsTest() {
//        try {
//            Book book = new Book(0, "First Book", null, 2021);
//            toTest.addBook(book);
//
//        } catch (NullTitleException | InvalidYearException | NullYearException | InvalidTitleException e) {
//            fail();
//        } catch (NullAuthorException | InvalidAuthorException |NullPointerException e) {
//            //do nothing
//        }
//    }
//    @Test
//    public void addBookNullYearTest(){
//        List<String> authors=new ArrayList<>();
//        authors.add("Tyler Perry");
//        authors.add("Tamera");
//        try {
//            Book book = new Book(0, "First Book", authors, null);
//            toTest.addBook(book);
//
//        } catch (NullTitleException | InvalidYearException | NullAuthorException | InvalidTitleException | InvalidAuthorException e) {
//            fail();
//        } catch (NullYearException e) {
//            //do nothing
//        }
//    }
//    @Test
//    public void DeleteBookGoldenPath() {
//
//        assertThrows(InvalidBookIdException.class,()->toTest.DeleteBook(1));
//    }
//    @Test
//    public void getBookByIdNullTest() {
//
//            assertThrows(NullBookIdException.class,()->toTest.getBookById(null));
//
//
//    }
//    @Test
//    public void getBookByTitleNullTest() {
//
//
//            assertThrows(NullTitleException.class,()->toTest.getBooksByTitle(null));
//            assertThrows(InvalidTitleException.class,()->toTest.getBooksByTitle(null));
//
//
//    }
//    @Test
//    public void getBookByAuthorNullTest() {
//        assertThrows(NullAuthorException.class,()->toTest.getBooksByAuthor(null));
//    }
//
//    @Test
//    public void getAllBookGoldenPathTest(){
//        List<Book> test=toTest.getAllBooks();
//        System.out.println(test);
//        assertEquals("libi Zoboi",test.get(0).getAuthor().get(0));
//        assertEquals(1,test.size());
//        assertEquals("Punching the Air",test.get(0).getTitle());
//        assertEquals(2020,test.get(0).getYear());
//        assertEquals(1,test.get(0).getAuthor().size());
//        assertEquals(1,test.get(0).getBookId());
//
//    }
//
//

}
