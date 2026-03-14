package strategy_pattern;

public class RupayCreditCard extends CreditCard implements UpiCompatableCreditCard {

	@Override
	public void onlinePayment() {
		// Implementation for online payment
	}

	@Override
	public void tapAndPay() {
		// Implementation for tap and pay
	}

	@Override
	public void swipeAndPay() {
		// Implementation for swipe and pay
	}

	public void upiPayment() {
		// Implementation for UPI payment
	}
}
    