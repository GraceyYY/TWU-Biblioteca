package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class BookListTest {
    PrintStream console;
    ByteArrayOutputStream bytes;
    BookRepository bookRepository;

    @Before
    public void setUp() {
        bytes = new ByteArrayOutputStream();
        console = System.out;
        System.setOut(new PrintStream(bytes));
        this.bookRepository = new BookRepository();
        this.bookRepository.createMockList();
    }

    @After
    public void tearDown() {
        System.setOut(console);
    }

    @Test
    public void shouldDisplayAllBooks() {
        Map<String, Book> bookList = this.bookRepository.getBookList();
        String allBooks = "";
        for (String name :
                bookList.keySet()) {
            allBooks += (name + '\n');
        }

        this.bookRepository.showAllBooks();

        assertEquals(allBooks, bytes.toString());
    }

    @Test
    public void shouldDisplayAllBooksWithAuthorAndPublicationYear() {
        Map<String, Book> bookList = this.bookRepository.getBookList();
        String allBooksWithAuthorAndPublicationYear = "";
        for (Book book : bookList.values()) {
            allBooksWithAuthorAndPublicationYear += ("| " + book.getName() + " | author: " + book.getAuthor() + " | publication year: " + book.getPublicationYear() + " |" + "\n");
        }

        this.bookRepository.showAllBooksWithAuthorAndPublicationYear();

        assertEquals(allBooksWithAuthorAndPublicationYear, bytes.toString());

    }

}
