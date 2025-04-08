class CartItem {
    private String itemName;
    private double price;
    private int quantity;

    public CartItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public void addItem(int quantity) {
        this.quantity += quantity;
        System.out.println(quantity + " more " + itemName + "(s) added to the cart.");
    }

    public void removeItem(int quantity) {
        if (quantity <= this.quantity) {
            this.quantity -= quantity;
            System.out.println(quantity + " " + itemName + "(s) removed from the cart.");
        } else {
            System.out.println("Cannot remove more than available quantity.");
        }
    }

    public void displayTotalCost() {
        System.out.println("Total cost for " + itemName + ": $" + (price * quantity));
    }

    public static void main(String[] args) {
        CartItem item = new CartItem("Laptop", 999.99, 1);
        item.displayTotalCost();
        item.addItem(1);
        item.displayTotalCost();
        item.removeItem(1);
        item.displayTotalCost();
    }
}

