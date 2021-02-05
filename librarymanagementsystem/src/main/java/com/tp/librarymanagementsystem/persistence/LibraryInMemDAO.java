package com.tp.librarymanagementsystem.persistence;

import com.tp.librarymanagementsystem.exceptions.*;
import com.tp.librarymanagementsystem.model.Book;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

//@Repository
public class LibraryInMemDAO implements LibraryDAO{

    private List<Book> allBooks = new ArrayList<>();


    @Override
    public List<Book> getAllBooks(){

        List<Book> copy= new ArrayList<>();
        for(Book copies : allBooks){
            copy.add(new Book(copies));
        }
        return allBooks;
    }

    @Override
    public Book getBookById(Integer bookId) throws NullBookIdException, InvalidBookIdException {


        if(bookId==null){
            throw new NullBookIdException("Book id cannot be null");
        }

        for (Book book : allBooks) {
            if (book.getBookId().equals(bookId)) {
                return book;
            }
        }
       throw new InvalidBookIdException("No Book in inventory with id " + bookId);
    }

    @Override
    public List<Book> getBooksByTitle(String Title) throws NullTitleException, InvalidTitleException {
        if(Title==null){
            throw new NullTitleException("No Book with a null Title");

        }
        List<Book> copy=new ArrayList<>();
        for(Book copies : allBooks){
            if(copies.getTitle().toLowerCase().contains(Title.toLowerCase())){
                copy.add(new Book(copies));
            }
        }

        return copy;
    }

    @Override
    public List<Book> getBooksByAuthor(String Author) throws NullAuthorException {
        if(Author==null){
            throw new NullAuthorException("No Book with a null Author(s)");

        }

        return allBooks.stream().filter(book -> book.getAuthors().stream()
                .anyMatch(Author::equalsIgnoreCase)).collect(Collectors.toList());


    }

    @Override
    public List<Book> getBooksByYear(Integer Year) throws InvalidYearException,NullYearException {
    Calendar calendar=Calendar.getInstance();
    calendar.setTime(new Date());
    int year=calendar.get(Calendar.YEAR);
        if(Year==null){
            throw new NullYearException("No book with null year");
        }
        if(Year>year || Year < 1960){
            throw new InvalidYearException("Cannot get book with future year or older then 1960");
        }
        List<Book> copy=new ArrayList<>();
        for(Book copies : allBooks){
            if(copies.getYear().equals(Year)){
                copy.add(new Book(copies));
            }
        }

        return copy;


    }

    @Override
    public Book editBook(Integer bookId, Book UpdatedBook) throws InvalidBookIdException,NullBookIdException,NullAuthorException ,NullYearException, NullTitleException{

        if(UpdatedBook.getTitle()==null){
            throw new NullTitleException("Cannot update book with null title");
        }

         if(UpdatedBook.getAuthors()==null){
             throw new NullAuthorException("Cannot update bokk with null authors");
         }
        if(UpdatedBook.getYear()==null){
            throw new NullYearException("Cannot update book with null year");
        }
        if(bookId==null){
            throw new NullBookIdException("Cannot Update book with null id");

        }
        if(UpdatedBook.getAuthors()==null){
            throw new NullAuthorException("Cannot update with null authors");
        }
        for(Book book : allBooks){
            if(book.getBookId().equals(bookId)){
                book.setTitle(UpdatedBook.getTitle());
                book.setAuthors(UpdatedBook.getAuthors());
                book.setYear(UpdatedBook.getYear());
                return book;
            }
        }

        throw new InvalidBookIdException("Cannot update book " + bookId);

    }

    @Override
    public void DeleteBook(Integer bookId) throws InvalidBookIdException, NullBookIdException{

        if(bookId==null){
            throw new NullBookIdException("Cannot delete with null book id");
        }
        for(int i=0; i<allBooks.size();i++){
            if(allBooks.get(i).getBookId().equals(bookId)){
                allBooks.remove(i);
                return;
            }
        }
        throw new InvalidBookIdException("Cannot delete book with id " + bookId);
    }

    @Override
    public Book addBook(Book Newbook) throws InvalidAuthorException, NullTitleException, InvalidYearException,InvalidTitleException,NullYearException,NullAuthorException,NullBookObjectException{
        Integer id=0;
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(new Date());
        int year=calendar.get(Calendar.YEAR);

        if(Newbook==null){
            throw new NullBookObjectException("Book object is null");
        }
        if(Newbook.getAuthors()==null){
            throw new NullAuthorException("Cannot add book with null author");
        }
        if(Newbook.getAuthors().size()==0){
            throw new InvalidAuthorException("Cannot add book without authors");
        }
        if(Newbook.getAuthors().equals("")){
            throw new InvalidAuthorException("Cannot add book with eempty authors");

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
        if(Newbook.getAuthors()==null){
            throw  new NullAuthorException("Cannot add book with null author");
        }
        if(Newbook.getYear()>year){
            throw  new InvalidYearException("Cannot add books with future year");
        }

        for(Book toCheck : allBooks){
            if(toCheck.getBookId()>id){
                id=toCheck.getBookId();
            }
        }
        id++;

        Book copy=new Book(Newbook);
        copy.setBookId(id);
        allBooks.add(copy);


        return copy;

    }
}
