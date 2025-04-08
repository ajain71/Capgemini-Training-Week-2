import java.util.*;

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class Order {
    private static int idCounter = 1;
    private int orderId;
    private List<Product> productList;

    public Order() {
        this.orderId = idCounter++;
        this.productList = new ArrayList<>();
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public void showOrderDetails() {
        System.out.println("Order ID: " + orderId);
        double total = 0;
        for (Product product : productList) {
            System.out.println("- " + product.getName() + " ($" + product.getPrice() + ")");
            total += product.getPrice();
        }
        System.out.println("Total: $" + total);
    }

    public int getOrderId() {
        return orderId;
    }
}

class Customer {
    private String name;
    private List<Order> orders;

    public Customer(String name) {
        this.name = name;
        this.orders = new ArrayList<>();
    }

    public void placeOrder(Order order) {
        orders.add(order);
    }

    public void showCustomerOrders() {
        System.out.println("Customer: " + name);
        for (Order order : orders) {
            order.showOrderDetails();
            System.out.println();
        }
    }

    public String getName() {
        return name;
    }
}

public class ECommercePlatformDemo {
    public static void main(String[] args) {
        Product p1 = new Product("Laptop", 1200.0);
        Product p2 = new Product("Mouse", 25.0);
        Product p3 = new Product("Keyboard", 45.0);

        Customer customer1 = new Customer("Alice");

        Order order1 = new Order();
        order1.addProduct(p1);
        order1.addProduct(p2);

        Order order2 = new Order();
        order2.addProduct(p3);

        customer1.placeOrder(order1);
        customer1.placeOrder(order2);

        customer1.showCustomerOrders();
    }
}