/**
 * An interface representing the staff list for a branch of a restaurant chain.
 */
public interface BranchStaffList {
	
	// list of methods to be inherited
	 int getNumOfStaff();
	  int getNumOfManager();
	  void addStaffToBranch(Account Staff);
	  void displayStaff();
	  void displayGenderStaff(int choice);
	  void displayAgeStaff(int choice);
	  String getBranchLocation();
	  Account findStaffByUsername(String Username);
	  int calculateManagersNeeded(int nOStaff, int nOManager);
	  void removeStaffFromBranch(String username2);
	 void editStaff(String username1, String name);
	void editStaff(String username1, int age);
	void editStaffName(String username1, String newUsername);
	
}

