package isp.example1.problematicCode;

public class VisaCreditCard extends CreditCard {

    @Override
    public void swipeAndPay() {
        System.out.println("Swiping Visa card and making payment...");
    }

    @Override
    public void doRefund() {
        System.out.println("Processing refund for Visa card...");
    }

    @Override
    public void onlinePayment() {
        System.out.println("Making online payment with Visa card...");
    }

    @Override
    public void tapAndPay() {
        System.out.println("Tapping Visa card for payment...");
    }

    @Override
    public void upiPayment() {
        throw new UnsupportedOperationException("UPI payment is not supported by Visa cards.");
    }

    @Override
    public void internationalPayment() {
        System.out.println("Processing international payment with Visa card...");
    }
    
}
