import java.util.ArrayList;
class Book {
    private String title;
    private String author;
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public void displayBookInfo() {
        System.out.println("Book: \"" + title + "\" by " + author);
    }
}
class Library {
    private String libraryName;
    private ArrayList<Book> books;
    public Library(String libraryName) {
        this.libraryName = libraryName;
        this.books = new ArrayList<>();
    }
    public void addBook(Book book) {
        books.add(book);
    }
    public void displayLibraryInfo() {
        System.out.println("Library: " + libraryName);
        System.out.println("Books in this Library:");
        for (Book book : books) {
            book.displayBookInfo();
        }
        System.out.println();
    }
}
public class LibrarySystem {
    public static void main(String[] args) {
        Book book1 = new Book("1984", "George Orwell");
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee");
        Book book3 = new Book("The Great Gatsby", "F. Scott Fitzgerald");
        Library library1 = new Library("City Library");
        Library library2 = new Library("University Library");
        library1.addBook(book1);
        library1.addBook(book2);
        library2.addBook(book2);
        library2.addBook(book3);
        library1.displayLibraryInfo();
        library2.displayLibraryInfo();
    }
}