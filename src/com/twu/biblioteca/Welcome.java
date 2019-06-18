package com.twu.biblioteca;

public class Welcome {
    private String message;

    public Welcome(String message) {
        this.message = message;
    }

    public void showMessage() {
        System.out.println(this.message);
    }

}
