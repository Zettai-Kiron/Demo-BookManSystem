// package main;

// import gui.BookManagementGUI;

// public class Main {
//     public static void main(String[] args) {
//         BookManagementGUI gui = new BookManagementGUI();
//         gui.setVisible(true);
//     }
// }





import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final BookDAO bookDAO = new BookDAO();

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. List all books");
            System.out.println("2. Add a book");
            System.out.println("3. Update a book");
            System.out.println("4. Delete a book");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // consume the newline

            switch (option) {
                case 1:
                    listAllBooks();
                    break;
                case 2:
                    addBook();
                    break;
                case 3:
                    updateBook();
                    break;
                case 4:
                    deleteBook();
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void listAllBooks() {
        try {
            List<Book> books = bookDAO.getAllBooks();
            for (Book book : books) {
                System.out.println(book);
            }
        } catch (Exception e) {
            System.err.println("Error listing books: " + e.getMessage());
        }
    }

    private static void addBook() {
        System.out.print("Title: ");
        String title = scanner.nextLine();
        System.out.print("Author: ");
        String author = scanner.nextLine();
        System.out.print("Genre: ");
        String genre = scanner.nextLine();
        System.out.print("Year Published: ");
        int yearPublished = scanner.nextInt();
        scanner.nextLine(); // consume the newline
        System.out.print("ISBN: ");
        String isbn = scanner.nextLine();

        Book book = new Book(title, author, genre, yearPublished, isbn);
        try {
            bookDAO.addBook(book);
            System.out.println("Book added successfully.");
        } catch (Exception e) {
            System.err.println("Error adding book: " + e.getMessage());
        }
    }

    private static void updateBook() {
        System.out.print("Enter the ID of the book to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume the newline

        try {
            Book book = bookDAO.getBookById(id);
            if (book == null) {
                System.out.println("Book not found.");
                return;
            }

            System.out.print("Title (" + book.getTitle() + "): ");
            String title = scanner.nextLine();
            System.out.print("Author (" + book.getAuthor() + "): ");
            String author = scanner.nextLine();
            System.out.print("Genre (" + book.getGenre() + "): ");
            String genre = scanner.nextLine();
            System.out.print("Year Published (" + book.getYearPublished() + "): ");
            int yearPublished = scanner.nextInt();
            scanner.nextLine(); // consume the newline
            System.out.print("ISBN (" + book.getIsbn() + "): ");
            String isbn = scanner.nextLine();

            book.setTitle(title.isEmpty() ? book.getTitle() : title);
            book.setAuthor(author.isEmpty() ? book.getAuthor() : author);
            book.setGenre(genre.isEmpty() ? book.getGenre() : genre);
            book.setYearPublished(yearPublished == 0 ? book.getYearPublished() : yearPublished);
            book.setIsbn(isbn.isEmpty() ? book.getIsbn() : isbn);

            bookDAO.updateBook(book);
            System.out.println("Book updated successfully.");
        } catch (Exception e) {
            System.err.println("Error updating book: " + e.getMessage());
        }
    }

    private static void deleteBook() {
        System.out.print("Enter the ID of the book to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume the newline

        try {
            bookDAO.deleteBook(id);
            System.out.println("Book deleted successfully.");
        } catch (Exception e) {
            System.err.println("Error deleting book: " + e.getMessage());
        }
    }
}
