import java.util.ArrayList;
import java.util.List;
/**
 * An abstract class representing a branch of a restaurant.
 */
public abstract class Branch {
	protected String location;
	protected int staffQuota;
	/**
     * Constructs a new Branch object with the specified location and staff quota.
     *
     * @param location   The location of the branch.
     * @param staffQuota The maximum number of staff members allowed at the branch.
     */
	public Branch(String location, int staffQuota) {
		this.location = location;
		this.staffQuota = staffQuota;
	}
	/**
     * Retrieves the location of the branch.
     *
     * @return The location of the branch.
     */
	public String getBranchLocation() {
		return location;
	}
	/**
     * Sets the location of the branch.
     *
     * @param location The new location of the branch.
     */
	public void setLocation(String location) {
		this.location = location;
	}
	/**
     * Retrieves the staff quota of the branch.
     *
     * @return The maximum number of staff members allowed at the branch.
     */
	public int getStaffQuota() {
		return staffQuota;
	}
	/**
     * Sets the staff quota of the branch.
     *
     * @param num The new staff quota for the branch.
     */
	public void setStaffQuota(int num) {
		staffQuota = num;
	}
	
	public abstract void displayMenu();
	public abstract ArrayList<MenuItem> getBranchMenu();
	public abstract ArrayList<NewOrder> getOrderList();
	public abstract void addOrderToBranchList(NewOrder order);
	public abstract ConcreteBranchStaffList getConcreteBranchStaffList();
	public abstract String getOutlet();
	public abstract String getLocation();
	


}

