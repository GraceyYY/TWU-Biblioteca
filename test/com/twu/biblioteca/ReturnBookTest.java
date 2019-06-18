package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class ReturnBookTest {
    PrintStream console = null;
    ByteArrayOutputStream bytes = null;
    BookRepository bookRepository;

    @Before
    public void setUp() {
        bytes = new ByteArrayOutputStream();
        console = System.out;
        System.setOut(new PrintStream(bytes));
        bookRepository = new BookRepository();
        bookRepository.createMockList();
        bookRepository.getBookList().get("To Kill a MockingBird").setCheckedOut(true);
    }

    @After
    public void tearDown() {
        System.setOut(console);
    }

    @Test
    public void shouldSetCheckOutToFalseAfterReturn() {
        bookRepository.returnBook("To Kill a MockingBird");

        assertFalse(bookRepository.getBookList().get("To Kill a MockingBird").isCheckedOut());
    }

    @Test
    public void shouldPrintMessageWhenReturnSuccessfully() {
        bookRepository.returnBook("To Kill a MockingBird");

        assertEquals("Thank you for returning the book\n", bytes.toString());
    }

    @Test
    public void shouldPrintNoticeMessageWhenReturnInvalid() {
        bookRepository.returnBook("Animal Farm");

        assertEquals("That is not a valid book to return\n", bytes.toString());
    }
}
