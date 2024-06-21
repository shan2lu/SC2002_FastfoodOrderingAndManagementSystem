import java.util.ArrayList;
import java.util.Scanner;
/**
* The ManagerStaff class represents a manager staff member who can perform various operations
* related to orders, staff management, and menu management for a specific branch.
*/
public class ManagerStaff {
	
	 /**
	    * Starts the manager staff operations for the given branch.
	    *
	    * @param Br The Branch object representing the branch for which the operations are performed.
	    */
	public void start(Branch Br) {
		Scanner sc = new Scanner(System.in);
        int choice =0;
        do {
            System.out.println("1. View all orders");
            System.out.println("2. View particular orders");
            System.out.println("3. Process order");
            System.out.println("4. Display branch staff list");
            System.out.println("5. Add menu item");
            System.out.println("6. Remove menu item");
            System.out.println("7. Edit menu item");
            System.out.println("8. Exit");
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
                    displayBranchStaffList(Br);
                    break;
                case 5:
                	
                    addMenuItem(Br);
                    break;    
                case 6:
                    removeMenuItem(Br);
                    break;
                case 7:
                    System.out.println("1.Edit Menu Item name");
                    System.out.println("2.Edit Menu Item price");
                    System.out.println("3.Edit Menu Item availability");
                    int editItem=sc.nextInt();
                    editMenuItem(editItem,Br);
                    break;    
               
                case 8:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 4.");
            }
        } while (choice != 9);
        
	}
	/**
	    * Displays the list of orders for the given branch.
	    *
	    * @param branch The Branch object representing the branch for which the orders are displayed.
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
         * Displays the details of a particular order for the given branch.
         *
         * @param branch The Branch object representing the branch for which the order details are displayed.
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
         * Processes the order with the given order ID for the specified branch.
         *
         * @param orderID The ID of the order to be processed.
         * @param branch  The Branch object representing the branch for which the order is processed.
         */
        protected static void selectOrderToProcess(int orderID, Branch branch) {
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
       	        		order.updateOrderStatus(OrderStatus.READY_FOR_COLLECTION);
       	        	}
       	        }
       	        System.out.println("Order processed successfully.");
       	    } catch (IllegalArgumentException e) {
       	        System.out.println(e.getMessage());
       	    }
       	}

        /**
         * Displays the staff list for the given branch.
         *
         * @param branch The Branch object representing the branch for which the staff list is displayed.
         */
        public static void displayBranchStaffList(Branch branch) {
	        if (branch != null) {
	            ConcreteBranchStaffList BStaffList=branch.getConcreteBranchStaffList();
	            BStaffList.displayStaff();
	            
	  
	        } else {
	            System.out.println("No branch selected.");
	        }
	    }
			
        /**
         * Adds a new menu item to the branch's menu.
         *
         * @param branch The Branch object representing the branch for which the menu item is added.
         */
		public static void addMenuItem(Branch branch ) {
		       if (branch != null) {
		    	    Scanner sc= new Scanner(System.in);
		            ArrayList<MenuItem> menu = branch.getBranchMenu();
		            System.out.println("Enter item name");
		            String name=sc.next();
		            for(MenuItem checking : menu) {
	            		if(checking.getName().equals(name)) {
	            			System.out.println("Item already exists!");
	            			return;
	            		}
	            	}
		         
		            System.out.println("Enter item price");
		            double price=sc.nextDouble();
		            if(price<0) {
		            	System.out.println("Please input valid price!");
		            	while(price<0) {
		            		System.out.println("Enter item price");
			                price =sc.nextDouble();
		            	}
		            }
		            System.out.println("Enter item category");
		            FoodCategory Cat =FoodCategory.valueOf(sc.next());
		            MenuItem menuItem=new MenuItem(name, price,Cat);
		            menu.add(menuItem);
		            branch.displayMenu();
		            }
		         else {
		            System.out.println("No branch selected.");
		        }
		}
		
		/**
		    * Removes a menu item from the branch's menu.
		    *
		    * @param branch The Branch object representing the branch from which the menu item is removed.
		    */
		public static void removeMenuItem(Branch branch) {
            ArrayList<MenuItem> menu = branch.getBranchMenu();
    	    Scanner sc = new Scanner(System.in);
    	    branch.displayMenu();
		    System.out.println("Which item you want to remove? ");
		    int toRemove = sc.nextInt();
		    menu.remove(toRemove-1);
		    System.out.print("Item removed!");
		    System.out.println();
		    branch.displayMenu();
			//MenuItem menuItem= menu.findItemByName(name);	}
		}
		 /**
		    * Edits a menu item in the branch's menu.
		    *
		    * @param choice The choice representing the menu item attribute to be edited (1 for name, 2 for price, 3 for availability).
		    * @param branch The Branch object representing the branch for which the menu item is edited.
		    */
		public static void editMenuItem(int choice, Branch branch) {
		       if (branch != null) {
		    	    Scanner sc= new Scanner(System.in);
		            ArrayList<MenuItem> menu = branch.getBranchMenu();
		            branch.displayMenu();
		            System.out.println("Which item are you editing");
		            int itemChoice = sc.nextInt();
		            MenuItem item = menu.get(itemChoice-1);
		            switch(choice) {
		            case 1: //change name
		            	System.out.println("Key in new name:");
		            	String newName = sc.next();
		            	for(MenuItem checking : menu) {
		            		if(checking.getName() == newName) {
		            			System.out.println("Item already exists!");
		            		}
		            	}
		            	item.setName(newName);
		            	break;
		            case 2:
		            	System.out.println("Key in the new price :");
		            	double price = sc.nextDouble();
		            	if(price<0) {
		        			System.out.println("Please in put proper price!");
		        		}
		            	item.setPrice(price);
		            	break;
		            case 3: //change avail
		            	item.ItemNotAvail();
		            	break;
		            
		           }
		           branch.displayMenu();
		       }
		         else {
		            System.out.println("No branch selected.");
		        }
			
		}

}

