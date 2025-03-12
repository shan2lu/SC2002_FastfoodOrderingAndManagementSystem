import java.util.ArrayList;
import java.util.Scanner;
/**
 * Represents a normal staff member.
 */
public class NormalStaff {
	private String name;
	private int age;
	private String gender;
	private String un;
	
	/**
     * Starts the operations for a normal staff member.
     * 
     * @param Br The branch associated with the staff member.
     */
	public void start(Branch Br) {
		Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1. View all orders");
            System.out.println("2. View particular orders");
            System.out.println("3. Process order");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    displayOrder(Br);
                    break;
                case 2:
                    viewParticularOrder(Br);
                    break;
                case 3:
                    System.out.println("Enter order ID");
                    int OrderId=sc.nextInt();
                    selectOrderToProcess(OrderId,Br);
                    break;
                case 4:
                    System.out.println("Exiting....");
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 4.");
            }
        } while (choice != 4);

	}
	/**
     * Displays all orders in the branch.
     * 
     * @param branch The branch whose orders are to be displayed.
     */
	protected static void displayOrder(Branch branch) {
        if (branch != null) {
            ArrayList<NewOrder> orderList = branch.getOrderList();
            for(NewOrder order : orderList) {
            	System.out.println(order.getOrderID());
            }
         }
         else {
            System.out.println("Branch/Branch order list not found");
        }
    }
    
	 /**
	    * Displays the details of a particular order in the branch.
	    *
	    * @param branch The branch whose order details are to be displayed.
	    */
    protected static void viewParticularOrder(Branch branch) {
  
        if (branch != null) {
            Scanner sc = new Scanner(System.in);
            ArrayList<NewOrder> orderList = branch.getOrderList();
            System.out.println("Enter order ID");
            int OrderId = sc.nextInt();
            for(NewOrder order : orderList) {
            	if(order.getOrderID() == OrderId) {
            		ArrayList<MenuItem> oneOrder = order.getOrderDetails();
            		for(MenuItem item : oneOrder) {
            			System.out.println(item.getName()+","+item.getPrice());
            		}
            	}
            }
            
  
        } else {
            System.out.println("Branch/Branch order list not found");
        }
    }
    /**
     * Processes the order with the given order ID in the specified branch.
     *
     * @param orderID The ID of the order to be processed.
     * @param branch  The branch where the order is to be processed.
     */
    protected static void selectOrderToProcess(int orderID, Branch branch) {
    	Scanner sc = new Scanner(System.in);
    	while (orderID < 0) {
			System.out.println("Please enter the correct order ID");
			orderID = sc.nextInt();
		}
    	
   	    if (branch == null) {
   	        System.out.println("No branch selected.");
   	        return;
   	    }

   	    try {
   	        ArrayList<NewOrder> orderList = branch.getOrderList();
   	        
   	        if (orderList == null) {
   	            throw new IllegalArgumentException("No items selected in the order.");
   	        }
   	        for(NewOrder order : orderList) {
   	        	if(order.getOrderID() == orderID) {
   	        		System.out.println("1)Start Processing");
   	        		System.out.println("2)Finished Processing");
   	        		int choice = sc.nextInt();
   	        		if(choice == 1) {
   	        			order.updateOrderStatus(OrderStatus.PREPARING);
   	        			System.out.println("Order is processing.");
   	        		}
   	        		else if(choice == 2) {
   	        			order.updateOrderStatus(OrderStatus.READY_FOR_COLLECTION);
   	        			System.out.println("Order processed successfully.");
   	        		}
   	        	}
   	        }
   	 
   	    } catch (IllegalArgumentException e) {
   	        System.out.println(e.getMessage());
   	    }
   	}

}
