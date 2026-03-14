package isp.example1.problematicCode;

public abstract class CreditCard {
    private String cardNumber;
    private String cardHolderName;
    private String expiryDate;
    private int cvv;


    public abstract void swipeAndPay();
    public abstract void doRefund();
    public abstract void onlinePayment();
    public abstract void tapAndPay();
    public abstract void upiPayment();
    public abstract void internationalPayment();


    // getters and setters
}
