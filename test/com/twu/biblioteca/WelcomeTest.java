package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class WelcomeTest {
    PrintStream console = null;
    ByteArrayOutputStream bytes = null;
    Welcome welcome;

    @Before
    public void setUp() throws Exception {
        bytes = new ByteArrayOutputStream();
        console = System.out;
        System.setOut(new PrintStream(bytes));
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(console);
    }

    @Test
    public void shouldPrintWelcomeMessage() {
        String message = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
        welcome = new Welcome(message);
        welcome.showMessage();

        assertEquals(message + '\n', bytes.toString());
    }

    @Test
    public void shouldDisplayMenuAfterWelcomeMessage() {
        String message = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
        Menu menu = new Menu();
        menu.addMenu("1", "List of books");
        menu.addMenu("2", "Check out a book");
        menu.addMenu("3", "Return a book");
        Main.init();

        assertEquals(message + '\n' + menu.getMenuList() + '\n', bytes.toString());
    }


}
