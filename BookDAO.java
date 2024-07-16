// package dao;

// import model.Book;
// import java.util.ArrayList;
// import java.util.List;

// public class BookDAO {
//     private List<Book> books;

//     public BookDAO() {
//         this.books = new ArrayList<>();
//     }

//     public List<Book> getAllBooks() {
//         return books;
//     }

//     public void addBook(Book book) {
//         books.add(book);
//     }

//     public void updateBook(Book updatedBook) {
//         for (Book book : books) {
//             if (book.getIsbn().equals(updatedBook.getIsbn())) {
//                 // Update book details
//                 book.setTitle(updatedBook.getTitle());
//                 book.setAuthor(updatedBook.getAuthor());
//                 book.setPrice(updatedBook.getPrice());
//                 return;
//             }
//         }
//     }

//     public void deleteBook(String isbn) {
//         books.removeIf(book -> book.getIsbn().equals(isbn));
//     }

//     public Book findBookByISBN(String isbn) {
//         for (Book book : books) {
//             if (book.getIsbn().equals(isbn)) {
//                 return book;
//             }
//         }
//         return null; // Book not found
//     }
// }

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    public List<Book> getAllBooks() throws SQLException {
        List<Book> books = new ArrayList<>();
        String sql = "SELECT * FROM Books";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Book book = new Book();
                book.setId(rs.getInt("Id"));
                book.setTitle(rs.getString("Title"));
                book.setAuthor(rs.getString("Author"));
                book.setGenre(rs.getString("Genre"));
                book.setYearPublished(rs.getInt("YearPublished"));
                book.setIsbn(rs.getString("ISBN"));
                books.add(book);
            }
        }

        return books;
    }

    public Book getBookById(int id) throws SQLException {
        Book book = null;
        String sql = "SELECT * FROM Books WHERE Id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    book = new Book();
                    book.setId(rs.getInt("Id"));
                    book.setTitle(rs.getString("Title"));
                    book.setAuthor(rs.getString("Author"));
                    book.setGenre(rs.getString("Genre"));
                    book.setYearPublished(rs.getInt("YearPublished"));
                    book.setIsbn(rs.getString("ISBN"));
                }
            }
        }

        return book;
    }

    public void addBook(Book book) throws SQLException {
        String sql = "INSERT INTO Books (Title, Author, Genre, YearPublished, ISBN) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, book.getTitle());
            stmt.setString(2, book.getAuthor());
            stmt.setString(3, book.getGenre());
            stmt.setInt(4, book.getYearPublished());
            stmt.setString(5, book.getIsbn());
            stmt.executeUpdate();
        }
    }

    public void updateBook(Book book) throws SQLException {
        String sql = "UPDATE Books SET Title = ?, Author = ?, Genre = ?, YearPublished = ?, ISBN = ? WHERE Id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, book.getTitle());
            stmt.setString(2, book.getAuthor());
            stmt.setString(3, book.getGenre());
            stmt.setInt(4, book.getYearPublished());
            stmt.setString(5, book.getIsbn());
            stmt.setInt(6, book.getId());
            stmt.executeUpdate();
        }
    }

    public void deleteBook(int id) throws SQLException {
        String sql = "DELETE FROM Books WHERE Id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
