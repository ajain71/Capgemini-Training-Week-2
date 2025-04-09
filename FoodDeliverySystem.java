
// Discountable Interface
interface Discountable {
    void applyDiscount(double percent);
    String getDiscountDetails();
}

// Abstract FoodItem class
abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    // Constructor
    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    // Encapsulated Getters
    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    // Abstract method
    public abstract double calculateTotalPrice();

    // Concrete method
    public void getItemDetails() {
        System.out.println("Item: " + itemName);
        System.out.println("Price: $" + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total Price: $" + calculateTotalPrice());
    }
}

// VegItem class
class VegItem extends FoodItem implements Discountable {
    private double discountPercent = 0;

    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        double total = getPrice() * getQuantity();
        return total - (total * discountPercent / 100);
    }

    @Override
    public void applyDiscount(double percent) {
        this.discountPercent = percent;
    }

    @Override
    public String getDiscountDetails() {
        return "Discount on Veg Item: " + discountPercent + "%";
    }
}

// NonVegItem class
class NonVegItem extends FoodItem implements Discountable {
    private double discountPercent = 0;
    private final double nonVegCharge = 1.5; // extra charge per item

    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        double base = (getPrice() + nonVegCharge) * getQuantity();
        return base - (base * discountPercent / 100);
    }

    @Override
    public void applyDiscount(double percent) {
        this.discountPercent = percent;
    }

    @Override
    public String getDiscountDetails() {
        return "Discount on Non-Veg Item: " + discountPercent + "%";
    }
}

// Main class to test the system
public class FoodDeliverySystem {
    // Polymorphic method to process all FoodItems
    public static void processOrder(FoodItem item) {
        item.getItemDetails();

        if (item instanceof Discountable) {
            Discountable d = (Discountable) item;
            System.out.println(d.getDiscountDetails());
        }

        System.out.println("-----------------------------------");
    }

    public static void main(String[] args) {
        FoodItem item1 = new VegItem("Paneer Butter Masala", 10.0, 2);
        FoodItem item2 = new NonVegItem("Chicken Biryani", 12.0, 1);
        FoodItem item3 = new VegItem("Veg Pulao", 8.0, 3);

        // Apply some discounts
        ((Discountable) item1).applyDiscount(10);
        ((Discountable) item2).applyDiscount(5);
        ((Discountable) item3).applyDiscount(15);

        // Process orders using polymorphism
        processOrder(item1);
        processOrder(item2);
        processOrder(item3);
    }
}

