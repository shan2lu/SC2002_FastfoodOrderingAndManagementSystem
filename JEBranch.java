import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * Represents the branch located in Jurong East.
 */
class JEBranch extends Branch {
	private JEMenu JEmenu;
	private OrderList JEOrderList;
	private ConcreteBranchStaffList JEStaff;
	private String outlet = "JE";
	
	/**
     * Constructs a new JEBranch object with the specified location and staff quota.
     * Initializes the menu, order list, and staff list for the branch.
     * Reads staff data from an Excel file and adds staff members to the branch staff list.
     */
	public JEBranch() { 
		super("Jurong east",11);
		JEmenu = new JEMenu();
		JEOrderList = new OrderList();
		JEStaff = new ConcreteBranchStaffList("Jurong East");
		ReadStaffExcel file = new ReadStaffExcel("C:\\Users\\shanshan\\Desktop\\JEStaff.xlsx");
		String name = "";
		int age = 0;
		String gender = "";
		String un = "";
		String role = "";
		for(int row=0;row<2;row++) {
			for(int col=0;col<5;col++) {
				if(col == 0) {
					name = file.ReadInString(row,col);
				}
				else if(col == 1){
					un = file.ReadInString(row,col);
				}
				else if(col == 2) {
					role = file.ReadInString(row, col);
				}
				else if(col == 3) {
					gender = file.ReadInString(row, col);
				}
				else {
					age = file.ReadInNum(row, col);
				}
			}
	
				Account acc = new Account(name,age,gender,un,"JE",role);
				JEStaff.addStaffToBranch(acc);
			
			
		    }
		}
	
	 /**
     * Retrieves the outlet name of the branch.
     *
     * @return The outlet name of the branch.
     */
	public String getOutlet() {
		return outlet;
	}
	 /**
     * Retrieves the menu of the branch.
     *
     * @return The list of menu items available at the branch.
     */
	public ArrayList<MenuItem> getBranchMenu() {
		return JEmenu.getMenu();
	}
	/**
    * Retrieves the list of orders for the branch.
    *
    * @return The list of orders placed at the branch.
    */
	public ArrayList<NewOrder> getOrderList(){
		return JEOrderList.getAllOrderItems();
	}
	/**
     * Adds a new customer order to the branch's order list.
     *
     * @param Order The order to be added to the branch's order list.
     */

	public void addOrderToBranchList(NewOrder Order){
		JEOrderList.addOrderToList(Order);
		
	}
	/**
     * Displays the menu of the branch.
     */
	public void displayMenu() {
		int j=1;
		for(MenuItem item : JEmenu.getMenu()) {
			System.out.println(j+"    "+item.getName()+"("+item.getFoodSize()+")"+"     "+item.getPrice());
			j++;
		}
	}
	/**
     * Retrieves BranchStaffList for the branch.
     *
     * @return The BranchStaffList for the branch.
     */
	public ConcreteBranchStaffList getConcreteBranchStaffList() {
		return JEStaff;
	}

	/**
     * Retrieves the location of the branch.
     *
     * @return The location of the branch.
     */
	@Override
	public String getLocation() {
		return this.location;
	}
}

