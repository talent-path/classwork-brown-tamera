package com.tp.librarymanagementsystem.persistence;

import com.tp.librarymanagementsystem.exceptions.*;
import com.tp.librarymanagementsystem.model.LibraryBook;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class LibraryInMemDAO implements LibraryDAO{

    private List<LibraryBook> allBooks = new ArrayList<>();
    Integer id=0;

    @Override
    public List<LibraryBook> getAllBooks() {

        List<LibraryBook> copy= new ArrayList<>();
        for(LibraryBook copies : allBooks){
            copy.add(new LibraryBook(copies));
        }
        return allBooks;
    }

    @Override
    public LibraryBook getBookById(Integer bookId) throws NullBookIdException, InvalidBookIdException {


        if(bookId==null){
            throw new NullBookIdException("Book id cannot be null");
        }

        for (LibraryBook book : allBooks) {
            if (book.getBookId().equals(bookId)) {
                return book;
            }
        }
       throw new InvalidBookIdException("No Book in inventor with " + bookId);
    }

    @Override
    public List<LibraryBook> getBookByTitle(String Title) throws NullTitleException, InvalidTitleException {
        if(Title==null){
            throw new NullTitleException("No Book with a null Title");

        }
        List<LibraryBook> copy=new ArrayList<>();
        for(LibraryBook copies : allBooks){
            if(copies.getTitle().toLowerCase().contains(Title.toLowerCase())){
                copy.add(new LibraryBook(copies));
            }
        }

        return copy;
    }

    @Override
    public List<LibraryBook> getBookByAuthor(String Author) throws NullAuthorException {
        if(Author==null){
            throw new NullAuthorException("No Book with a null Author(s)");

        }

        return allBooks.stream().filter(book -> book.getAuthor().stream()
                .anyMatch(Author::equalsIgnoreCase)).collect(Collectors.toList());


    }

    @Override
    public List<LibraryBook> getBookByYear(Integer Year) throws InvalidYearException,NullYearException {
    Calendar calendar=Calendar.getInstance();
    calendar.setTime(new Date());
    int year=calendar.get(Calendar.YEAR);
        if(Year==null){
            throw new NullYearException("No book with 0 year");
        }
        if(Year>year || Year < 1960){
            throw new InvalidYearException("Cannot get book with future year or older then 1960");
        }
        List<LibraryBook> copy=new ArrayList<>();
        for(LibraryBook copies : allBooks){
            if(copies.getYear().equals(Year)){
                copy.add(new LibraryBook(copies));
            }
        }

        return copy;


    }

    @Override
    public LibraryBook UpdateBook(Integer bookId,LibraryBook UpdatedBook) throws InvalidBookIdException,NullBookIdException {

        if(bookId==null){
            throw new NullBookIdException("Cannot Update book with null id");

        }
        for(LibraryBook book : allBooks){
            if(book.getBookId().equals(bookId)){
                book.setTitle(UpdatedBook.getTitle());
                book.setAuthor(UpdatedBook.getAuthor());
                book.setYear(UpdatedBook.getYear());
                return book;
            }
        }

        throw new InvalidBookIdException("Cannot update book " + bookId);

    }

    @Override
    public void DeleteBook(Integer bookId) throws InvalidBookIdException{

        for(int i=0; i<allBooks.size();i++){
            if(allBooks.get(i).getBookId().equals(bookId)){
                allBooks.remove(i);
                return;
            }
        }
        throw new InvalidBookIdException("Cannot delete book with id " + bookId);
    }

    @Override
    public LibraryBook addBook(LibraryBook Newbook) throws InvalidAuthorException, NullTitleException, InvalidYearException,InvalidTitleException,NullYearException,NullAuthorException{
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(new Date());
        int year=calendar.get(Calendar.YEAR);

        if(Newbook.getAuthor().size()==0){
            throw new InvalidAuthorException("Cannot add book without authors");
        }
        if(Newbook.getYear()==null){
            throw new NullYearException("Cannot add book without year");
        }
        if(Newbook.getTitle()==null){
            throw new NullTitleException("Cannot add book without Title");
        }
        if (Newbook.getTitle() == "") {
            throw new InvalidTitleException("Cannot add book with empty title");
        }
        if(Newbook.getAuthor()==null){
            throw  new NullAuthorException("Cannot add book with null author");
        }
        if(Newbook.getYear()>year){
            throw  new InvalidYearException("Cannot add books with future year");
        }


        Newbook.setBookId(id++);



        allBooks.add(Newbook);

        return Newbook;
    }
}
