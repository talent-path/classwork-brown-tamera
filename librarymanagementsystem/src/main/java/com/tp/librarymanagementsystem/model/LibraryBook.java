package com.tp.librarymanagementsystem.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class LibraryBook {

    private Integer bookId;
    private String Title;
    private List<String> Author;
    private int Year;

    public LibraryBook(Integer bookId, String title, List<String> author, int year) {
        this.bookId = bookId;
        this.Title = title;
        this.Author = author;
        this.Year = year;
    }
    public LibraryBook (LibraryBook that){
        this.bookId=that.bookId;
        this.Title=that.Title;
        this.Year=that.Year;
        this.Author= new ArrayList<>();

        for( String toCopy : that.Author ){
            this.Author.add( toCopy );
        }

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

    public List<String> getAuthor() {
        return Author;
    }

    public void setAuthor(List<String> author) {
        Author = author;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int year) {
        Year = year;
    }
}

