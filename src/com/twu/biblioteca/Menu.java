package com.twu.biblioteca;

public class Menu {
    private String menu;

    public Menu(String menu) {
        this.menu = menu;
    }

    public String getMenu() {
        return this.menu;
    }

    public void showMenu() {
        System.out.println(this.menu);
    }
}
