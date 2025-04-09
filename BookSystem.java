class Book {
    String title;
    int publicationYear;
    Book(String title, int publicationYear) {
        this.title = title;
        this.publicationYear = publicationYear;
    }
    void displayInfo() {
        System.out.println("Book Title: " + title);
        System.out.println("Publication Year: " + publicationYear);
    }
}
class Author extends Book {
    String name;
    String bio;
    Author(String title, int publicationYear, String name, String bio) {
        super(title, publicationYear);
        this.name = name;
        this.bio = bio;
    }
    void displayInfo() {
        super.displayInfo();
        System.out.println("Author Name: " + name);
        System.out.println("Bio: " + bio);
    }
}
public class BookSystem {
    public static void main(String[] args) {
        Author author = new Author("The Java Handbook", 2022, "John Doe", "Expert in Java programming.");
        author.displayInfo();
    }
}