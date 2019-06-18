package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Map;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

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
    public void shouldDisplayAllBooksWithAuthorAndPublicationYear() {
        Map<String, Book> bookList = this.bookRepository.getBookList();
        String allBooksWithAuthorAndPublicationYear = "";
        for (Book book : bookList.values()) {
            allBooksWithAuthorAndPublicationYear += ("| " + book.getName() + " | author: " + book.getAuthor() + " | publication year: " + book.getPublicationYear() + " |" + "\n");
        }

        this.bookRepository.showAllBooks();

        assertEquals(allBooksWithAuthorAndPublicationYear, bytes.toString());

    }

    @Test
    public void shouldNotDisplayBooksThatAreCheckedOut() {
        Map<String, Book> bookList = this.bookRepository.getBookList();
        bookList.get("The Hunger Games").setCheckedOut(true);

        this.bookRepository.showAllBooks();

        assertThat(bytes.toString(), not(containsString("The Hunger Games")));

    }

}
