class Order {
    protected String orderId;
    protected String orderDate;
    public Order(String orderId, String orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }
    public String getOrderStatus() {
        return "Order Placed";
    }
    public void displayOrderDetails() {
        System.out.println("Order ID: " + orderId + ", Order Date: " + orderDate + ", Status: " + getOrderStatus());
    }
}
class ShippedOrder extends Order {
    protected String trackingNumber;
    public ShippedOrder(String orderId, String orderDate, String trackingNumber) {
        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }
    @Override
    public String getOrderStatus() {
        return "Shipped (Tracking Number: " + trackingNumber + ")";
    }
}
class DeliveredOrder extends ShippedOrder {
    private String deliveryDate;
    public DeliveredOrder(String orderId, String orderDate, String trackingNumber, String deliveryDate) {
        super(orderId, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }
    @Override
    public String getOrderStatus() {
        return "Delivered on " + deliveryDate;
    }
}
public class OrderManagement {
    public static void main(String[] args) {
        Order order = new Order("O1001", "2025-03-25");
        order.displayOrderDetails();
        ShippedOrder shippedOrder = new ShippedOrder("O1002", "2025-03-24", "TN56789");
        shippedOrder.displayOrderDetails();
        DeliveredOrder deliveredOrder = new DeliveredOrder("O1003", "2025-03-23", "TN12345", "2025-03-26");
        deliveredOrder.displayOrderDetails();
    }
}