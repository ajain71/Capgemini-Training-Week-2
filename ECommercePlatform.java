
// Taxable interface
interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

// Abstract Product class
abstract class Product {
    private int productId;
    private String name;
    private double price;

    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    // Encapsulated Getters and Setters
    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Abstract method
    public abstract double calculateDiscount();
    
    // Final price calculator
    public double calculateFinalPrice() {
        double tax = (this instanceof Taxable) ? ((Taxable) this).calculateTax() : 0.0;
        double discount = calculateDiscount();
        return price + tax - discount;
    }

    public void displayDetails() {
        System.out.println("Product ID: " + productId);
        System.out.println("Name: " + name);
        System.out.println("Price: $" + price);
        System.out.println("Discount: $" + calculateDiscount());
        if (this instanceof Taxable) {
            System.out.println("Tax: $" + ((Taxable) this).calculateTax());
            System.out.println("Tax Details: " + ((Taxable) this).getTaxDetails());
        }
        System.out.println("Final Price: $" + calculateFinalPrice());
        System.out.println("----------------------------");
    }
}

// Electronics class
class Electronics extends Product implements Taxable {
    public Electronics(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.10; // 10% discount
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.18; // 18% GST
    }

    @Override
    public String getTaxDetails() {
        return "18% GST on electronics";
    }
}

// Clothing class
class Clothing extends Product implements Taxable {
    public Clothing(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.20; // 20% discount
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.05; // 5% tax
    }

    @Override
    public String getTaxDetails() {
        return "5% tax on clothing";
    }
}

// Groceries class
class Groceries extends Product {
    public Groceries(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.05; // 5% discount
    }

    // No tax implemented (non-taxable)
}

public class ECommercePlatform {
    public static void main(String[] args) {
        Product p1 = new Electronics(201, "Smartphone", 50000);
        Product p2 = new Clothing(202, "Jacket", 3000);
        Product p3 = new Groceries(203, "Organic Rice", 1200);

        Product[] cart = { p1, p2, p3 };

        for (Product product : cart) {
            product.displayDetails();
        }
    }
}

