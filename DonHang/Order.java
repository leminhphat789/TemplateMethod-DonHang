import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Order {
    private final List<OrderItem> items;
    private final String receivingInfo;

    public Order(List<OrderItem> items, String receivingInfo) {
        this.items = new ArrayList<>(items);
        this.receivingInfo = receivingInfo;
    }

    public List<OrderItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    public String getReceivingInfo() {
        return receivingInfo;
    }
}
