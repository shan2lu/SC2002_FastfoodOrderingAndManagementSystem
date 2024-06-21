import java.util.Scanner;
/**
* The AdminStaff class represents an administrative staff member who manages staff accounts,
* branch operations, and payment methods.
*/
public class AdminStaff {

	private StaffList stafflist;
	private BranchManagement BM;
	private PaymentManagement PM;
	/**
	    * Constructs an AdminStaff object with the given StaffList, BranchManagement, and PaymentManagement objects.
	    *
	    * @param stafflist The StaffList object containing staff information.
	    * @param BM        The BranchManagement object responsible for managing branches.
	    * @param PM        The PaymentManagement object responsible for managing payment methods.
	    */
	public AdminStaff(StaffList stafflist, BranchManagement BM, PaymentManagement PM) {
		this.stafflist = stafflist;
		this.BM = BM;
		this.PM = PM;
	}
	/**
	    * Starts the administrative staff menu, allowing the user to perform various operations.
	    */
	public void start() {
		Scanner sc = new Scanner(System.in);
        int choice;
        //Branch Branches = new Branch(null, choice);
        do {
            System.out.println("1. Add/Edit/Remove Staff Accounts");
            System.out.println("2. Display Staff list");
            System.out.println("3. Assign Managers");
            System.out.println("4. Promote Staff to branch Manager");
            System.out.println("5. Transfer staff/Manager");
            System.out.println("6. Add/remove Payment method");
            System.out.println("7. Open/close Branch");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    editStaffAccount(BM, stafflist);
                    break;
                case 2:
                    displayStafflist(BM);
                    break;
                case 3:
                    AssignManager(BM);
                    break;
                case 4:
                    promoteStaff(BM,stafflist);
                    break;
                case 5:
                    transferStaff(BM, stafflist);
                    break;    
                case 6:
                    editPaymentMethod();
                    break;    
                case 7:
                    isOpen(BM);
                    break;

                case 8:
                    System.out.println("Exiting.....");
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 4.");
            }
        } while (choice != 8);
	}
	
	public void displayStafflist(BranchManagement BM) {
	    Scanner sc=new Scanner(System.in);
	    System.out.print("Enter your choice: ");
	    System.out.print("1. Display based on branch");
	    System.out.print("2. Display based on role");
	    System.out.print("3. Display based on gender");
	    System.out.print("3. Display based on age");
	    int choice = sc.nextInt();
	      
	    System.out.println("Current staff List");
	    switch (choice) {
	    case 1:
	        System.out.println("Select branch");
	        System.out.println("NTU");
	        System.out.println("JE");
	        System.out.println("JP");
	        String branchChoice=sc.next();
	        BranchStaffList branchStaffList2=BM.getConcreteBranchStaffList(branchChoice);
	        branchStaffList2.displayStaff();
	        break;
	        
	    case 2: 
	        System.out.println("Select role");
	        System.out.println("1.Staff");
	        System.out.println("2.Manager");
	        System.out.println("3.Admin");
	        int roleChoice=sc.nextInt();
	        stafflist.displayStaffRole(roleChoice);
	        break;
	              
	      
	    case 3:
	      System.out.println("Select gender");
	        System.out.println("1.Female");
	        System.out.println("2.Male");
	        int genderChoice=sc.nextInt();
	        stafflist.displayStaffGender(genderChoice);
	        break;
	        
	        

	    case 4: 
	        System.out.println("Select age");
	        System.out.println("1. Below 30 years old");
	        System.out.println("2. 30-50 year olds");
	        System.out.println("3.Above 50 years old");
	        int ageChoice=sc.nextInt();
	        stafflist.displayStaffAge(ageChoice);
	        break;
	    }
	  }
		    
	/**
	    * Edits payment methods by adding or removing them.
	    */	    
	public void editPaymentMethod() {
	      Scanner sc = new Scanner(System.in);
	  
	      System.out.println("Enter your choice: ");
	      System.out.println("1. Add Payment method");
	      System.out.println("2. Remove Payment method");

	      int choice = sc.nextInt();
	      switch (choice) {
	          case 1:
	              System.out.println("Enter new Payment type:");
	              System.out.println("1. Online Banking");
	              System.out.println("2. Card");
	              int paymentType = sc.nextInt();
	              switch (paymentType) {
	                  case 1:
	                      System.out.println("Enter name of online banking method");
	                      String onlineBankingName = sc.next();
	                      OnlineBanking onlineBanking = new OnlineBanking(onlineBankingName);
	                      PM.addPaymentMethod(onlineBanking);
	                      break;
	                  case 2:
	                      System.out.println("Enter name of card");
	                      String cardName = sc.next();
	                      CreditCard card = new CreditCard(cardName);
	                      PM.addPaymentMethod(card);
	                      break;
	                  default:
	                      System.out.println("Invalid payment type.");
	                      break;
	              }
	              break;
	          case 2:
	        	  PM.displayPaymentMethods();
	        	  System.out.println("Which method you want to remove :");
	        	  int chosenMethod = sc.nextInt();
	              PM.removePaymentMethod(chosenMethod);
	              break;
	          default:
	              System.out.println("Invalid choice.");
	              break;
	      }
	  }
		  
	/**
    * Edits staff accounts by adding, editing, or removing staff members.
    *
    * @param BM        The BranchManagement object responsible for managing branches.
    * @param stafflist The StaffList object containing staff information.
    */	  
	public void editStaffAccount(BranchManagement BM, StaffList stafflist) {
	    Scanner sc=new Scanner(System.in);
	    System.out.print("Enter your choice: ");
	    System.out.print("1. Add Staff");
	    System.out.print("2. Edit Staff");
	    System.out.print("3.RemoveStaff");
	    int choice = sc.nextInt();
	    
	    switch(choice) {
	    case 1:
	      System.out.print("Enter name ");
	        String name = sc.next();
	        System.out.print("Enter age");
	        int Age = sc.nextInt();
	        System.out.print("Enter gender");
	        String gender = sc.next();
	        System.out.print("Enter username");
	        String Username = sc.next();
	        System.out.print("Enter role");
	        String role = sc.next();
	        System.out.print("Enter branch");
	        String branch = sc.next();
	        Account staff=new Account(name,Age,gender,Username,branch,role);
	        BranchStaffList branchStaffList=BM.getConcreteBranchStaffList(branch);
	        branchStaffList.addStaffToBranch(staff);
	        stafflist.addStaffToStaffList(staff);
	        break;
	             
	    case 2:
	      System.out.print("Input Staff Username to be edited");
	        String Username1 = sc.next();
	        int i=0;
	        while(i==0) {
	          System.out.println("Choose what to edit");
	            System.out.println("1.Name");
	            System.out.println("2.Age");
	            System.out.println("3.Username");
	            int choice1=sc.nextInt();
	            switch(choice1) {
	            case 1:
	              System.out.println("Input new name:");
	                String Name=sc.next();
	                System.out.print("Input branch of employee");
	            String branch1 = sc.next();
	                stafflist.editStaff(Username1, Name);
	                BranchStaffList branchStaffList1=BM.getConcreteBranchStaffList(branch1);
	            branchStaffList1.editStaff(Username1, Name);
	                i=1;
	                break;
	            case 2:
	                System.out.println("Input new name:");
	                int age=sc.nextInt();
	                System.out.print("Input branch of employee");
	            String branch2 = sc.next();
	                stafflist.editStaff(Username1, age);
	                BranchStaffList branchStaffList2=BM.getConcreteBranchStaffList(branch2);
	                branchStaffList2.editStaff(Username1, age);
	                i=0;
	                break;
	            case 3:
	                System.out.println("Input new name:");
	                String newUsername=sc.nextLine();
	                System.out.print("Input branch of employee");
	            String branch3 = sc.next();
	                stafflist.editStaffName(Username1, newUsername);
	                BranchStaffList branchStaffList3=BM.getConcreteBranchStaffList(branch3);
	                branchStaffList3.editStaffName(Username1, newUsername);
	                i=0;
	                break;
	            }
	        }
	            
	    case 3:
	      System.out.print("Input Staff username to be removed");
	        String Username2 = sc.next();
	        if (stafflist != null) {
	          Account staff2=stafflist.findStaffByUsername(Username2);
	          String Branch=staff2.getBranch();
	          BranchStaffList branchStaffList1=BM.getConcreteBranchStaffList(Branch);
	            branchStaffList1.removeStaffFromBranch(Username2);} 
	        else {
	            System.out.println("Staff list is not set.");
	        }
	    }
	  }

	/**
    * Promotes a staff member to a manager.
    *
    * @param branches  The BranchManagement object responsible for managing branches.
    * @param stafflist The StaffList object containing staff information.
    */
	private void promoteStaff(BranchManagement branches,StaffList stafflist) {
	    Scanner sc=new Scanner(System.in);
	    System.out.print("Enter username of staff to promote ");
	    String name = sc.next();
	    System.out.print("Enter branch");
	    String branch2 = sc.next();
	    Branch Branch2 = branches.getBranch(branch2);
	    ConcreteBranchStaffList newBranch= Branch2.getConcreteBranchStaffList();
	    if (newBranch != null) {
	      newBranch.promoteToManager(name);
	      stafflist.promoteToManager(name);
	    } 
	    else {
	      System.out.println("Staff list is not set.");
	      }
	}
	/**
	    * Opens or closes a branch.
	    *
	    * @param branches The BranchManagement object responsible for managing branches.
	    */
	private void isOpen(BranchManagement branches) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your choice: ");
		System.out.println("1. Open Branch");
		System.out.println("2. Close Branch");
		int choice = sc.nextInt();
		System.out.print("Enter outlet");
		String Location = sc.next();
		switch(choice) {
			case 1:
		        System.out.print("Enter staff quota");
		        int SQuota = sc.nextInt();
		        newBranch branch=new newBranch(Location,SQuota);
		        branches.addBranch(branch);
		        break;
		        case 2:
		          if (branches!=null) {
		          branches.removeBranch(Location);
		        }
		        else {
		          System.out.println("Branch list not initialised yet");
		        }
		          break;
		  
		}
	}
	/**
	    * Transfers a staff member from one branch to another.
	    *
	    * @param branches  The BranchManagement object responsible for managing branches.
	    * @param staffList The StaffList object containing staff information.
	    */
	public void transferStaff( BranchManagement branches, StaffList staffList) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter username of staff to transfer: ");
        String name = sc.next();
        System.out.println("Enter old branch:");
        String branch1 = sc.next();
        Branch Branch1=branches.getBranch(branch1);
        System.out.println("Enter new branch:");
        String branch2 = sc.next();
        Branch Branch2=branches.getBranch(branch2);
        ConcreteBranchStaffList oldBranch= Branch1.getConcreteBranchStaffList();
        ConcreteBranchStaffList newBranch= Branch2.getConcreteBranchStaffList();
        staffList.transferStaff(name,oldBranch,newBranch);
        
    }
	/**
	    * Assigns a manager to a branch.
	    *
	    * @param branches The BranchManagement object responsible for managing branches.
	    */	    
	public void AssignManager(BranchManagement branches) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter name of staff to assign as manager ");
        String name = sc.next();
        System.out.print("Enter old branch ");
        String branch1 = sc.next();
        System.out.print("Enter new branch");
        String branch2 = sc.next();
        Branch Branch1=branches.getBranch(branch1);
        Branch Branch2=branches.getBranch(branch2);
        ConcreteBranchStaffList oldBranch= Branch1.getConcreteBranchStaffList();
        ConcreteBranchStaffList newBranch= Branch2.getConcreteBranchStaffList();
        stafflist.AssignManager(name,oldBranch,newBranch);
  }
		  
}