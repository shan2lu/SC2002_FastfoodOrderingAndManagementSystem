import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * Utility class for reading data from an Excel file.
 */
public class ReadStaffExcel {
	String fileLocation;
	/**
     * Constructs a ReadMenuExcel object with the specified file location.
     *
     * @param fileLocation The location of the Excel file to read.
     */
	public ReadStaffExcel(String fileLocation) {
		this.fileLocation = fileLocation;
	}
	/**
     * Reads a string value from the specified row and column in the Excel file.
     *
     * @param rNum The row number (0-based index).
     * @param cNum The column number (0-based index).
     * @return The string value read from the Excel file.
     */
	public String ReadInString(int rNum, int cNum) {
		String data = "";
		try {
			FileInputStream fis = new FileInputStream(fileLocation);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet s = wb.getSheetAt(0);
			Row r = s.getRow(rNum);
			Cell c = r.getCell(cNum);
			data = c.getStringCellValue();

		}catch(Exception e) {
			System.out.println("File error!");
			e.printStackTrace();
		}
		return data;
	}
	/**
     * Reads a string value from the specified row and column in the Excel file.
     *
     * @param rNum The row number (0-based index).
     * @param cNum The column number (0-based index).
     * @return The string value read from the Excel file.
     */
	public int ReadInNum(int rNum, int cNum) {
		int data = 0;
		try {
			FileInputStream fis = new FileInputStream(fileLocation);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet s = wb.getSheetAt(0);
			Row r = s.getRow(rNum);
			Cell c = r.getCell(cNum);
			data = (int) c.getNumericCellValue();

		}catch(Exception e) {
			System.out.println("File error!");
			e.printStackTrace();
		}
		return data;
		
	}
}