package isp.example1.betterCode;

public class AmexCreditCard extends CreditCard {

	@Override
	public void onlinePayment() {
		// Implementation for Amex online payment
		System.out.println("Amex online payment processed.");
	}

	@Override
	public void tapAndPay() {
		// Implementation for Amex tap and pay
		System.out.println("Amex tap and pay processed.");
	}

	@Override
	public void swipeAndPay() {
		// Implementation for Amex swipe and pay
		System.out.println("Amex swipe and pay processed.");
	}
}
