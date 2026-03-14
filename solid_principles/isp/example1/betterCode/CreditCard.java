package isp.example1.betterCode;

public abstract class CreditCard {
    private String cardNumber;
    private String cardHolderName;
    private String expiryDate;
    private int cvv;


    public abstract void swipeAndPay();
    public abstract void onlinePayment();
    public abstract void tapAndPay();



    // getters and setters
}
