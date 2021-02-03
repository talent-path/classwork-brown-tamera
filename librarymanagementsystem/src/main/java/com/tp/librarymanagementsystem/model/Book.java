package com.tp.librarymanagementsystem.model;

import java.util.ArrayList;
import java.util.List;

public class Book {

    private Integer bookId;
    private String Title;
    private List<String> Authors;
    private Integer Year;

    public Book(Integer bookId, String title, List<String> authors, Integer year) {
        this.bookId = bookId;
        this.Title = title;
        this.Authors = authors;
        this.Year = year;
    }
    public Book(Book that){

        this.bookId=that.bookId;
        this.Title=that.Title;
        this.Authors= new ArrayList<>();
        for( String toCopy : that.Authors ){
            this.Authors.add( toCopy );
        }

        this.Year=that.Year;

    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public List<String> getAuthors() {
        return Authors;
    }

    public void setAuthors(List<String> authors) {
        Authors = authors;
    }

    public Integer getYear() {
        return Year;
    }

    public void setYear(Integer year) {
        Year = year;
    }
}

