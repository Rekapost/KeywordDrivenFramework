package actionKeywords;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import constants.Constants;
import executionCore.ExcelEngineActionKeywords;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ExcelUtilities;
import utilities.Locators;

public class ActionKeywords {
static WebDriver driver;
	//oepnBrowser()
	public static void openBrowser()	{
		if(ExcelUtilities.dataColumnValue.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Reka\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		}
		/*
		// u can use webdrivermanager dependency to open any browser
		switch (ExcelUtilities.dataColumnValue) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			break;
		case "safari":
			WebDriverManager.safaridriver().setup();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			break;
		default:
			WebDriverManager.chromedriver().setup();
			break;
		}
		*/
	}
	
	//goToUrl()
	public static void goToUrl()	{
		driver.get(ExcelUtilities.dataColumnValue);
	}
	//enterUsername()
	public static void enterUsername()	{
		WebElement username=driver.findElement(ExcelEngineActionKeywords.locator);
		username.clear();
		username.sendKeys(ExcelUtilities.dataColumnValue); 
	}
	//enterPassword()
	public static void enterPassword()	{
		WebElement password=driver.findElement(ExcelEngineActionKeywords.locator);
		password.clear();
		password.sendKeys(ExcelUtilities.dataColumnValue);
	}
	//clickLogin()
	public static void click()	{
		WebElement login=driver.findElement(ExcelEngineActionKeywords.locator);
		login.click();
	}
	//   keeping only one click function for all 
	//customersMain()
	public static void clickcustomer()	{
		WebElement customerMain=driver.findElement(ExcelEngineActionKeywords.locator);
		customerMain.click();
	}
	//customerMenuItem()
	public static void clickcustomerMenuItem() 	{
		WebElement customerItem=driver.findElement(ExcelEngineActionKeywords.locator);
		customerItem.click();
	}
	//addCustomer()
	public static void clickcustomerAdd(){
		 WebElement newCustomer=driver.findElement(ExcelEngineActionKeywords.locator);
		 newCustomer.click();
	 }
	//addEmail()
	public static void enteremailAdd(){
		 WebElement addEMAIL=driver.findElement(ExcelEngineActionKeywords.locator);
		 addEMAIL.sendKeys(ExcelUtilities.dataColumnValue);
	}
	//addFirstName()
	public static void enterfirstName() {
		WebElement firstNameEnter=driver.findElement(ExcelEngineActionKeywords.locator);
		firstNameEnter.sendKeys(ExcelUtilities.dataColumnValue);
	}
	//addLastName()
	public static void enterlastName() {
		WebElement firstNameEnter=driver.findElement(ExcelEngineActionKeywords.locator);
		firstNameEnter.sendKeys(ExcelUtilities.dataColumnValue);
	}
	
	//saveCustomer()
	public static void clicksaveCustomer() {
		WebElement savebuton=driver.findElement(ExcelEngineActionKeywords.locator);
		savebuton.click();
	}
}
