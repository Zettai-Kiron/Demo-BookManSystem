package service;

import dao.BookDAO;
import model.Book;
import java.util.List;

public class BookService {
    private BookDAO bookDAO;

    public BookService() {
        this.bookDAO = new BookDAO();
    }

    public List<Book> getAllBooks() {
        return bookDAO.getAllBooks();
    }

    public void addBook(Book book) {
        bookDAO.addBook(book);
    }

    public void updateBook(Book book) {
        bookDAO.updateBook(book);
    }

    public void deleteBook(String isbn) {
        bookDAO.deleteBook(isbn);
    }

    public Book findBookByISBN(String isbn) {
        return bookDAO.findBookByISBN(isbn);
    }
}
