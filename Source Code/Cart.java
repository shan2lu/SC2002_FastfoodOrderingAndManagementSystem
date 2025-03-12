import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
/**
 * Customer's cart.
 */
public class Cart {
	private ArrayList<MenuItem> ItemAdded ;
	Scanner sc = new Scanner(System.in);
	/**
     * Constructs a new Cart object with an empty ArrayList to store menu items.
     */
	public Cart() {
		ItemAdded = new ArrayList<>();
	}
	/**
     * Removes a menu item from the cart.
     * Displays the current cart contents and prompts the user to select an item to remove.
     * Selected item will then be deleted accordingly
     */
	public void RemoveItem(){
		Display();
		int choice;
		System.out.println("Select the item you want to remove");
		choice = sc.nextInt();
		ItemAdded.remove(choice-1);	
		
	}
	/**
     * Displays the current contents of the cart by printing item name,size and price.
     */
	public void Display() {
		int j=1;
		System.out.println("Your Cart");
		System.out.println("Item---------------------Price");
		for(MenuItem item: ItemAdded) {
			System.out.println(j+") "+item.getName()+"("+item.getFoodSize()+")"+"     "+item.getPrice());
			j++;
		}
	}
	/**
     * Adds a menu item to the cart.
     * 
     * @param Me A list of menu items which is a menu
     * @param ItemChoice The index of the item to be added from the menu list.
     */
	public void AddItem(List <MenuItem> Me, int ItemChoice) {
		MenuItem toAdd;
		toAdd = Me.get(ItemChoice);
		if(toAdd.getItemAvail() == true) {
			toAdd.Customisation();
			ItemAdded.add(toAdd);	
		}
		else {
			System.out.println("Item is not available!");
		}
	}
	/**
     * Calculates the total cost of all items in the cart during checkout.
     *
     * @return The total cost of items in the cart.
     */
	public double CalTotal() {
		double sum=0;
		for(MenuItem item: ItemAdded) {
			sum = sum + item.getPrice();
		}
		return sum;
		
	}
	/**
     * Retrieves the list of menu items in the cart.
     *
     * @return The ArrayList of menu items in the cart when other classes requires access of cart items of a customer.
     */
	public ArrayList<MenuItem> getCart() {
		return ItemAdded;
	}
}
