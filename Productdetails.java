
import java.util.Scanner;

class Productdetails {
    private String productName;
    private double price;
    private static int totalProducts = 0;

    // Constructor
    public Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
        totalProducts++;
    }

    // Instance method to display product details
    public void displayProductDetails() {
        System.out.println("Product Name: " + productName);
        System.out.println("Price: $" + price);
    }

    // Class method to display total number of products
    public static void displayTotalProducts() {
        System.out.println("Total Products Created: " + totalProducts);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter product name: ");
        String productName = scanner.nextLine();
        
        System.out.print("Enter product price: ");
        double price = scanner.nextDouble();
        
        Productdetails product = new Productdetails(productName, price);
        product.displayProductDetails();
        Productdetails.displayTotalProducts();
        
        scanner.close();
    }
}

