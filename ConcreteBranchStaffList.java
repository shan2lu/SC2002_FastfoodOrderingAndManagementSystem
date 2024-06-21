import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
/**
* ConcreteBranchStaffList is an implementation of the BranchStaffList interface, which manages
* the staff members of a particular branch.
*/
public class ConcreteBranchStaffList implements BranchStaffList{
	private List<Account> staffInBranch;
	private String branchLocation;
	private int NumOfStaff=0;
	private int NumOfManager=0;
	/**
	    * Constructs a ConcreteBranchStaffList object with the given branch location.
	    *
	    * @param branchLocation The location of the branch.
	    */
	public ConcreteBranchStaffList(String branchLocation) {
		this.branchLocation = branchLocation;
		this.staffInBranch = new ArrayList<>();
	}
	/**
	    * Returns the location of the branch.
	    *
	    * @return The branch location.
	    */
	public String getBranchLocation() {
		return branchLocation;
	}
	/**
	    * Returns the number of managers in the branch.
	    *
	    * @return The number of managers.
	    */
	public int getNumOfManager() {
		return NumOfManager;
	}
	/**
    * Returns the number of staff members in the branch.
    *
    * @return The number of staff members.
    */
	public int getNumOfStaff() {
		return NumOfStaff;
	}
	
	 /**
	    * Finds a staff member by their username.
	    *
	    * @param username The username of the staff member to find.
	    * @return The staff member object if found, or null if not found.
	    */
	public Account findStaffByUsername(String username) {
	        for (Account staff : staffInBranch) {
	            if (staff.getUsername().equals(username)) {
	                return staff;
	            }
	        }
	        return null; // Staff not found
	}
	
	/**
	    * Adds a staff member to the branch.
	    *
	    * @param staff The staff member to add.
	    */
	public void addStaffToBranch(Account staff) {
		staffInBranch.add(staff);
		if (staff.getRole().equals("S")){
			NumOfStaff++;
		}
		else {
			NumOfManager++;
		}
		

	}
	 /**
	    * Promotes a staff member to a manager.
	    *
	    * @param username The username of the staff member to promote.
	    */
	public void promoteToManager(String username) {
	        Account staff = findStaffByUsername(username);
	        if (staff != null) {
	            staff.setRole("M"); 
	            System.out.println("Promoted successfully");
	        } else {
	            System.out.println("Staff member with username " + username + " not found.");
	        }
	}

	/**
	    * Returns a list of all staff members in the branch.
	    *
	    * @return A list of staff member objects.
	    */
	public List<Account> getStaffInBranch(){
		return staffInBranch;
	}
	
	public void displayStaff() {
        System.out.println("Displaying staff :");
        for (Account staff : staffInBranch) {
        	 staff.getStaffInfo();
        }
    }
	/**
	    * Displays information about all staff members in the branch.
	    */
	public void displayGenderStaff(int choice) {
		if (choice==1) {
		        for (Account staff : staffInBranch) {
		        	if(staff.getGender()=="F")
		        	    staff.getStaffInfo();;;
		        }
	
		}
		
		else if(choice==2) {
	        for (Account staff : staffInBranch) {
	        	if(staff.getGender()=="M")
	        	    staff.getStaffInfo();;;
	        }
		}
		
		else
		{
			System.out.print("Incorrect input");
		}
       
    }
	/**
    * Displays information about staff members based on their age group.
    *
    * @param choice 1 for age < 30, 2 for age between 30 and 40, 3 for age > 50.
    */
	public void displayAgeStaff(int choice) {
		if (choice==1) {
		        for (Account staff : staffInBranch) {
		        	if(staff.getAge()<30)
		        	    staff.getStaffInfo();;;
		        }
		}
		
		else if(choice==2) {
	        for (Account staff : staffInBranch) {
	        	if(staff.getAge()<=40 && staff.getAge()>=30)
	        	    staff.getStaffInfo();;;
	        }
	
		}
		else if(choice==3) {
	        for (Account staff : staffInBranch) {
	        	if(staff.getAge()>50)
	        	    staff.getStaffInfo();;;
	        }

		}
		
		else
		{
			System.out.print("Incorrect input");
		}
       
    }
	
	 /**
	    * Removes a staff member from the branch.
	    *
	    * @param staffUN The username of staff's account which help to locate the account of the staff to remove.
	    */
	public void removeStaffFromBranch(String staffUN) {
	      for (int i = 0; i < staffInBranch.size(); i++) {
	          Account currentStaff = staffInBranch.get(i);
	          String cStaffUsername=currentStaff.getUsername();
	          if (cStaffUsername.equals(staffUN)) {
	              staffInBranch.remove(i);
	              System.out.println("Staff removed from ." + this.getBranchLocation()+" Outlet");
	              return; // Exit the loop once staff is removed
	          }
	      }
	      System.out.println("Staff not found in the branch.");
	  }
	 /**
	    * Calculates the number of managers needed based on the number of staff and current number of managers.
	    *
	    * @param nOStaff    The number of staff members.
	    * @param nOManager  The current number of managers.
	    * @return The number of additional managers needed, or -1 if the input is invalid.
	    */
	   @Override
	public int calculateManagersNeeded(int nOStaff, int nOManager) {
		if (nOStaff >= 1 && nOStaff <= 4) {
        	if (nOManager == 0) {
        		return 1;
        	}
        	else if(nOManager> 0) {
        		return 0;
        	}
        } 
        
        else if (nOStaff >= 5 && nOStaff <= 8) {
        	if (nOManager == 0) {
        		return 2;
        	}
        	else if (nOManager == 1) {
        		return 1;
        	}
        	else if (nOManager > 1) {
        		return 0;
        	}
        } 
        
        else if (nOStaff >= 9 && nOStaff <= 15) {
        	if (nOManager == 0) {
        		return 3;
        	}
        	else if (nOManager == 1) {
        		return 2;
        	}
        	else if (nOManager == 2 ) {
        		return 1;
        	}
        	else if(nOManager> 2) {
        		return 0;
        	}
        } 
        
        return -1; //handle any other cases
    }
	   
	   /**
	    * Change selected Staff's name
	    * 
	    * @param username    The usernmae of the account.
	    * @param newUsername  The new username associated with the account.
	    */
	   public void editStaff(String username, String newUsername) {
	          Account staff = findStaffByUsername(username);
	          if (staff != null) {
	              staff.setLoginUsername(newUsername);
	              System.out.println("Staff member " + username + " updated.");
	          } else {
	              System.out.println("Staff member with username " + username + " not found.");
	          }
	      }
	      
	    
	   /**
	    * Change selected Staff's age
	    * 
	    * @param username    The usernmae of the account.
	    * @param newAge The updated age of the staff.
	    */
	      public void editStaff(String username, int newAge) {
	          Account staff = findStaffByUsername(username);
	          if (staff != null) {
	              staff.setAge(newAge);
	              System.out.println("Staff member " + username + " updated.");
	          } else {
	              System.out.println("Staff member with username " + username + " not found.");
	          }
	      }
	      
	      /**
		    * Change selected Staff's real name
		    * 
		    * @param username    The usernmae of the account.
		    * @param newName The new name of the staff.
		    */
	       public void editStaffName(String username, String newName) {
	          Account staff = findStaffByUsername(username);
	          if (staff != null) {
	              staff.setName(newName);
	              System.out.println("Staff member " + username + " updated.");
	          } else {
	              System.out.println("Staff member with username " + username + " not found.");
	          }
	      }
		  





					
}