package com.twu.biblioteca;

public class Main {
    private static Welcome welcome = new Welcome("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    private static Menu menu = new Menu("1. List of books");
    private static BookRepository bookRepository = new BookRepository();
    
    public static void init() {
        welcome.showMessage();
        menu.showMenu();
    }

    public static void selectOption(int input) {
        bookRepository.createMockList();
        bookRepository.showAllBooksWithAuthorAndPublicationYear();
    }
}
