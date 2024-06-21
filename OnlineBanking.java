/**
 * Represents the online banking payment method.
 */
public class OnlineBanking extends PaymentMethod {
	private String paymentName = "";
	/**
	    * Constructs an OnlineBanking object with the given name.
	    *
	    * @param name The name of the online banking payment method.
	    */

	public OnlineBanking(String name) {
		paymentName = name;
	}
	/**
     * Processes a online banking payment for the given amount.
     *
     * @param amount The amount to be paid.
     * @return true if the payment is processed successfully, false otherwise. In this case, always successful.
     */
	public boolean processPayment(double amount) {
		System.out.println("payment of $" + String.format("%.2f", amount) + " processed successfully");
		System.out.println("Payment transferred successfully!");
		return true;
	}
	/**
	    * Returns the name of the online banking payment method.
	    *
	    * @return The name of the online banking payment method.
	    */
	public String getName() {
		return paymentName;
	}
}
