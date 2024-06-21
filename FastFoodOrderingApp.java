
import java.util.Scanner;
/**
 * The main class for the Fast Food Ordering Application.
 */
public class FastFoodOrderingApp {
	
    public static void main(String[] args) {
        int loginChoice;
        Scanner sc = new Scanner(System.in);
        BranchManagement BM = new BranchManagement(); //Create since the start so to create the 3 stores
        PaymentManagement pm = new PaymentManagement();
        StaffList AllStaff = new StaffList();
        while(true) {
            do {
                System.out.println("Are you a 1)customer or 2)staff");
                loginChoice = sc.nextInt();
            } while(loginChoice < 1 || loginChoice > 2);

            if(loginChoice == 1) {
                System.out.println("Are you 1)ordering or 2)collecting order");
                int visitChoice = sc.nextInt();
                BM.displayBranches(); //Use BranchManagement to display the branches
                int choice=0;
                System.out.println("Choose the branch");
                choice = sc.nextInt() - 1 ;
                Branch selectedBranch = BM.branches.get(choice);
                if(visitChoice == 1) {    //Customer either ordering or not ordering
                    Customer Cu = new Customer(selectedBranch,pm);
                    Cu.start();
                } else {
                    StatusCheckingAndCollection statusChecking = new StatusCheckingAndCollection(selectedBranch);
                    statusChecking.start(BM);
                }

            } else if (loginChoice == 2) {
                System.out.println("Enter role choice");
                System.out.println("1. Staff");
                System.out.println("2. Manager");
                System.out.println("3. Admin");
                System.out.print("Enter your choice: ");
                int roleChoice = sc.nextInt(); //different role of staffs
                int detailsCorrect = 0;
                Branch selectedBranch = null;  

                do{
                    System.out.println("Enter UserName:");
                    String username= sc.next();
                    Account staff1;
                    staff1 = AllStaff.findStaffByUsername(username);
                    if(staff1 == null) {
                        System.out.println("Error! Please enter credentials again");
                        continue;
                    }
                    System.out.println("Enter password:");
                    String password= sc.next();
           
                    if (staff1 != null && staff1.getPassword().equals(password)) {
                        detailsCorrect = 1;
                        System.out.println("Login successful! Welcome Back to "+staff1.getOutlet()+" "+staff1.getName());
                        if (staff1.getPassword().equals("password")) {
                            System.out.println("Enter new password");
                            String password2 =sc.next();
                            AllStaff.changeStaffPassword(username, password2);
                        }
                        for(Branch br : BM.branches) {
                            if(br.getOutlet().equals(staff1.getOutlet())) {
                                selectedBranch = br;
                            }
                        }
                    }
                    else {
                      System.out.println("Wrong credential! Try again");
                      continue;
                    }
                }while(detailsCorrect != 1);;
 

                    if(roleChoice == 1) {   //go to their respective interface
                        NormalStaff staff = new NormalStaff();
                        staff.start(selectedBranch);  
                    } else if(roleChoice == 2) {
                        ManagerStaff ma = new ManagerStaff();
                        ma.start(selectedBranch);
                    } else {
                        AdminStaff admin = new AdminStaff(AllStaff,BM,pm);
                        admin.start();
                    }
                }
            }
        }
}



	        
		
		
