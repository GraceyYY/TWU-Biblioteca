package com.twu.biblioteca;

public class Book {
    private String name;
    private String author;
    private int publicationYear;
    private boolean checkedOut;

    public Book(String name, String author, int publicationYear, boolean checkedOut) {
        this.name = name;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    public String displayBookInfo() {
        return "| " + this.name + " | author: " + this.author + " | publication year: " + this.publicationYear + " |";
    }

    public String getName() {
        return this.name;
    }

    public String getAuthor() {
        return this.author;
    }

    public int getPublicationYear() {
        return this.publicationYear;
    }

    public void setCheckedOut(boolean checkedOut) {
        this.checkedOut = checkedOut;
    }

    public boolean isCheckedOut() {
        return this.checkedOut;
    }
}
