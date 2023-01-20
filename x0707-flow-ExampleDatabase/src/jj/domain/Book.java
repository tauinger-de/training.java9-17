package jj.domain;

public class Book {

    public final String isbn;
    public final String title;
    public final String author;

    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        return this.isbn + " " + this.title + " " + this.author;
    }

}
