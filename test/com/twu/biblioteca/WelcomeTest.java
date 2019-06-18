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
        welcome = new Welcome();
        welcome.setMessage("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
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
        welcome.showMessage();
        String message = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n";

        assertEquals(message, bytes.toString());
    }


}
