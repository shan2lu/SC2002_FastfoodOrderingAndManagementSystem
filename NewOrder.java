import java.util.ArrayList; //to implement dynamic arrays
import java.util.List;
import java.util.Scanner;
/**
 * Represents a new order placed by a customer.
 */
public class NewOrder {
	private OrderStatus StatusOfOrder;
	private ArrayList<MenuItem> OrderedItems;
	private int orderID;
	
	/**
     * Constructs a new NewOrder object with the given list of menu items.
     *
     * @param list The list of menu items ordered by the customer.
     */
	public NewOrder(ArrayList<MenuItem> list) {
		this.OrderedItems = list;
		StatusOfOrder = OrderStatus.ORDER_RECEIVED;
		OrderID gettingID = new OrderID();
		orderID = gettingID.generateOrderId();
	}
	/**
     * Updates the status of the order.
     *
     * @param newStatus The new status of the order.
     */
	public void updateOrderStatus(OrderStatus newStatus) {
        this.StatusOfOrder = newStatus;
    }
	 /**
     * Retrieves the current status of the order.
     *
     * @return The current status of the order.
     */
    public OrderStatus getStatusOfOrder() {
        return StatusOfOrder;
    }
    /**
     * Sets the status of the order.
     *
     * @param s The new status of the order.
     */

    public void setStatusOfOrder(OrderStatus s) {  //Customer can use, staff can also use
    	StatusOfOrder = s;
    }
    /**
     * Retrieves the list of menu items in the order.
     *
     * @return The list of menu items in the order.
     */
	public ArrayList<MenuItem> getOrderDetails() {
		return OrderedItems;
	}
	/**
     * Retrieves the unique id of the order.
     *
     * @return The unique id of the order.
     */
	public int getOrderID() {
		return orderID;
	} 
	/**
     * Sets the unique id of a order.
    *
    * @param id The new unique id for the order.
    */
	
	public void setOrderID(int id) {
		this.orderID = id;
	}
	


}