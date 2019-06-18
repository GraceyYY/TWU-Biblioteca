package com.twu.biblioteca;

import java.util.Set;

public class Main {
    private static Welcome welcome = new Welcome("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    private static Menu menu = new Menu();
    private static BookRepository bookRepository = new BookRepository();

    public static void init() {
        welcome.showMessage();
        menu.addMenu("1", "List of books");
        menu.showMenu();
    }

    public static void selectOption(String input) {
        bookRepository.createMockList();
        switch (input) {
            case "1":
                bookRepository.showAllBooksWithAuthorAndPublicationYear();
                break;
            default:
                System.out.println("Please select a valid option!");
        }
    }
}
