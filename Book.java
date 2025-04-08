class Book {
    // Static variable shared across all books
    private static String libraryName = "City Library";
    
    // Instance variables
    private String title;
    private String author;
    private final String isbn; // Final variable to ensure immutability
    
    // Constructor using 'this' to initialize instance variables
    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }
    
    // Static method to display library name
    public static void displayLibraryName() {
        System.out.println("Library Name: " + libraryName);
    }
    
    // Method to display book details
    public void displayBookDetails() {
        if (this instanceof Book) { // Using instanceof to verify the object type
            System.out.println("Title: " + title);
            System.out.println("Author: " + author);
            System.out.println("ISBN: " + isbn);
        } else {
            System.out.println("Invalid object!");
        }
    }
    
    public static void main(String[] args) {
        // Display library name using static method
        Book.displayLibraryName();
        
        // Creating book objects
        Book book1 = new Book("Effective Java", "Joshua Bloch", "978-0134685991");
        Book book2 = new Book("Clean Code", "Robert C. Martin", "978-0132350884");
        
        // Display book details
        book1.displayBookDetails();
        book2.displayBookDetails();
    }
}

