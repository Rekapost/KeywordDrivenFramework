package utilities;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilities {
	FileInputStream file;
	XSSFWorkbook workbook;
	XSSFSheet sheet;;
	XSSFCell cell;
	public static String locatorColumnValue;
	public static String locatorName;
	public static String locatorValue;
	public static String keywordColumnValue;
	public static String dataColumnValue;
	public static int totalRows;
	public void readExcelFile(String location) throws IOException {
		file= new FileInputStream(location);
		workbook= new XSSFWorkbook(file);
		sheet=workbook.getSheetAt(0);	
		totalRows=sheet.getLastRowNum();
	}
	
	public void getValuesFromExcelLocKeyData(int row, int locatorColumn,int keywordColumn,int dataColumn) {
		/*cell=sheet.getRow(row).getCell(locatorColumn);
		String cellValue=cell.getStringCellValue();*/
		//System.out.println(cellValue);    don't need print , u want to return string value so public string 
		//and return statement
		// TAKE LOCATOR COLUMN
		locatorColumnValue=sheet.getRow(row).getCell(locatorColumn).toString().trim();
		//System.out.println(locatorColumnValue);
		if(!locatorColumnValue.contains("NA")) {
		locatorName=locatorColumnValue.split(":")[0].toString().trim();	
		locatorValue=locatorColumnValue.split(":")[1].toString().trim(); }
		else
		{
		locatorName="NA";
		locatorValue="NA";
		}
		//System.out.println(locatorName +":"+locatorValue);
		//TAKE KEYWORD COLUMN and DATA COLUMN
		keywordColumnValue=sheet.getRow(row).getCell(keywordColumn).toString().trim();
		//System.out.println(keywordColumnValue);
		dataColumnValue=sheet.getRow(row).getCell(dataColumn).toString().trim();
		//System.out.println(dataColumnValue);
		System.out.println(locatorName +  ":" + locatorValue + ":"+ keywordColumnValue + ":" +dataColumnValue);			
		
		/*cell=sheet.getRow(row).getCell(locatorColumn);
		String cellValue=cell.getStringCellValue();*/
		//System.out.println(cellValue);    dont need print , u want to return string value so public string and return statement		
		//return cellValue;
		
		}
		
	/*public static void main(String[]args) throws IOException
	{	ExcelUtilities excelUtilities=new ExcelUtilities();
		excelUtilities.readExcel();	
	}*/		

}