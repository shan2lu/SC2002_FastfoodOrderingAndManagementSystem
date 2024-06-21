import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
/**
 * Represents the checkout process for a customer's order.
 */
public class CheckOut {
	Scanner sc = new Scanner(System.in);
	boolean paid;
	double total;
	private ArrayList<MenuItem> CartItems;
	
	/**
     * Constructs a new CheckOut object when customer is ready to checkout.
     *
     * @param total The total cost of the order.
     * @param list  The list of menu items in the cart.
     */
	public CheckOut(double total, ArrayList<MenuItem> list) {
		this.total = total;
		this.CartItems = list;
	}
	
	/**
     * Initiate the payment process for the order.
     * Displays available payment methods and processes the payment based on the customer's choice.
     */
	public void ProceedToPayment(PaymentManagement pm) {
		PaymentMethod payment;
		pm.displayPaymentMethods();
		int choice = sc.nextInt();
		payment = pm.getAllPayment().get(choice-1);	
		payment.processPayment(total);
		paid = true;
	}
	/**
     * Creates a new order based on the current cart and payment status.
     *
     * @return A new NewOrder object if payment is successful, otherwise null and checkout will fail.
     */
	public NewOrder CreateOrder() {
		if(paid) {
			NewOrder orderCreated = new NewOrder(CartItems);
			return orderCreated;
		}
		else {
			return null;
		}
	}
	 /**
     * Prints a receipt for the order.
     *
     * @param eatingOption The option for dining in or taking away the order.
     * @param orderID      The unique identifier for a order, each NewOrder will have one id
     */
	public void printReceipt(int eatingOption,int orderID) {
		int j=1;
		System.out.println("Receipt");
		System.out.println("-----------------------");
		System.out.println("Your order ID is "+ orderID);
		if(eatingOption == 1) {
			System.out.println("Dine in");
		}
		else {
			System.out.println("Take-away");
		}
		
		System.out.println("Item-------Size------------Price");
		for(MenuItem item: CartItems) {
			System.out.println(j+") "+item.getName()+"("+item.getFoodSize()+")"+"     "+item.getPrice());
			j++;
		}
		System.out.println("Total----------------------"+String.format("%.2f", total));	
	}
	
	
}
