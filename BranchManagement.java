import java.util.ArrayList;
/**
 * Manages the different branches of a restaurant chain.
 */
public class BranchManagement {
	public ArrayList<Branch> branches;
	/**
    * Constructs a new BranchManagement object and initializes the list of branches.
    */
	public BranchManagement(){
		branches = new ArrayList<>();
		initialiseBM();
		
		
	}
	/**
    * Initializes the list of branches with already set-up branches (NTU, JE, and JP).
    */
	public void initialiseBM() {
		NTUBranch ntu = new NTUBranch();
		branches.add(ntu);
		JEBranch je = new JEBranch();
		branches.add(je);
		JPBranch jp = new JPBranch();
		branches.add(jp);
	}

	 /**
     * Retrieves a branch based on its name.
     *
     * @param BranchName The name of the branch to retrieve.
     * @return The Branch object corresponding to the specified name, or null if not found.
     */
	public Branch getBranch(String BranchName) {
        for (Branch branch : branches) {
            if (branch.getOutlet().equals(BranchName)) {
                return branch;
            }
    }
        return null; //did not find the branch
	}
	/**
     * Removes a branch from the list of branches based on its location.
     *
     * @param location The location of the branch to be removed.
     */
	public void removeBranch(String location) {
		for (int i=0; i<branches.size(); i++) {
			Branch branch = branches.get(i);
			if (branch.getOutlet().equals(location)){
				//System.out.println(branches.size());
				branches.remove(i);
				System.out.println(location + " branch removed");
				return;
			}
		}
	}
	/**
     * Displays the names of all branches.
     */
	public void displayBranches() {
		int i=1;
        for (Branch branch : branches) {
            System.out.println(i+" Branch Name: " + branch.getBranchLocation());
            i++;
        }
  
    }
	/**
     * Retrieves BranchStaffList for a specific branch which contains all staff's information.
     *
     * @param branchName The name of the branch for which to retrieve the BranchStaffList.
     * @return The BranchStaffList for the specified branch, or null if not found.
     */
	public ConcreteBranchStaffList getConcreteBranchStaffList(String branchName) {
		for(Branch branch: branches) {
			if(branch.getOutlet().equals(branchName)) {
				return branch.getConcreteBranchStaffList();
			}
		}
		return null;
	}
	/**
    * Adds a new branch to the list of branches.
    *
    * @param location The new branch to be added.
    */
	public void addBranch(Branch location) {
		branches.add(location);
	}


}