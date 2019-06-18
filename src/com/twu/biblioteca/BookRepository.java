package com.twu.biblioteca;

import java.util.HashMap;
import java.util.Map;

public class BookRepository {
    private Map<String, Book> bookList;

    public BookRepository() {
        this.bookList = new HashMap<String, Book>();
        bookList.put("The Hunger Games", new Book("The Hunger Games"));
        bookList.put("Harry Potter and the Order of the Phoenix", new Book("Harry Potter and the Order of the Phoenix"));
        bookList.put("To Kill a MockingBird", new Book("To Kill a MockingBird"));
        bookList.put("Pride and Prejudice", new Book("Pride and Prejudice"));
        bookList.put("Twilight", new Book("Twilight"));
        bookList.put("The Book Thief", new Book("The Book Thief"));
        bookList.put("Animal Farm", new Book("Animal Farm"));
        bookList.put("The Chronicles of Narnia", new Book("The Chronicles of Narnia"));
    }

    public Map<String, Book> getBookList() {
        return this.bookList;
    }

    public void showAllBooks() {
        for (String name : this.bookList.keySet()) {
            System.out.println(name);
        }
    }
}
