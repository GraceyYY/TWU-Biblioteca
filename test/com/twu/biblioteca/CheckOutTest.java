package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class CheckOutTest {
    PrintStream console = null;
    ByteArrayOutputStream bytes = null;
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
    public void shouldSetCheckedOutToTrueAfterCheckingOut() {
        bookRepository.checkOut("Animal Farm");
        assertTrue(bookRepository.getBookList().get("Animal Farm").isCheckedOut());
    }

    @Test
    public void shouldPrintSuccessMessageWhenCheckOutSuccessfully() {
        bookRepository.checkOut("Animal Farm");
        assertEquals("Thank you! Enjoy the book\n", bytes.toString());
    }

    @Test
    public void shouldPrintNoticeMessageWhenCheckOutUnsuccessfully() {
        bookRepository.getBookList().get("Animal Farm").setCheckedOut(true);
        bookRepository.checkOut("Animal Farm");
        assertEquals("Sorry, that book is not available\n", bytes.toString());
    }
}
