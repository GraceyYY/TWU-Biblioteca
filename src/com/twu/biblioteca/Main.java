package com.twu.biblioteca;

import java.util.Scanner;

public class Main {
    private static Welcome welcome = new Welcome("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    private static Menu menu = new Menu();
    private static BookRepository bookRepository = new BookRepository();

    public static void init() {
        welcome.showMessage();
        menu.addMenu("1", "List of books");
        menu.addMenu("2", "Check out a book");
        menu.showMenu();
    }

    public static void selectOption(String input) {
        bookRepository.createMockList();
        switch (input) {
            case "1":
                bookRepository.showAllBooks();
                break;
            case "2":
                Scanner scanner = new Scanner(System.in);
                String bookTitle = scanner.next();
                bookRepository.checkOut(bookTitle);
            default:
                System.out.println("Please select a valid option!");
        }
    }
}
