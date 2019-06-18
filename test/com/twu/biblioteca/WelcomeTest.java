package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.core.CombinableMatcher.both;
import static org.hamcrest.core.StringEndsWith.endsWith;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

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
        welcome = new Welcome();
        welcome.setMessage(message);
        welcome.showMessage();

        assertEquals(message + '\n', bytes.toString());
    }

    @Test
    public void shouldDisplayMenuAfterWelcomeMessage() {
        String message = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
        welcome = new Welcome();
        welcome.setMessage(message);
        welcome.setMenu("1. List of books");
        welcome.init();

        assertEquals(message + '\n' + welcome.getMenu() + '\n', bytes.toString());
    }


}
