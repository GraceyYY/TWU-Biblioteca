package com.twu.biblioteca;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BookRepository {
    private Map<String, Book> bookList;

    public BookRepository() {
        this.bookList = new HashMap<String, Book>();
    }

    public void createMockList() {
        bookList.put("The Hunger Games", new Book("The Hunger Games","Suzanne Collins",2008, false));
        bookList.put("Harry Potter and the Order of the Phoenix", new Book("Harry Potter and the Order of the Phoenix","J.K. Rowling", 2003, false));
        bookList.put("To Kill a MockingBird", new Book("To Kill a MockingBird", "Harper Lee", 1960,false));
        bookList.put("Pride and Prejudice", new Book("Pride and Prejudice","Jane Austen", 1813,false));
        bookList.put("Twilight", new Book("Twilight","Stephenie Meyer", 2005,false));
        bookList.put("The Book Thief", new Book("The Book Thief", "Markus Zusak", 2005,false));
        bookList.put("Animal Farm", new Book("Animal Farm", "George Orwell", 1945,false));
        bookList.put("The Chronicles of Narnia", new Book("The Chronicles of Narnia", "C.S. Lewis", 1956,false));
    }

    public Map<String, Book> getBookList() {
        return this.bookList;
    }

    public void showAllBooks() {
        this.bookList.values().stream().filter(book -> !book.isCheckedOut()).forEach(book -> System.out.println(book.displayBookInfo()));
    }

}
