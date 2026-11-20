import java.util.ArrayList;

public class OrderProcessorTest {
    private static void checkTotal(OrderProcessor processor, Order order, long expected) {
        if (processor.processOrder(order) != expected) {
            throw new AssertionError("Sai tong tien.");
        }
    }

    private static void expectError(OrderProcessor processor, Order order, String message) {
        try {
            processor.processOrder(order);
        } catch (IllegalArgumentException error) {
            if (message.equals(error.getMessage())) {
                return;
            }
            throw new AssertionError("Sai thong bao loi.", error);
        }
        throw new AssertionError("Don khong hop le van duoc chap nhan.");
    }

    public static void main(String[] args) {
        ArrayList<OrderItem> cart = new ArrayList<>();
        cart.add(new OrderItem("So tay", 50000, 2));
        cart.add(new OrderItem("Hop but", 50000, 1));
        OrderProcessor delivery = new HomeDeliveryProcessor();
        OrderProcessor pickup = new StorePickupProcessor();
        checkTotal(delivery, new Order(cart, "18 duong Hoa Mai"), 170000);
        checkTotal(pickup, new Order(cart, "CH01"), 150000);
        expectError(delivery, new Order(new ArrayList<>(), "18 duong Hoa Mai"), "Don hang phai co san pham.");
        expectError(delivery, new Order(cart, " "), "Thieu dia chi giao hang.");
        expectError(pickup, new Order(cart, "01"), "Ma cua hang phai co dang CH01.");
        ArrayList<OrderItem> invalidCart = new ArrayList<>();
        invalidCart.add(new OrderItem("So", 50000, 0));
        expectError(pickup, new Order(invalidCart, "CH01"),
            "Dong san pham khong hop le.");
        System.out.println("Dat 6/6 truong hop kiem thu.");
    }
}
