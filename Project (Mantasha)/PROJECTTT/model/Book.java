package model;

public class Book {
    private int bookId;
    private String title;
    private String author;
    private String publisher;
    private int year;
    private int totalCopies;
    private int availiableCopies;

    public Book(int bookId, String title, String author, String publisher, int year, int totalCopies) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
        this.totalCopies = totalCopies;
        this.availiableCopies = totalCopies;
    }

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public int getTotalCopies() {
        return totalCopies;
    }

    public int getAvailableCopies() {
        return availiableCopies;
    }

    public void increaseCopies() {
        availiableCopies++;
    }

    public void decreaseCopies() {
        if (availiableCopies > 0) availiableCopies--;
    }

    public String fullDetails() {
        return String.format(
                "Book ID: %s | Title: %s | Author: %s | Publisher: %s | Year: %d | Copies: %d",
                bookId, title, author, publisher, year, availiableCopies + "/" + totalCopies
        );
    }
}