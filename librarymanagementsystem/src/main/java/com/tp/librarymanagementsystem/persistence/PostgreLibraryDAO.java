package com.tp.librarymanagementsystem.persistence;

import com.tp.librarymanagementsystem.exceptions.*;
import com.tp.librarymanagementsystem.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//@Repository
public class PostgreLibraryDAO implements LibraryDAO {

    @Autowired
    JdbcTemplate template;

    @Override
    public List<Book> getAllBooks() {
        return null;
    }

    @Override
    public Book getBookById(Integer bookId) throws NullBookIdException, InvalidBookIdException {
        return null;
    }

    @Override
    public List<Book> getBooksByTitle(String Title) throws NullTitleException, InvalidTitleException {
        return null;
    }

    @Override
    public List<Book> getBooksByAuthor(String Author) throws NullAuthorException {
        return null;
    }

    @Override
    public List<Book> getBooksByYear(Integer Year) throws InvalidYearException, NullYearException {
        return null;
    }

    @Override
    public Book editBook(Integer bookId, Book NewBook) throws InvalidBookIdException, NullBookIdException, NullAuthorException, NullYearException, NullTitleException {
        return null;
    }

    @Override
    public void DeleteBook(Integer bookId) throws InvalidBookIdException, NullBookIdException {

    }

    @Override
    public Book addBook(Book book) throws InvalidAuthorException, InvalidYearException, NullYearException, NullTitleException, InvalidTitleException, NullAuthorException, NullBookObjectException {
       List<Integer> authorList=new ArrayList<>();

        for(String author: book.getAuthors()){

            Integer authorId=addOrRetreive(author);
            authorList.add(authorId);
        }

        return null;
    }

    private Integer addOrRetreive(String author) {

        Integer autherId=getAuthorId(author);

        if(autherId==null){
            autherId=addAuthor(author);
        }
        return autherId;



    }

    private Integer getAuthorId(String author) {
        List<Integer> id = template.query("SELECT \"authorId\" from \"Authors\" WHERE " +
                "\"authorName\" = '"+ author +"'; ", new IdMapper());

        if(id.isEmpty()) return null;
         return id.get(0);
    }

    private Integer addAuthor(String author){
        return template.query("INSERT INTO \"Authors\"(\"authorName\")\n\t" +
                "VALUES ('"+ author+"')\n" +
                " returning \"authorId\";\n" + "\n", new IdMapper()).get(0);

    }
    private class IdMapper implements RowMapper<Integer> {

        @Override
        public Integer mapRow(ResultSet resultSet, int i) throws SQLException {
           return resultSet.getInt("authorId");

        }
    }
}
