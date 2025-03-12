import java.util.ArrayList;
import java.util.List;
/**
 * Represents the NTU outlet.
 */
class NTUBranch extends Branch {
	private NTUMenu menu;
	private OrderList NTUOrderList;
	private ConcreteBranchStaffList NTUStaff;
	private String outlet = "NTU";
	
	/**
     * Constructs a new NTUBranch object with the specified location and staff quota.
     * Initializes the menu, order list, and staff list for the branch.
     * Reads staff data from an Excel file and adds staff members to the branch staff list.
     */
	public NTUBranch() { 
		super("North Spine Plaza",8);
		menu = new NTUMenu();
		NTUOrderList = new OrderList();
		NTUStaff = new ConcreteBranchStaffList("NTU");
		ReadStaffExcel file = new ReadStaffExcel("C:\\Users\\shanshan\\Desktop\\NTUStaff.xlsx");
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
			Account newAcc = new Account(name,age,gender,un,"NTU",role);
			NTUStaff.addStaffToBranch(newAcc);
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
	    * Retrieves the menu for the branch.
	    *
	    * @return An ArrayList of MenuItem objects representing the branch menu.
	    */
	public ArrayList<MenuItem> getBranchMenu() {
		return menu.getMenu();
	}
	 /**
	    * Retrieves the order list for the branch.
	    *
	    * @return An ArrayList of NewOrder objects representing the branch order list.
	    */
	public ArrayList<NewOrder> getOrderList(){
		return NTUOrderList.getAllOrderItems();
	}
	/**
	    * Adds an order to the branch order list.
	    *
	    * @param Order The NewOrder object to be added to the order list.
	    */
	public void addOrderToBranchList(NewOrder Order){
		NTUOrderList.addOrderToList(Order);
		
	}
	 /**
	    * Displays the menu for the branch.
	    */
	public void displayMenu() {
		int j=1;
		for(MenuItem item : menu.getMenu()) {
			System.out.println(j+"    "+item.getName()+"     "+item.getPrice());
			j++;
			
		}
	}
	/**
	    * Retrieves the location of the branch.
	    *
	    * @return The location of the branch.
	    */
	public String getLocation() {
	    return this.getLocation();
	}

	/**
	    * Retrieves the ConcreteBranchStaffList object for the branch.
	    *
	    * @return The ConcreteBranchStaffList object containing the staff information for the branch.
	    */
	   @Override
	public ConcreteBranchStaffList getConcreteBranchStaffList() {
		return NTUStaff;
	}
		
}