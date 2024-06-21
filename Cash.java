/**
 * Represents the cash payment method.
 */
public class Cash extends PaymentMethod {
	private String paymentName = "";
	/**
	    * Constructs a Cash object with the given name.
	    *
	    * @param name The name of the cash payment method.
	    */
	public Cash(String name) {
		this.paymentName = name;
	}
	
	/**
     * Processes a cash payment for the given amount.
     *
     * @param amount The amount to be paid.
     * @return true if the payment is processed successfully, false otherwise. In this case, always successful.
     */
	public boolean processPayment(double amount) {
		System.out.println("Cash payment of $" + String.format("%.2f", amount) + " processed successfully");
		return true;
	}
	//getter
	public String getName() {
		return paymentName;
	}

}
