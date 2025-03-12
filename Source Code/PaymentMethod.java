/**
 * An abstract class for different payment methods to extend
 */
public abstract class PaymentMethod {
	public abstract boolean processPayment(double amount);
	public abstract String getName();
}
