public class HomeDeliveryProcessor extends OrderProcessor {
    @Override
    protected void validateReceivingInfo(Order order) {
        if (order.getReceivingInfo() == null || order.getReceivingInfo().trim().isEmpty()) {
            throw new IllegalArgumentException("Thieu dia chi giao hang.");
        }
    }

    @Override
    protected long calculateFee() {
        return 20000;
    }

    @Override
    protected String instructions(Order order) {
        return "Giao tan noi tai " + order.getReceivingInfo() + ".";
    }
}
