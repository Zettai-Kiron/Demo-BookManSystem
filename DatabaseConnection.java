// package service;

// import dao.BookDAO;
// import model.Book;
// import java.util.List;

// public class DatabaseConnection {
//     private BookDAO bookDAO;

//     public DatabaseConnection() {
//         this.bookDAO = new BookDAO();
//     }

//     public List<Book> getAllBooks() {
//         return bookDAO.getAllBooks();
//     }

//     public void addBook(Book book) {
//         bookDAO.addBook(book);
//     }

//     public void updateBook(Book book) {
//         bookDAO.updateBook(book);
//     }

//     public void deleteBook(String isbn) {
//         bookDAO.deleteBook(isbn);
//     }

//     public Book findBookByISBN(String isbn) {
//         return bookDAO.findBookByISBN(isbn);
//     }
// }


// Changed the class name to databaseconnection


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:sqlserver://localhost;databaseName=BookManagement";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

