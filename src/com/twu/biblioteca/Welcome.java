package com.twu.biblioteca;

public class Welcome {
    private String message;
    private String menu;

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMenu() {
        return this.menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public void showMessage() {
        System.out.println(this.message);
    }

    public void showMenu() {
        System.out.println(this.menu);
    }

    public void init() {
        this.showMessage();
        this.showMenu();
    }
}
