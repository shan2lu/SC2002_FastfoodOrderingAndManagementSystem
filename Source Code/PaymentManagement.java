import java.util.ArrayList;
/**
 * Manages the payment methods for the fast food store.
 */

public class PaymentManagement {
	private ArrayList<PaymentMethod> paymentMethod;
	/**
     * Constructs a new PaymentManagement object and initializes the list.
     */
	public PaymentManagement() {
		this.paymentMethod = new ArrayList<>();
		initialisePm();
	}
	 /**
     * Initializes the list of payment methods with already available options .
     */
	public void initialisePm() {
		OnlineBanking ob = new OnlineBanking("Paynow");
		paymentMethod.add(ob);
		Cash c = new Cash("Cash");
		paymentMethod.add(c);
		CreditCard cc = new CreditCard("Visa");
		paymentMethod.add(cc);
	}
	 /**
     * Adds a new payment method to the list.
     *
     * @param payment The payment method to be added.
     */
	public void addPaymentMethod(PaymentMethod payment) {
		paymentMethod.add(payment);
		System.out.println(payment.getClass().getSimpleName() + " method added");
	}
	/**
     * Removes a payment method from the list.
     *
     * @param payment The payment method to be removed.
     */
	public void removePaymentMethod(int choice) {
		if(choice > 0 && choice <= paymentMethod.size()) {
			paymentMethod.remove(choice-1);
			System.out.println("Payment Method Removed!");
		}
		else {
			paymentMethod.remove(choice-1);
			System.out.println("Invalid Choice!");
		}
	}
	 /**
     * Displays the available payment methods for customer to choose or for admin to see.
     */
	public void displayPaymentMethods() {
		System.out.println("Available payment methods:");
		int j=1;
		for (PaymentMethod payment: paymentMethod) {
			System.out.println(j+")"+payment.getName());
			j++;
		}
	}
	/**
     * Retrieves the list of all available payment methods.
     *
     * @return The list of payment methods.
     */

	public ArrayList<PaymentMethod> getAllPayment() {
		return paymentMethod;
	}
}