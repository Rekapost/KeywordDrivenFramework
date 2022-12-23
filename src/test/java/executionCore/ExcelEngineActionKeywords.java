package executionCore;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.openqa.selenium.By;
import actionKeywords.ActionKeywords;
import constants.Constants;
import utilities.ExcelUtilities;
import utilities.Locators;

// reflection api is used to reduce code size and maintaining code 
//in calling all the methods in class and storing 
//and comparing with excel keyword and execute functions 
//used when modification in keywords LIKE if else 
public class ExcelEngineActionKeywords 
{
// integrate excel action keyword with functions in ActionKeywords and run
	ActionKeywords actionKeywords;
	
	Method[] methods;
	//public static String keyword;
	public static By locator;
	//public void getKeywordsFromActions() 
	//creating a constructor, so object is created ,so constructor is called and method will work 
	public ExcelEngineActionKeywords()
		{	
		actionKeywords= new ActionKeywords()	;
		methods=actionKeywords.getClass().getMethods();	
		}
	
	public void executeKeywords() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		for (int i=0;i<methods.length;i++) {
		//if (methods[i].getName().equalsIgnoreCase(keyword))
		if (methods[i].getName().equalsIgnoreCase(ExcelUtilities.keywordColumnValue))
		{methods[i].invoke(actionKeywords);
		break;
		}
	}
}
	public void findWebElementsToBeUsed() {
		switch (ExcelUtilities.locatorName) {
		case Constants.XPATH:
			locator=Locators.getXpath(ExcelUtilities.locatorValue);
			break;

		default:
			break;
		}
		/*
		switch(ExcelUtilities.locatorName) {
		case "xpath":
			locator=Locators.getXpath(ExcelUtilities.locatorValue);
			break;
	// SAME FOR ALL
		
		case "id":
			locator=Locators.getId(ExcelUtilities.locatorValue);		
					break;
		case "name":
			locator=Locators.getName(ExcelUtilities.locatorValue);
			break;
		case "ClasName":
			locator=Locators.getClassName(ExcelUtilities.locatorValue);
			break;
		case "linkText":
			locator=Locators.getLinkText(ExcelUtilities.locatorValue);
			break;
		case "partialLinkText":
			locator=Locators.getPartialLinkText(ExcelUtilities.locatorValue);
			break;
		case "tagName":	
			locator=Locators.getTagName(ExcelUtilities.locatorValue);
			break;
		case "cssSlector":
			locator=Locators.getCssSelector(ExcelUtilities.locatorValue);
			break;
		default:
			break;*/
	}
	
	public static void main(String[]args) throws IOException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		ExcelUtilities excelUtilities=new ExcelUtilities();
		//excelUtilities.readExcelFile("C:\\Users\\Reka\\Desktop\\New\\Eclipse\\TestDataCore.xlsx");
		excelUtilities.readExcelFile(Constants.EXCEL_LOCATION);
		ExcelEngineActionKeywords engine=new ExcelEngineActionKeywords();
		//engine.getKeywordsFromActions();     object creating and calling 
		//int locatorColumn=3;
		//int keywordColumn=	locatorColumn+1;  // or 4	
		//int dataColumn=locatorColumn+2; // or 5
		for(int row=1;row<=ExcelUtilities.totalRows; row++)
		{
		//keyword=excelUtilities.getValuesFromExcelLocKeyData(row,locatorColumn ,keywordColumn,dataColumn);
		excelUtilities.getValuesFromExcelLocKeyData(row,Constants.LOCATOR_COLUMN ,Constants.KEYWORD_COLUMN,Constants.DATA_COLUMN);
		//engine.executeKeywords();    //engine is object
		engine.findWebElementsToBeUsed();
		engine.executeKeywords(); 
		/*
		
		//if (keyword.equals("openBrowser"));
		if(keyword.equalsIgnoreCase("openBrowser"))	
		{ActionKeywords.openBrowser();}
		else if(keyword.equals("goToUrl"))
		{ActionKeywords.goToUrl();}
		else if(keyword.equals("enterUsername"))
		{ActionKeywords.enterUsername();}
		else if(keyword.equals("enterPassword"))
		{ActionKeywords.enterPassword();}
		else if(keyword.equals("clickLogin"))
		{ActionKeywords.clickLogin();}
		else if(keyword.equals("customer"))
		{ActionKeywords.customer();}
		else if(keyword.equals("customerMenuItem"))
		{ActionKeywords.customerMenuItem();}
		else if(keyword.equals("customerAdd"))
		{ActionKeywords.customerAdd();}
		else if(keyword.equals("emailAdd"))
		{ActionKeywords.emailAdd();}
		else if(keyword.equals("firstName"))
		{ActionKeywords.firstName();}
		else if(keyword.equals("lastName"))
		{ActionKeywords.lastName();}
		else if(keyword.equals("saveCustomer"))
		{ActionKeywords.saveCustomer();}
		*/
		}
	}
}
