package com.Miles.Lab_3;

public class Book {
    String author;
    String name;
    int year;
    int page_count;
    public Book(){}
    public Book(String Author, String Name, int Year, int Page_count){
        author = Author;
        name = Name;
        year = Year;
        page_count = Page_count;
    }
    public void setBook(String Author, String Name, int Year, int Page_count){
        author = Author;
        name = Name;
        year = Year;
        page_count = Page_count;
    }
    public String getAuthor(){
        return author;
    }
    public String getName(){
        return name;
    }
    public int getYear(){
        return year;
    }
    public int getPage_count(){
        return page_count;
    }
}
