public class StorePickupProcessor extends OrderProcessor {
    @Override
    protected void validateReceivingInfo(Order order) {
        if (order.getReceivingInfo() == null || !order.getReceivingInfo().matches("CH[0-9]{2}")) {
            throw new IllegalArgumentException("Ma cua hang phai co dang CH01.");
        }
    }

    @Override
    protected long calculateFee() {
        return 0;
    }

    @Override
    protected String instructions(Order order) {
        return "Den quay nhan hang cua cua hang " + order.getReceivingInfo() + ".";
    }
}
