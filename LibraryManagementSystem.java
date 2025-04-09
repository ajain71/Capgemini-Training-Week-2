
// Interface Reservable
interface Reservable {
    void reserveItem(String borrowerName);
    boolean checkAvailability();
}

// Abstract class LibraryItem
abstract class LibraryItem {
    private String itemId;
    private String title;
    private String author;
    private String borrower; // sensitive info

    // Constructor
    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
        this.borrower = null; // not borrowed initially
    }

    // Getters
    public String getItemId() {
        return itemId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    protected String getBorrower() {
        return borrower;
    }

    protected void setBorrower(String borrower) {
        this.borrower = borrower;
    }

    // Abstract Method
    public abstract int getLoanDuration(); // in days

    // Concrete Method
    public void getItemDetails() {
        System.out.println("Item ID: " + itemId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Loan Duration: " + getLoanDuration() + " days");
        if (borrower != null) {
            System.out.println("Currently borrowed by: " + borrower);
        }
    }
}

// Book subclass
class Book extends LibraryItem implements Reservable {
    private boolean available;

    public Book(String itemId, String title, String author) {
        super(itemId, title, author);
        this.available = true;
    }

    @Override
    public int getLoanDuration() {
        return 14; // 2 weeks
    }

    @Override
    public void reserveItem(String borrowerName) {
        if (available) {
            setBorrower(borrowerName);
            available = false;
            System.out.println("Book \"" + getTitle() + "\" reserved by " + borrowerName);
        } else {
            System.out.println("Book \"" + getTitle() + "\" is currently unavailable.");
        }
    }

    @Override
    public boolean checkAvailability() {
        return available;
    }
}

// Magazine subclass
class Magazine extends LibraryItem {
    public Magazine(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 7; // 1 week
    }
}

// DVD subclass
class DVD extends LibraryItem implements Reservable {
    private boolean available;

    public DVD(String itemId, String title, String author) {
        super(itemId, title, author);
        this.available = true;
    }

    @Override
    public int getLoanDuration() {
        return 3; // 3 days
    }

    @Override
    public void reserveItem(String borrowerName) {
        if (available) {
            setBorrower(borrowerName);
            available = false;
            System.out.println("DVD \"" + getTitle() + "\" reserved by " + borrowerName);
        } else {
            System.out.println("DVD \"" + getTitle() + "\" is currently unavailable.");
        }
    }

    @Override
    public boolean checkAvailability() {
        return available;
    }
}

// Main class to demonstrate system
public class LibraryManagementSystem {
    public static void main(String[] args) {
        LibraryItem item1 = new Book("B101", "Java Fundamentals", "John Doe");
        LibraryItem item2 = new Magazine("M202", "National Geographic", "NatGeo Team");
        LibraryItem item3 = new DVD("D303", "Inception", "Christopher Nolan");

        LibraryItem[] items = { item1, item2, item3 };

        System.out.println("Library Item Details:");
        for (LibraryItem item : items) {
            item.getItemDetails();
            System.out.println("-------------------------");
        }

        System.out.println("Reservation Attempts:");
        for (LibraryItem item : items) {
            if (item instanceof Reservable) {
                ((Reservable) item).reserveItem("Alice");
            }
        }

        System.out.println("\nRechecking Availability:");
        for (LibraryItem item : items) {
            item.getItemDetails();
            System.out.println("-------------------------");
        }
    }
}

