package com.tp.librarymanagementsystem.controller;

import java.util.Date;

public class UpdateLibraryBookRequest {

    private Integer bookId;
    private String Title;
    private Date Year;
    private String Author;

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

    public Date getYear() {
        return Year;
    }

    public void setYear(Date year) {
        Year = year;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }
}
