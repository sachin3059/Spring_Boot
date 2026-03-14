package isp.example1.betterCode;

public class VisaCreditCard extends CreditCard {

	@Override
	public void onlinePayment() {
		// Implementation for Visa online payment
		System.out.println("Visa Credit Card: Online payment processed.");
	}

	@Override
	public void tapAndPay() {
		// Implementation for Visa tap and pay
		System.out.println("Visa Credit Card: Tap and pay processed.");
	}

	@Override
	public void swipeAndPay() {
		// Implementation for Visa swipe and pay
		System.out.println("Visa Credit Card: Swipe and pay processed.");
	}
}
