package strategy_pattern;

public class VisaCreditCard extends CreditCard implements RefundCapatibleCreditCard {

	private String cardNumber;
	private String cardHolderName;
	private String expiryDate;
	private int cvv;

	private RefundStrategy refundStrategy;
	public VisaCreditCard(RefundStrategy refundStrategy) {
		this.refundStrategy = refundStrategy;
	}

	@Override
	public void doRefund() {
		// Implementation for Visa refund
		this.refundStrategy.doRefund();
	}

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
