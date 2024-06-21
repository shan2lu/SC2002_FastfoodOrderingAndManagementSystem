/**
 * Represents the credit card payment method.
 */
class CreditCard extends PaymentMethod {
	private String paymentName = "";
	/**
	    * Constructs a CreditCard object with the given name.
	    *
	    * @param name The name of the cash payment method.
	    */
	public CreditCard(String name) {
		this.paymentName = name;
	}
	/**
     * Processes a credit card payment for the given amount.
     *
     * @param amount The amount to be paid.
     * @return true if the payment is processed successfully, false otherwise.
     */
	public boolean processPayment(double amount) {
		System.out.println("Transaction approved!");
		System.out.println("Credit card payment of $" + String.format("%.2f", amount) + " processed successfully");
		return true;
	}
	
	public String getName() {
		return paymentName;
	}
}