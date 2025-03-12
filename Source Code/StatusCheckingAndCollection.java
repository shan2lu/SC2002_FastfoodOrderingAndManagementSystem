import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * Class for checking the status of orders and handling order collection.
 */
public class StatusCheckingAndCollection{
	Branch selectedBranch;
	/**
    * Constructs a StatusCheckingAndCollection object with the specified selected branch.
    *
    * @param selectedBranch The selected branch for order checking and collection.
    */
	public StatusCheckingAndCollection(Branch selectedBranch) {
		this.selectedBranch = selectedBranch;
	}
	/**
     * Starts the process of checking the status of an order and handling order collection.
     *
     * @param Bm The branch management system containing the order information.
     */
	public void start(BranchManagement Bm) {
		Scanner sc = new Scanner(System.in);
		ArrayList<NewOrder> list = selectedBranch.getOrderList();
		System.out.println("Enter order id :");
		int orderID;
		orderID = sc.nextInt();
		
		while (orderID < 0) {
			System.out.println("Please enter the correct order ID");
			orderID = sc.nextInt();
		}
		
		OrderStatus state;
		for(NewOrder order: list) {
			if(order.getOrderID() == orderID) {
				state = order.getStatusOfOrder();
				if(state == OrderStatus.READY_FOR_COLLECTION) {
					System.out.println("Your order is ready for collection! 1)Collect now or 2)Collect later");
					int choice = sc.nextInt();
					if(choice == 1) {
						order.setStatusOfOrder(OrderStatus.COLLECTED);
					}
					else {
						return;
					}
				}
				else {
					System.out.println("Your order is "+state);
					return;
				}
			}
		}
		
	}
	
}
