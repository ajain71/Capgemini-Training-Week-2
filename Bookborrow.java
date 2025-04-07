
import java.util.Scanner;

class Bookborrow {
    private String title;
    private String author;
    private double price;
    private boolean isAvailable;

    // Constructor
    public Book(String title, String author, double price, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.isAvailable = isAvailable;
    }

    // Method to borrow a book
    public void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Book successfully borrowed.");
        } else {
            System.out.println("Sorry, the book isn't available.");
        }
    }

    // Method to display book details
    public void displayBookDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: $" + price);
        System.out.println("Available: " + (isAvailable ? "Yes" : "No"));
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Example book details
        Bookborrow book = new Bookborrow("The Great Gatsby", "F. Scott Fitzgerald", 10.99, true);
        book.displayBookDetails();
        
        System.out.print("Is the book available? (true/false): ");
        boolean isAvailable = scanner.nextBoolean();
        
        if (isAvailable) {
            book.borrowBook();
        } else {
            System.out.println("Sorry, the book isn't available.");
        }
        
        scanner.close();
    }
}

