public class OrderItem {
    private final String name;
    private final long unitPrice;
    private final int quantity;

    public OrderItem(String name, long unitPrice, int quantity) {
        this.name = name;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public long getUnitPrice() {
        return unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public long amount() {
        if (name == null || name.trim().isEmpty() || unitPrice < 0 || quantity <= 0) {
            throw new IllegalArgumentException("Dong san pham khong hop le.");
        }
        return Math.multiplyExact(unitPrice, quantity);
    }
}
