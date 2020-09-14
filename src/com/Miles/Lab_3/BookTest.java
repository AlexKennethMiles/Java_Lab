package com.Miles.Lab_3;

public class BookTest {
    public static void main(String[] args) {
        System.out.println("Exercise 3.3");
        Book book1 = new Book("Fedor Dostoevsky", "Crime and punishment", 1866, 331);
        System.out.println("First book");
        System.out.println("Author: " + book1.getAuthor()
                + "; Title: " + book1.getName()
                + "; Year: " + book1.getYear()
                + "; Page count: " + book1.getPage_count());
        Book book2 = new Book();
        book2.setBook("Leo Tolstoy", "War and Peace", 1863, 1274);
        System.out.println("Second book");
        System.out.println("Author: " + book2.getAuthor()
                + "; Title: " + book2.getName()
                + "; Year: " + book2.getYear()
                + "; Page count: " + book2.getPage_count());
    }
}
