import java.util.ArrayList; //to implement dynamic arrays
import java.util.List;
import java.util.Scanner;
/**
 * Represents a menu containing food items for JP branch.
 */
public class NTUMenu implements MenuInterface {
	
	Scanner sc = new Scanner(System.in);
	public ArrayList<MenuItem> items;
	/**
     * Constructs a new NTUMenu object and initializes it with items from an Excel file.
     */
	public NTUMenu() {
		items = new ArrayList<>();
		MenuItem foodItem;
		String itemName = "";
		double itemPrice = 0.0;
		FoodCategory Cat = null;
		ReadMenuExcel file = new ReadMenuExcel("C:\\Users\\shanshan\\Desktop\\NTUMenu.xlsx");
		for(int row=0;row<3;row++) {
			for(int col=0;col<3;col++) {
				if(col ==0) {
					itemName = file.ReadInString(row,col);
				}
				else if(col == 1){
					itemPrice = file.ReadInNum(row,col);
				}
				else {
					Cat = file.ReadInCat(row, col);
				}
			}
			MenuItem newItem = new MenuItem(itemName,itemPrice,Cat);
			items.add(newItem);
		}
	}
	/**
     * Retrieves the list of food items in the menu.
     * 
     * @return The list of food items.
     */
	public ArrayList<MenuItem> getMenu(){
		return items;
	}

}
