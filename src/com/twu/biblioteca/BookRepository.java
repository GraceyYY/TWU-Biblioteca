package com.twu.biblioteca;

import java.util.HashMap;
import java.util.Map;

public class BookRepository {
    private Map<String, Book> bookList;

    public BookRepository() {
        this.bookList = new HashMap<String, Book>();
    }

    public void createMockList() {
        bookList.put("The Hunger Games", new Book("The Hunger Games","Suzanne Collins",2008));
        bookList.put("Harry Potter and the Order of the Phoenix", new Book("Harry Potter and the Order of the Phoenix","J.K. Rowling", 2003));
        bookList.put("To Kill a MockingBird", new Book("To Kill a MockingBird", "Harper Lee", 1960));
        bookList.put("Pride and Prejudice", new Book("Pride and Prejudice","Jane Austen", 1813));
        bookList.put("Twilight", new Book("Twilight","Stephenie Meyer", 2005));
        bookList.put("The Book Thief", new Book("The Book Thief", "Markus Zusak", 2005));
        bookList.put("Animal Farm", new Book("Animal Farm", "George Orwell", 1945));
        bookList.put("The Chronicles of Narnia", new Book("The Chronicles of Narnia", "C.S. Lewis", 1956));
    }

    public Map<String, Book> getBookList() {
        return this.bookList;
    }

    public void showAllBooks() {
        for (String name : this.bookList.keySet()) {
            System.out.println(name);
        }
    }

    public void showAllBooksWithAuthorAndPublicationYear() {
        for (Book book : this.bookList.values()) {
            System.out.println(book.displayBookInfo());
        }
    }
}
