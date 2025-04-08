class Product {
    private static double discount = 10.0;
    private String productName;
    private double price;
    private int quantity;
    private final int productID;
    
    public Product(String productName, double price, int quantity, int productID) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.productID = productID;
    }
    
    public static void updateDiscount(double newDiscount) {
        discount = newDiscount;
    }
    
    public void displayProductDetails() {
        if (this instanceof Product) {
            System.out.println("Product Name: " + productName);
            System.out.println("Product ID: " + productID);
            System.out.println("Price: $" + price);
            System.out.println("Quantity: " + quantity);
            System.out.println("Discount: " + discount + "%");
        } else {
            System.out.println("Invalid object!");
        }
    }
    
    public static void main(String[] args) {
        Product prod1 = new Product("Laptop", 1200.50, 2, 101);
        Product prod2 = new Product("Smartphone", 800.75, 1, 102);
        
        prod1.displayProductDetails();
        prod2.displayProductDetails();
        
        updateDiscount(15.0);
        System.out.println("Updated Discount: " + discount + "%");
    }
}

