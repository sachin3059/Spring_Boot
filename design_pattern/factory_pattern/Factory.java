public class Factory {
    public static void main(String[] args) {
        PaymentProcessor payment1 = PaymentFactory.getPaymentProcessor("paypal");
        payment1.pay(100.0);

        PaymentProcessor payment2 = PaymentFactory.getPaymentProcessor("stripe");
        payment2.pay(200.0);
    }
}

// step1. Interface
interface PaymentProcessor{
    void pay(double amount);
}

// step2: Concrete implementations
class Paypal implements PaymentProcessor{
    public void pay(double amount){
        System.out.println("Paid " + amount + " using Paypal");
    }
}

class Stripe implements PaymentProcessor{
    public void pay(double amount){
        System.out.println("Paid " + amount + " using Stripe");
    }
}


// step3 : Factory
class PaymentFactory{
    public static PaymentProcessor getPaymentProcessor(String type){
        if(type.equals("Paypal")){
            return new Paypal();
        }
        else if(type.equals("Stripe")){
            return new Stripe();
        }
        throw new IllegalArgumentException("Invalid Payment type");
    }
}

// but PaymentFactory violates OCP principle.