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
    public void setUp(){
        List<LibraryBook> allBooks=toTest.getAllBooks();

        for(LibraryBook toRemove: allBooks) {
            try {
                toTest.DeleteBook(toRemove.getBookId());

            List<String> Authors = new ArrayList<>();
            Authors.add("Obama");
            LibraryBook test = new LibraryBook(0, "A Promised Land", Authors, 2020);
            toTest.addBook(test);
        }catch (InvalidBookIdException e) {
                fail();
            } catch (NullTitleException e) {
                e.printStackTrace();
            } catch (InvalidYearException e) {
                e.printStackTrace();
            } catch (InvalidAuthorException e) {
                e.printStackTrace();
            }
        }


    @Test
    public void getBookGoldenPathTest(){
        try {
            LibraryBook test=toTest.getBookById(0);

        } catch (NullBookIdException e) {
            fail();
        }

    }
}
