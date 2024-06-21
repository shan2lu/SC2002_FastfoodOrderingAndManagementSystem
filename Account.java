/**
 * Represents an account that staffs will have.
 * It contains information about the account holder.
 */
public class Account {
	private String loginUsername;
	private String loginPassword= "password";
	private String Name;
	private int age;
	private String gender;
	private String role;
	private String Branch;
	private String OutLet;
	 /**
     * Constructs an `Account` object with the specified parameters.
     *
     * @param Name           The name of the account holder
     * @param age            The age of the account holder
     * @param gender         The gender of the account holder
     * @param loginusername  The username to log in
     * @param outlet         The outlet associated with the account
     * @param role           The role of the account holder
     */
	public Account(String Name, int age,String gender, String loginusername,String outlet,String role) {
		this.Name=Name;
		this.age=age;
		this.gender=gender;
		this.loginUsername=loginusername;
		this.OutLet = outlet;
		this.role = role;
	}

	/**
     * getters
     */
    public String getRole() {return role;}
    public String getName() {return Name;}
    public int getAge() {return age;}
    public String getGender() {return gender;}
	public String getUsername() {return loginUsername;}
	public String getPassword(){return loginPassword;}
	public String getBranch() {return Branch;}
	public String getOutlet() {return OutLet;}
	/**
     * setters
     */
	public void setName(String Name) {
		this.Name=Name;
	}
	public void setAge(int age) {
		this.age=age;
	}
	public void setGender(String gender2) {
		this.gender=gender2;
	}
	public void setLoginUsername(String loginUsername) {
		this.loginUsername=loginUsername;
	}
	public void setRole(String role) {
		this.role=role;
	}
	public void setBranch(String Branch) {
		this.Branch=Branch;
	}
	
	public void setPassword(String Password) {
		loginPassword=Password;
	}
	/**
     * Prints the staff information of a staff
     */
	public void getStaffInfo() {
	    	System.out.println(getName()+" " + getAge() +" "+ getGender()+" "+getUsername()+" "+getRole()+" "+getOutlet());
	}
	
	
	
}


