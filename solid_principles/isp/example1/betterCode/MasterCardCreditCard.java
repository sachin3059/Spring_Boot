package isp.example1.betterCode;

public class MasterCardCreditCard extends CreditCard implements RefundCapatibleCreditCard {

	@Override
	public void onlinePayment() {
		// Implementation for online payment using MasterCard
		System.out.println("MasterCard: Online payment processed.");
	}

	@Override
	public void tapAndPay() {
		// Implementation for tap and pay using MasterCard
		System.out.println("MasterCard: Tap and pay processed.");
	}

	@Override
	public void swipeAndPay() {
		// Implementation for swipe and pay using MasterCard
		System.out.println("MasterCard: Swipe and pay processed.");
	}

	@Override
	public void doRefund() {
		// Implementation for refund using MasterCard
		System.out.println("MasterCard: Refund processed.");
	}
}
