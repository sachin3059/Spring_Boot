package isp.example1.problematicCode;

public class AmexCreditCard extends CreditCard {
    
    @Override
    public void swipeAndPay() {
        System.out.println("Swiping Amex card and making payment...");
    }

    @Override
    public void doRefund() {
        System.out.println("Processing refund for Amex card...");
    }

    @Override
    public void onlinePayment() {
        System.out.println("Making online payment with Amex card...");
    }

    @Override
    public void tapAndPay() {
        System.out.println("Tapping Amex card for payment...");
    }

    @Override
    public void upiPayment() {
        throw new UnsupportedOperationException("UPI payment is not supported by Amex cards.");
    }

    @Override
    public void internationalPayment() {
        // This method is not applicable for Amex cards, but we are forced to implement it due to the interface design.
        throw new UnsupportedOperationException("International payment is not supported by Amex cards.");
    }
}