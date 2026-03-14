package strategy_pattern;

public class MasterCardCreditCard extends CreditCard implements RefundCapatibleCreditCard {
	private String cardNumber;
	private String cardHolderName;
	private String expiryDate;
	private int cvv;

	private RefundStrategy refundStrategy;

	public MasterCardCreditCard(RefundStrategy refundStrategy) {
		this.refundStrategy = refundStrategy;
	}


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
		this.refundStrategy.doRefund();
	}
}
