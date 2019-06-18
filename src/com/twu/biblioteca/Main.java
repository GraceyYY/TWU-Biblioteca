package com.twu.biblioteca;

import java.util.Scanner;

public class Main {
    private static Welcome welcome = new Welcome("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    private static Menu menu = new Menu();
    private static BookRepository bookRepository = new BookRepository();

    public static void init() {
        bookRepository.createMockList();
        welcome.showMessage();
        menu.addMenu("1", "List of books");
        menu.addMenu("2", "Check out a book");
        menu.addMenu("3", "Return a book");
        menu.addMenu("4", "Quit");
        showOptions();
    }

    public static void selectOption(String input) {
        Scanner scanner = new Scanner(System.in);
        String bookTitle;
        switch (input) {
            case "1":
                bookRepository.showAllBooks();
                break;
            case "2":
                System.out.println("Please type the book title: ");
                bookTitle = scanner.nextLine();
                bookRepository.checkOut(bookTitle);
                break;
            case "3":
                System.out.println("Please type the book title: ");
                bookTitle = scanner.nextLine();
                bookRepository.returnBook(bookTitle);
                break;
            case "4":
                System.exit(0);
                break;
            default:
                System.out.println("Please select a valid option!");
        }
        showOptions();
    }

    private static void showOptions() {
        menu.showMenu();
        System.out.println("Please select a option: ");
        Scanner scanner = new Scanner(System.in);
        selectOption(scanner.nextLine());
    }
}
