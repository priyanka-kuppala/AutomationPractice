package com.cts.pages;

import java.io.File;
import java.sql.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BillingPage {
	private  By firstnameLoc=By.id("billing_first_name");
	private By lastnameLoc=By.id("billing_last_name") ;
	private By companyLoc=By.id("billing_company");
	private By emailLoc=By.id("billing_email");
	private By phonenumLoc=By.id("billing_phone");
	private By addressLoc= By.name("billing_address_1");
	private By address2Loc=By.id("billing_address_2");
	private By cityLoc=By.id("billing_city");
	private By stateselLoc=By.xpath("(//b[@role='presentation'])[2]");
	private By enterstateLoc=By.id("s2id_autogen2_search");
	private By clickonstateLoc=By.id("select2-results-2");
	private By enterpinLoc=By.id("billing_postcode");
	private By clickpaymentLoc=By.id("payment_method_cod");
	private By clickplaceorderLoc=By.id("place_order");
	private By billtextLoc=By.xpath("//h3[text()='Billing Details']");
	private By orderText=By.xpath("//p[text()='Thank you. Your order has been received.']");
	
	private WebDriver driver;
	public BillingPage(WebDriver driver)
	{
		this.driver=driver;
	}

	public  void enterFirstName(String Firstname)
	{
		driver.findElement(firstnameLoc).clear();
	driver.findElement(firstnameLoc).sendKeys( Firstname);
	}
	public  void enterlastName(String Lastname)
	{
		driver.findElement(By.id("billing_last_name")).clear();
	driver.findElement(By.id("billing_last_name")).sendKeys(Lastname);
	}

	public  void enterCompany(String Company)
	{
		driver.findElement(companyLoc).clear();
	driver.findElement(companyLoc).sendKeys(Company);
	}
	public  void enterEmail(String Email)
	{
		driver.findElement(emailLoc).clear();
	driver.findElement(emailLoc).sendKeys(Email);
	}
	public  void enterPhoneNumber(String Phonenumber)
	{
		driver.findElement(phonenumLoc).clear();
		driver.findElement(phonenumLoc).sendKeys(Phonenumber);

	}
	public  void enterAddress(String Address)
	{
		driver.findElement(addressLoc).clear();
	driver.findElement(addressLoc).sendKeys(Address);
	}
	public  void enterAddress2(String address2)
	{
		driver.findElement(address2Loc).clear();
	driver.findElement(address2Loc).sendKeys(address2);
	}
	public  void enterCity(String city)
	{
		driver.findElement(cityLoc).clear();
	driver.findElement(cityLoc).sendKeys("chennai");
	}
	public  void clickonStateSelectBox()
	{
	driver.findElement(stateselLoc).click();
	}
	public  void enterState(String state)
	{
	driver.findElement(enterstateLoc).sendKeys(state);

	}
	public  void clickOnState()
	{
	Actions action1 = new Actions(driver);
	action1.moveToElement(driver.findElement(clickonstateLoc)).click().build().perform();
	}
	public  void enterPincode(String pincode)
	{
		driver.findElement(enterpinLoc).clear();
	driver.findElement(enterpinLoc).sendKeys(pincode);
	}
	public  void clickOnPayment()
	{
	driver.findElement(clickpaymentLoc).click();
	}
	public  void clickOnPlaceOrder()
	{
	driver.findElement(clickplaceorderLoc).click();
	}
	public  String  billText()
	{
		String actual=driver.findElement(billtextLoc).getText();
		
		return actual;
		
	}
	public  String orderText()
	{
		String text=driver.findElement(orderText).getText();
		return text;
	}
	public void screenShot()
	{
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File file=ts.getScreenshotAs(OutputType.FILE);
		file.renameTo(new File("src/test/resources/screenshot.png"));
		
	}
	
	}


