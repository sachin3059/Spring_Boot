package strategy_pattern;

public class BankAccountRefund implements RefundStrategy {

    @Override
    public void doRefund() {
        System.out.println("Refund processed using bank account.");
    }
    
}
