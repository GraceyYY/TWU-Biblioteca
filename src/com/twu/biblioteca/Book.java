package com.twu.biblioteca;

public class Book {
    private String name;
    private String author;
    private int publicationYear;

    public Book(String name, String author, int publicationYear) {
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
}
