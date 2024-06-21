/**
 * Class for generating unique order IDs.
 */
public class OrderID {
	private static int numOfOrders = 0;
	private int currentID;
	/**
     * Constructs an OrderID object.
     */
	public OrderID() {
		
	}/**
     * @return An Integer which is the order id
     */
	public int generateOrderId() {
		numOfOrders++;
		currentID = numOfOrders;
		return currentID;
	}
	
}
