package com.pluralsight.model;

public class Book extends Item {

    public Book(String isbn, String title, String author, String genre) {
        super(isbn, title, author, genre);
    }

    public Book(String isbn, String title, String author, String genre, boolean isAvailable) {
        super(isbn, title, author, genre, isAvailable);
    }

    // Convenience methods for books
    public String getIsbn() {
        return getId();
    }

    public String getAuthor() {
        return getCreator();
    }

    @Override
    public String getType() {
        return "Book";
    }

    @Override
    public int getBorrowDuration() {
        return 14; // 2 weeks for books
    }

    @Override
    public String toString() {
        return String.format("%s | %s by %s [%s] - %s",
                getIsbn(), getTitle(), getAuthor(), getGenre(),
                isAvailable() ? "Available" : "Borrowed");
    }

    /// //added a an override based on ISBN not Ingerited from item

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Book book = (Book) obj;
        return getIsbn() != null && getIsbn().equals(book.getIsbn());
    }

    @Override
    public int hashCode() {
        return getIsbn() != null ? getIsbn().hashCode() : 0;
    }


}