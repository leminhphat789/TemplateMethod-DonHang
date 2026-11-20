import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<OrderItem> cart = new ArrayList<>();
        cart.add(new OrderItem("So tay", 50000, 2));
        cart.add(new OrderItem("Hop but", 50000, 1));

        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Giao tan noi    2. Nhan tai cua hang");
        System.out.print("Chon hinh thuc: ");
        String choice = scanner.nextLine().trim();
        scanner.close();

        OrderProcessor processor;
        Order order;
        if (choice.equals("1")) {
            processor = new HomeDeliveryProcessor();
            order = new Order(cart, "18 duong Hoa Mai");
        } else if (choice.equals("2")) {
            processor = new StorePickupProcessor();
            order = new Order(cart, "CH01");
        } else {
            System.out.println("Vui long chon 1 hoac 2.");
            return;
        }
        processor.processOrder(order);
    }
}
