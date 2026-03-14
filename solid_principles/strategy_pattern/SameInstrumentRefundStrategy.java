package strategy_pattern;

public class SameInstrumentRefundStrategy implements RefundStrategy {

    @Override
    public void doRefund() {
        System.out.println("Refund processed using the same instrument.");
    }
    
}
