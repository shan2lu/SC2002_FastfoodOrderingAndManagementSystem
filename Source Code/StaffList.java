import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
* The StaffList class manages a list of staff accounts and provides methods for
* finding, editing, displaying, transferring, and promoting staff members.
*/
public class StaffList {
    private ArrayList<Account> AllStaffAcc;
    /**
     * Constructs a new StaffList object and populates it with staff accounts
     * read from an Excel file located at "C:\Users\shanshan\Desktop\AllStaffList.xlsx".
     */
	public StaffList(){
		this.AllStaffAcc = new ArrayList<>();
		ReadStaffExcel file = new ReadStaffExcel("C:\\Users\\shanshan\\Desktop\\AllStaffList.xlsx");
		String name = "";
		int age = 0;
		String gender = "";
		String un = "";
		String role = "";
		String outlet ="";
		for(int row=0;row<7;row++) {
			for(int col=0;col<6;col++) {
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
				else if(col ==4){
					age = file.ReadInNum(row, col);
				}
				else {
					outlet = file.ReadInString(row, col);
				}
			}
			
			Account sa = new Account(name,age,gender,un,outlet,role);
			AllStaffAcc.add(sa);
		}

	}
	
	 /**
	    * Finds a staff member by their username.
	    *
	    * @param username The username of the staff member to find.
	    * @return The Account object representing the staff member, or null if not found.
	    */
   public Account findStaffByUsername(String username) {
	   for (Account acc : AllStaffAcc) {
		   if(acc.getUsername().equals(username)) {
			   return acc;
           }
       }
       return null; // Return null if not found in any branch
   }
   /**
    * Edits the username of a staff member.
    *
    * @param username    The current username of the staff member.
    * @param newUsername The new username to be set.
    */
   public void editStaff(String username, String newUsername) {
	   Account staff = findStaffByUsername(username);
	   if (staff != null) {
        staff.setLoginUsername(newUsername);
        System.out.println("Staff member " + username + " updated.");
       } 
       else {
        System.out.println("Staff member with username " + username + " not found.");
       }
   }
   /**
    * Edits the age of a staff member.
    *
    * @param username The username of the staff member.
    * @param newAge   The new age to be set.
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
    * Edits the name of a staff member.
    *
    * @param username The username of the staff member.
    * @param newName  The new name to be set.
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
   /**
    * Displays staff members based on their role.
    *
    * @param role The role code.
    */
   public void displayStaffRole(int role) {
	    switch(role) {
	        case 1:
	            System.out.println("Displaying staff:");
	            for (Account staffAcc : AllStaffAcc) {
	            	 if(staffAcc.getRole().equals("S")) {
	            		 staffAcc.getStaffInfo();
	            	 }
	            }
	            break;
	        case 2:
	             System.out.println("Displaying Manager:");
	             for (Account staffAcc: AllStaffAcc) {
	            	 if(staffAcc.getRole().equals("M")) {
	            		 staffAcc.getStaffInfo();
	            	 }
	             }
	             break;
	       case 3:
	            System.out.println("Displaying Admin:");
	            for (Account staffAcc: AllStaffAcc) {
	            	if(staffAcc.getRole().equals("A")) {
	            		staffAcc.getStaffInfo();
	           	    }
	            }
	            break;
	       default:
	            System.out.println("Invalid role.");
	            break;
	    }
	}
   
   /**
    * Displays staff members based on their gender.
    *
    * @param choice The gender choice.
    */
   public void displayStaffGender(int choice) {
	    switch(choice) {
	    	case 1:
	    		for (Account staffAcc : AllStaffAcc) {
	    			if(staffAcc.getGender().equals("F")) {
	    				staffAcc.getStaffInfo();
	    			}
	    	    }
	    		break;
	    	case 2:
	    		for (Account staffAcc : AllStaffAcc) {
	    			if(staffAcc.getGender().equals("M")) {
	    				staffAcc.getStaffInfo();
	    			}
	    	    }
	    }
   }
   /**
    * Displays staff members based on their age group.
    *
    * @param age The age group choice.
    */
   public void displayStaffAge(int age) {
	    switch(age) {
		case 1:
			for (Account staffAcc : AllStaffAcc) {
				if(staffAcc.getAge()<30) {
					staffAcc.getStaffInfo();
				}
		    }
			break;
		case 2:
			for (Account staffAcc : AllStaffAcc) {
				if(staffAcc.getAge()<50 && staffAcc.getAge()>=30) {
					staffAcc.getStaffInfo();
				}
		    }break;
	  	case 3:
			for (Account staffAcc : AllStaffAcc) {
				if(staffAcc.getAge()>=50) {
					staffAcc.getStaffInfo();
				}
		    }break;
	    }


	}
   
   /**
    * Transfers a staff member from one branch to another.
    *
    * @param username  The username of the staff member to be transferred.
    * @param oldBranch The ConcreteBranchStaffList object representing the old branch.
    * @param newBranch The ConcreteBranchStaffList object representing the new branch.
    */
   
   public void transferStaff(String username, BranchStaffList oldBranch, BranchStaffList newBranch) {
      Account staff = findStaffByUsername(username);
     oldBranch.removeStaffFromBranch(username);
     newBranch.addStaffToBranch(staff);
     String Branch=newBranch.getBranchLocation();
     staff.setBranch(Branch);
       
       
   }
   
   
   /**
    * Assigns a staff member as a manager to a branch based on the branch's staffing requirements.
    *
    * @param username The username of the staff member to be assigned as a manager.
    * @param newBranch The BranchStaffList object representing the branch where the manager is to be assigned.
    */
   public void AssignManager(String username,BranchStaffList oldBranch, BranchStaffList newBranch) {
       Account manager = findStaffByUsername(username);
       int NOStaff=newBranch.getNumOfStaff();
       int NOManager=newBranch.getNumOfManager();
       int managersNeeded = newBranch.calculateManagersNeeded(NOStaff,NOManager);
       if(managersNeeded>0) {
          oldBranch.removeStaffFromBranch(username);
        newBranch.addStaffToBranch(manager);
        String Branch=newBranch.getBranchLocation();
        manager.setBranch(Branch);
       }
       else
       {
         System.out.println("Enough managers");
       }
     
       
       
   } 
   /**
    * Updates the role of a staff member to manager.
    *
    * @param username The username of the staff member to be promoted.
    */
   public void promoteToManager(String username) {
       Account staff = findStaffByUsername(username);
       if (staff != null) {
           staff.setRole("M"); 
       } else {
           System.out.println("Staff member with username " + username + " not found.");
       }
   }
   
   
   /**
    * Add staff into stafflist.
    *
    * @param Staff The staff to be added, as an Account object.
    */
   public void addStaffToStaffList(Account Staff) {
      AllStaffAcc.add(Staff);
      System.out.println("Staff added!");
   } 
   /**
    * Changing of password for an account
    *
    * @param username The username of the account.
    * @param password The new password.
    */
   public void changeStaffPassword(String username,String password) {
       Account staff=findStaffByUsername(username);
       staff.setPassword(password);
   }
   
}