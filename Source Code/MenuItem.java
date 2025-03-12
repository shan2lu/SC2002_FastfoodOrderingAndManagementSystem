import java.util.Scanner;
/**
 * Represents a menu item.
 */
public class MenuItem {
	private String name;
	private double price;
	private int ItemID;
	private FoodCategory Cat;
	private boolean avail;
	private String foodSize = "SMALL"; //default is small
	
	/**
     * Constructs a new MenuItem object with the specified name, price, and category.
     * 
     * @param name The name of the menu item.
     * @param price The price of the menu item.
     * @param Cat The category of the menu item.
     */
	public MenuItem(String name, double price, FoodCategory Cat) {
		this.name = name;
		this.price = price;
		this.Cat = Cat;
		this.avail = true;
	}
	// Getters and setters for each field

    /**
     * Returns the name of the menu item.
     * 
     * @return The name of the menu item.
     */
	public String getName() {
		return name;
	}
	/**
     * Sets the name of the menu item.
     * 
     * @param name The name of the menu item.
     */
	public void setName(String name) {
		this.name = name;
	}
	/**
     * Returns the price of the menu item.
     * 
     * @return The price of the menu item.
     */
	public double getPrice() {
		return price;
	}
	/**
     * Sets the price of the menu item.
     * 
     * @param price The price of the menu item.
     */
	public void setPrice(double price) {
		this.price = price;
	}
	/**
     * Returns the unique ID of the menu item.
     * 
     * @return The unique ID of the menu item.
     */
	public int getItemID() {
		return ItemID;
	}

    /**
     * Sets the unique ID of the menu item.
     * 
     * @param ID The unique ID of the menu item.
     */
	public void setItemID(int ID) {
		this.ItemID =  ID;
	}
	/**
    * Checks if the menu item is available.
    * 
    * @return true if the menu item is available, false otherwise.
    */
	public boolean getItemAvail() {
		return avail;
	}
	/**
     * Marks the menu item as not available.
     */
	public void ItemNotAvail() {
		avail = false;
	}
	/**
     * Returns the size of the menu item.
     * 
     * @return The size of the menu item.
     */
	public String getFoodSize() {
		return foodSize;
	}
	/**
     * Allows customization of the menu item, such as upsizing.
     */
	public void Customisation() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Do you want to upsize? 1)Yes 2)No");
		int choice = sc.nextInt();
		if(choice == 1) {
			foodSize = "LARGE" ;
		}
		
	}

}
