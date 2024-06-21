import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * Represents the branch located in Jurong Point.
 */
class JPBranch extends Branch {
	private JPMenu JPmenu;
	private OrderList JPOrderList;
	private ConcreteBranchStaffList JPStaff;
	private String outlet = "JP";
	
	/**
     * Constructs a new JPBranch object with the specified location and staff quota.
     * Initializes the menu, order list, and staff list for the branch.
     * Reads staff data from an Excel file and adds staff members to the branch staff list.
     */
	public JPBranch() { 
		super("Jurong point",15);
		JPmenu = new JPMenu();
		JPOrderList = new OrderList();
		JPStaff = new ConcreteBranchStaffList("Jurong Point");
		ReadStaffExcel file = new ReadStaffExcel("C:\\Users\\shanshan\\Desktop\\JPStaff.xlsx");
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
			Account newAcc = new Account(name,age,gender,un,"JP",role);
			JPStaff.addStaffToBranch(newAcc);
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
		return JPmenu.getMenu();
	}
	/**
	    * Retrieves the list of orders for the branch.
	    *
	    * @return The list of orders placed at the branch.
	    */

	public ArrayList<NewOrder> getOrderList(){
		return JPOrderList.getAllOrderItems();
	}
	/**
     * Adds a new customer order to the branch's order list.
     *
     * @param Order The order to be added to the branch's order list.
     */
	public void addOrderToBranchList(NewOrder Order){
		JPOrderList.addOrderToList(Order);
		
	}
	/**
     * Displays the menu of the branch.
     */
	public void displayMenu() {
		int j=1;
		for(MenuItem item : JPmenu.getMenu()) {
			System.out.println(j+"    "+item.getName()+"("+item.getFoodSize()+")"+"     "+item.getPrice());
			j++;
			
		}
	}
	/**
     * Retrieves BranchStaffList for the branch.
     *
     * @return The BranchStaffList for the branch.
     */
	@Override
	public ConcreteBranchStaffList getConcreteBranchStaffList() {
		return JPStaff;
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