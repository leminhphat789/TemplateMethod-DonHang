import java.text.NumberFormat;
import java.util.Locale;

public abstract class OrderProcessor {
    public final long processOrder(Order order) {
        if (order == null || order.getItems().isEmpty()) {
            throw new IllegalArgumentException("Don hang phai co san pham.");
        }

        long subtotal = 0;
        for (OrderItem item : order.getItems()) {
            subtotal = Math.addExact(subtotal, item.amount());
        }
        validateReceivingInfo(order);
        long fee = calculateFee();
        long total = Math.addExact(subtotal, fee);

        for (OrderItem item : order.getItems()) {
            System.out.printf("%s: %d x %s%n", item.getName(), item.getQuantity(), money(item.getUnitPrice()));
        }
        System.out.println("Tien hang: " + money(subtotal));
        System.out.println("Phi giao/nhan: " + money(fee));
        System.out.println("Tong phai tra: " + money(total));
        System.out.println(instructions(order));
        System.out.println("Da xac nhan don hang.");
        return total;
    }

    private String money(long amount) {
        return NumberFormat.getIntegerInstance(Locale.forLanguageTag("vi-VN")).format(amount) + " dong";
    }

    protected abstract void validateReceivingInfo(Order order);
    protected abstract long calculateFee();
    protected abstract String instructions(Order order);
}
