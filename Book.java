// package model;

// public class Book {
//     private String title;
//     private String author;
//     private String isbn;
//     private double price;

//     public Book(String title, String author, String isbn, double price) {
//         this.title = title;
//         this.author = author;
//         this.isbn = isbn;
//         this.price = price;
//     }

//     public String getTitle() {
//         return title;
//     }

//     public void setTitle(String title) {
//         this.title = title;
//     }

//     public String getAuthor() {
//         return author;
//     }

//     public void setAuthor(String author) {
//         this.author = author;
//     }

//     public String getIsbn() {
//         return isbn;
//     }

//     public void setIsbn(String isbn) {
//         this.isbn = isbn;
//     }

//     public double getPrice() {
//         return price;
//     }

//     public void setPrice(double price) {
//         this.price = price;
//     }

//     @Override
//     public String toString() {
//         return "Book{" +
//                 "title='" + title + '\'' +
//                 ", author='" + author + '\'' +
//                 ", isbn='" + isbn + '\'' +
//                 ", price=" + price +
//                 '}';
//     }
// }


public class Book {
    private int id;
    private String title;
    private String author;
    private String genre;
    private int yearPublished;
    private String isbn;

    public Book() {
    }

    public Book(String title, String author, String genre, int yearPublished, String isbn) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.yearPublished = yearPublished;
        this.isbn = isbn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return String.format("ID: %d, Title: %s, Author: %s, Genre: %s, Year Published: %d, ISBN: %s",
                id, title, author, genre, yearPublished, isbn);
    }
}


