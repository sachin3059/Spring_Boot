package isp.example1.problematicCode;

public class RupayCreditCard extends CreditCard {

    @Override
    public void swipeAndPay() {
        System.out.println("Swiping Rupay card and making payment...");
    }

    @Override
    public void doRefund() {
        System.out.println("Processing refund for Rupay card...");
    }

    @Override
    public void onlinePayment() {
        System.out.println("Making online payment with Rupay card...");
    }

    @Override
    public void tapAndPay() {
        System.out.println("Tapping Rupay card for payment...");
    }

    @Override
    public void upiPayment() {
        // This method is not applicable for Rupay cards, but we are forced to implement it due to the interface design.
        throw new UnsupportedOperationException("UPI payment is not supported for Rupay cards.");
    }

    @Override
    public void internationalPayment() {
        System.out.println("Making international payment with Rupay card...");
    }
    
}
