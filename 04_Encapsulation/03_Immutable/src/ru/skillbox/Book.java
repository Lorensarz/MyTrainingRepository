package ru.skillbox;

public class Book {
    private final String name;
    private final String author;
    private final int amountPages;
    private final int isbn;

    public Book(String name, String author, int amountPages, int isbn) {
        this.name = name;
        this.author = author;
        this.amountPages = amountPages;
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getAmountPages() {
        return amountPages;
    }

    public int getIsbn() {
        return isbn;
    }
}
