import java.util.LinkedList;

public class Book {
    private int isbn;
    private String title;
    private String author;
    private String genre;
    private boolean availability;
    private boolean reserved;
    private static LinkedList<Book> books = new LinkedList<>();

    public Book() {
    }

    public Book(int isbn, String title, String author, String genre, boolean availability, boolean reserved) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.availability = availability;
        this.reserved = reserved;
    }

    public Book(Book book) {
        this.isbn = book.isbn;
        this.title = book.title;
        this.author = book.author;
        this.genre = book.genre;
        this.availability = book.availability;
        this.reserved = book.reserved;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    public static LinkedList<Book> getBooks() {
        return books;
    }

    public static void setBooks(LinkedList<Book> books) {
        Book.books = books;
    }

    @Override
    public String toString() {
        return " Title: " + title + "ISBN: " + isbn + " Author: " + author + " Genre: " + genre;
    }
}