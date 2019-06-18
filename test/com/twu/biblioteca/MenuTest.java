package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class MenuTest {
    PrintStream console = null;
    ByteArrayOutputStream bytes = null;
    Menu menu;

    @Before
    public void setUp() {
        bytes = new ByteArrayOutputStream();
        console = System.out;
        System.setOut(new PrintStream(bytes));
        menu = new Menu();
        menu.addMenu("1", "List of books");
    }

    @After
    public void tearDown() {
        System.setOut(console);
    }

    @Test
    public void shouldDisplayBookListWhenChooseFirstOption() {
        BookRepository bookRepository = new BookRepository();
        bookRepository.createMockList();
        Map<String, Book> bookList = bookRepository.getBookList();
        String allBooksWithAuthorAndPublicationYear = "";
        for (Book book : bookList.values()) {
            allBooksWithAuthorAndPublicationYear += ("| " + book.getName() + " | author: " + book.getAuthor() + " | publication year: " + book.getPublicationYear() + " |" + "\n");
        }
        Main.selectOption("1");
        assertEquals(allBooksWithAuthorAndPublicationYear, bytes.toString());
    }

    @Test
    public void shouldDisplayNoticeMessageWhenChooseInvalidOption() {
        Main.selectOption("a");
        assertEquals("Please select a valid option!", bytes.toString());
    }
}
