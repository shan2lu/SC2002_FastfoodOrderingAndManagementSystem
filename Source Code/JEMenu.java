import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * Represents the menu for the JE branch.
 * Implements the MenuInterface.
 */
public class JEMenu implements MenuInterface {
	
	Scanner sc = new Scanner(System.in);
	public ArrayList<MenuItem> items;
	/**
     * Constructs a new JEMenu object and initializes the list of menu items.
     * Reads menu item data from an Excel file and creates menu items.
     */
	public JEMenu() {
		items = new ArrayList<>();
		MenuItem foodItem;
		String itemName = "";
		double itemPrice = 0.0;
		FoodCategory Cat = null;
		ReadMenuExcel file = new ReadMenuExcel("C:\\Users\\shanshan\\Desktop\\JEMenu.xlsx");
		for(int row=0;row<2;row++) {
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
     * Retrieves the list of menu items for the JE branch.
     *
     * @return The list of menu items.
     */
	public ArrayList<MenuItem> getMenu(){
		return items;
	}

}
