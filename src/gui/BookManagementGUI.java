package gui;

// import model.Book;
import service.BookService;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class BookManagementGUI extends JFrame {
    private BookService bookService;
    private JTextField isbnField, titleField, authorField, priceField;
    private JTextArea outputArea;

    public BookManagementGUI() {
        // Initialize your GUI components and setup
        initComponents();
    }

    private void initComponents() {
        // Add code to initialize all GUI components
        // For example:
        setTitle("Book Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null); // Center the window on the screen

        // Add more initialization code for your buttons, text fields, etc.
    }

    // public BookManagementGUI() {
    //     initializeGUI();  // Initialize your GUI components
    // }

    public BookManagementGUI(BookService bookService) {
        this.bookService = bookService;
        initializeGUI();
    }

    private void initializeGUI() {
        // GUI components setup (JFrame, JPanel, JLabels, JTextFields, JButtons, etc.)
        // Implement event listeners for buttons (add, update, delete, search)
        // Display books in JTextArea or JTable
    }

    // private void displayBooks() {
    //     List<Book> books = bookService.getAllBooks();
    //     // Display books in outputArea (JTextArea) or table
    // }

    public static void main(String[] args) {
        BookService bookService = new BookService();
        SwingUtilities.invokeLater(() -> {
            new BookManagementGUI(bookService).setVisible(true);
        });
    }
}
