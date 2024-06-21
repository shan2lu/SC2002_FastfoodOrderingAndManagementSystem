import java.util.*;
/**
 * Represents a list of orders placed by different customers.
 */
public class OrderList {
	private ArrayList<NewOrder> orderList;
	/**
     * Constructs a new OrderList object and initializes an empty ArrayList, each branch will have one.
     */
	public OrderList() {
		orderList = new ArrayList<>(); // Initialise the list
	}
	/**
     * Retrieves all orders.
     *
     * @return The ArrayList of orders.
     */
	public ArrayList<NewOrder> getAllOrderItems() { //getter
		return orderList;
	}
	/**
     * Adds a new order to the order list.
     *
     * @param order The order to be added to the list.
     */
	public void addOrderToList(NewOrder order) {
		orderList.add(order);
	}
	/**
     * Sets the order list to a new order list.
     *
     * @param orderList The new ArrayList of orders.
     */
	public void setOrderList(ArrayList<NewOrder> orderList) { //setter
		this.orderList = orderList;
	}
	/**
     * Displays all the orders in the order list.
     * If the order list is empty, it prints a message indicating empty order list.
     */
	public void displayOrder() {	
		if(orderList == null || orderList.isEmpty()) {
			System.out.println("The order list is empty");
		}else {
			for(NewOrder order: orderList) {
				System.out.println(order); 
			}
		}
	}
	 /**
     * Retrieves the details of a particular order based on the order ID.
     *
     * @param orderId The unique id for a order.
     * @return The list of menu items for the order with the given ID, or null if the order is not found.
     */
	public List<MenuItem> viewParticularOrder(int orderId) { //get orderId to print list
		for(NewOrder order:orderList) {
			if(order.getOrderID() == orderId) { //implement in NewOrder
				return order.getOrderDetails();
			}
		}
		return null; //order not found
	}
	/**
     * Updates the status of a particular order based on the order ID.
     * Prompts the user (usually the staff) to enter the new status and updates the order accordingly.
     *
     * @param orderId The unique identifier of the order.
     */
	public void updateOrderStatus(int orderId) {
		Scanner sc = new Scanner(System.in);
		for(NewOrder order:orderList) {
			if(order.getOrderID() == orderId) { 
			    System.out.print("Enter new status (ORDER_RECEIVED, PREPARING, READY_FOR_COLLECTION, COLLECTED): ");
			    String newStatusStr = sc.next();
			    OrderStatus newStatus = OrderStatus.valueOf(newStatusStr.toUpperCase());
				order.updateOrderStatus(newStatus);
			}
	    }
    }
	
	
}
