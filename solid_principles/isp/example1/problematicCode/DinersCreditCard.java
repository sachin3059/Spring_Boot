package isp.example1.problematicCode;

public class DinersCreditCard extends CreditCard {

    @Override
    public void swipeAndPay() {
        System.out.println("Swiping Diners Credit Card and making payment...");
    }

    @Override
    public void doRefund() {
        System.out.println("Processing refund for Diners Credit Card...");
    }

    @Override
    public void onlinePayment() {
        System.out.println("Making online payment using Diners Credit Card...");
    }

    @Override
    public void tapAndPay() {
        System.out.println("Tapping Diners Credit Card and making payment...");
    }

    @Override
    public void upiPayment() {
        // This method is not applicable for Diners Credit Card, but we are forced to implement it due to the interface design.
        throw new UnsupportedOperationException("UPI payment is not supported by Diners Credit Card.");
    }

    @Override
    public void internationalPayment() {
        System.out.println("Making international payment using Diners Credit Card...");
    }
    
}
