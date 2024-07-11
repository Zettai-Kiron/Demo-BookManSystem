package dao;

import model.Book;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    private List<Book> books;

    public BookDAO() {
        this.books = new ArrayList<>();
    }

    public List<Book> getAllBooks() {
        return books;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void updateBook(Book updatedBook) {
        for (Book book : books) {
            if (book.getIsbn().equals(updatedBook.getIsbn())) {
                // Update book details
                book.setTitle(updatedBook.getTitle());
                book.setAuthor(updatedBook.getAuthor());
                book.setPrice(updatedBook.getPrice());
                return;
            }
        }
    }

    public void deleteBook(String isbn) {
        books.removeIf(book -> book.getIsbn().equals(isbn));
    }

    public Book findBookByISBN(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null; // Book not found
    }
}
