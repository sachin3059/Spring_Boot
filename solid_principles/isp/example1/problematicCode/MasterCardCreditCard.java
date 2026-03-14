package isp.example1.problematicCode;

public class MasterCardCreditCard extends CreditCard {
    
    @Override
    public void swipeAndPay() {
        System.out.println("Swiping MasterCard and making payment...");
    }

    @Override
    public void doRefund() {
        System.out.println("Processing refund for MasterCard...");
    }

    @Override
    public void onlinePayment() {
        System.out.println("Making online payment with MasterCard...");
    }

    @Override
    public void tapAndPay() {
        System.out.println("Tapping MasterCard for payment...");
    }

    @Override
    public void upiPayment() {
        throw new UnsupportedOperationException("UPI payment is not supported by MasterCard cards.");
    }

    @Override
    public void internationalPayment() {
        System.out.println("Processing international payment with MasterCard...");
    }
}
