import java.util.ArrayList;
/**
* The newBranch class extends the Branch class and represents a specific branch of a restaurant or business.
* It contains information about the location, staff quota, menu, order list, and staff list for the branch.
*/
public class newBranch extends Branch{
	protected String location;
	private int staffQuota;
	private MenuInterface menu;
	private OrderList OrderList;
	private ConcreteBranchStaffList NewStaff;
	/**
	    * Constructs a newBranch object with the given location and staff quota.
	    * @param location   The location of the branch.
	    * @param staffQuota The staff quota for the branch.
	    */
	public newBranch(String location, int staffQuota) {
		super(location, staffQuota);
		//read in menu from excel
	}
	/**
	    * Displays the menu for the branch.
	    */
	   @Override
	public void displayMenu() {
		int j=1;
		for(MenuItem item : menu.getMenu()) {
			System.out.println(j+"    "+item.getName()+"     "+item.getPrice());
			j++;
			
		}
		
	}
	   /**
	    * Returns the menu for the branch.
	    *
	    * @return An ArrayList of MenuItem objects representing the branch menu.
	    */
	   @Override
	public ArrayList<MenuItem> getBranchMenu() {
		return menu.getMenu();
	}
	   /**
	    * Returns the list of orders for the branch.
	    *
	    * @return An ArrayList of NewOrder objects representing the branch order list.
	    */
	   @Override
	public ArrayList<NewOrder> getOrderList() {
		return OrderList.getAllOrderItems();
	}
	   /**
	    * Adds an order to the branch order list.
	    *
	    * @param order The NewOrder object to be added to the order list.
	    */
	   @Override
	public void addOrderToBranchList(NewOrder order) {
		OrderList.addOrderToList(order);
		
	}
	   /**
	    * Returns the ConcreteBranchStaffList object for the branch.
	    *
	    * @return The ConcreteBranchStaffList object containing the staff information for the branch.
	    */
	   @Override
	public ConcreteBranchStaffList getConcreteBranchStaffList() {
		return this.getConcreteBranchStaffList();
	}
	   /**
	    * Returns the outlet name of the branch.
	    *
	    * @return The outlet name of the branch.
	    */
	public String getOutlet() {
		
		return this.getOutlet();
	}
	/**
	    * Returns the location of the branch.
	    *
	    * @return The location of the branch.
	    */
	   @Override
	public String getLocation() {
	    return this.getLocation();
	}


}

