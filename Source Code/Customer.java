import java.util.Scanner;

import java.util.ArrayList;
import java.util.List;
/**
 * The Customer class represents a customer placing an order at a specific branch of a restaurant.
 * Customer can interact with the menu, add items to a cart, view the cart, and check out.
 * The customer can choose between dining in or taking away.
 */

public class Customer implements ICustomer{
	Scanner sc = new Scanner(System.in);
	private NewOrder Order;
	private int eatingOption;
	int CheckedOut = 0;
	private Cart Ca;
	Branch selectedBranch;
	private PaymentManagement pm;
	/**
     * Constructs a Customer object with a selected branch.
     *
     * @param selectedBranch The branch selected by the customer
     */
	public Customer(Branch selectedBranch, PaymentManagement pm) {
		Ca = new Cart();
		this.selectedBranch = selectedBranch;
		this.pm = pm;
	}
	/**
     * Starts the order process by displaying the branch menu and prompting the customer for choices.
     */
	public void start() {
		System.out.println("Do you want to 1)Dine in or 2)Take-away");
		eatingOption = sc.nextInt();
		System.out.println("-------Branch Menu------");
        //Display branch's menu
		selectedBranch.displayMenu();
		//Display options for managing cart
		System.out.println("Do you want: ");
		System.out.println("1)Add Item to cart");
		System.out.println("2)Remove Item from cart");
		System.out.println("3)View cart");
		System.out.println("4)Check out");
		System.out.println("5)quit");
		int CartChoice = sc.nextInt();
		do {
			switch(CartChoice) {
			case 1:
				AddItemToCart();
				break;
			case 2:
				Ca.RemoveItem();
				break;
			case 3:
				displayCart();
				break;
			case 4:
				checkingOut();
				if(CheckedOut == 1) {
					return;
				}
				break;
			default:
				System.out.println("quitting");
				break;
			}
			System.out.println("Do you want: ");
			System.out.println("1)Add Item to cart");
			System.out.println("2)Remove Item from cart");
			System.out.println("3)View cart");
			System.out.println("4)Check out");
			System.out.println("5)quit");
			CartChoice = sc.nextInt();
		}while(CartChoice <5);
	}
	/**
     * Displays the items in the customer's cart.
     */
	public void displayCart() {
		Ca.Display();
	}
	 /**
     * Allows the customer to add items to the cart based on the branch menu.
     */
	public void AddItemToCart(){
		while(true) {
			System.out.println("Key in the number to add item, Enter 0 to stop adding");
			int ItemChoice = sc.nextInt()-1;
			if(ItemChoice == -1) {
				break;
			}
			Ca.AddItem(selectedBranch.getBranchMenu(), ItemChoice);
		}
	}
	
	/**
     * Initiates the checkout process for the customer's cart.
     * Creates an order which is added to branch's order list, and prints a receipt.
     */
	public void checkingOut() {
		if(Ca.CalTotal() == 0) {
			System.out.println("Cart is empty! Please add items!");
			return;
		}
		CheckOut Out = new CheckOut(Ca.CalTotal(),Ca.getCart());
		Out.ProceedToPayment(pm);
		Order = Out.CreateOrder();
		selectedBranch.addOrderToBranchList(Order);
		if(Order.getOrderID() == 0) {
			System.out.println("Unable to create order!!");
			return;
		}
		Out.printReceipt(eatingOption,Order.getOrderID());
		CheckedOut = 1;
	}
	
}
