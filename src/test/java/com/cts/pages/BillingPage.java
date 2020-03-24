package com.cts.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BillingPage {
	public static By firstnameLoc=By.id("billing_first_name");
	public static By lastnameLoc=By.id("billing_last_name") ;
	public static By companyLoc=By.id("billing_company");
	public static By emailLoc=By.id("billing_email");
	public static By phonenumLoc=By.id("billing_phone");
	public static By addressLoc= By.name("billing_address_1");
	public static By address2Loc=By.id("billing_address_2");
	public static By cityLoc=By.id("billing_city");
	public static By stateselLoc=By.xpath("(//b[@role='presentation'])[2]");
	public static By enterstateLoc=By.id("s2id_autogen2_search");
	public static By clickonstateLoc=By.id("select2-results-2");
	public static By enterpinLoc=By.id("billing_postcode");
	public static By clickpaymentLoc=By.id("payment_method_cod");
	public static By clickplaceorderLoc=By.id("place_order");
	public static By billtextLoc=By.xpath("//h3[text()='Billing Details']");
	public static By orderText=By.xpath("//p[text()='Thank you. Your order has been received.']");

	public static void enterFirstName(WebDriver driver,String Firstname)
	{
		driver.findElement(firstnameLoc).clear();
	driver.findElement(firstnameLoc).sendKeys( Firstname);
	}
	public static void enterlastName(WebDriver driver,String Lastname)
	{
		driver.findElement(By.id("billing_last_name")).clear();
	driver.findElement(By.id("billing_last_name")).sendKeys(Lastname);
	}

	public static void enterCompany(WebDriver driver,String Company)
	{
		driver.findElement(companyLoc).clear();
	driver.findElement(companyLoc).sendKeys(Company);
	}
	public static void enterEmail(WebDriver driver,String Email)
	{
		driver.findElement(emailLoc).clear();
	driver.findElement(emailLoc).sendKeys(Email);
	}
	public static void enterPhoneNumber(WebDriver driver,String Phonenumber)
	{
		driver.findElement(phonenumLoc).clear();
		driver.findElement(phonenumLoc).sendKeys(Phonenumber);

	}
	public static void enterAddress(WebDriver driver,String Address)
	{
		driver.findElement(addressLoc).clear();
	driver.findElement(addressLoc).sendKeys(Address);
	}
	public static void enterAddress2(WebDriver driver,String address2)
	{
		driver.findElement(address2Loc).clear();
	driver.findElement(address2Loc).sendKeys(address2);
	}
	public static void enterCity(WebDriver driver,String city)
	{
		driver.findElement(cityLoc).clear();
	driver.findElement(cityLoc).sendKeys("chennai");
	}
	public static void clickonStateSelectBox(WebDriver driver)
	{
	driver.findElement(stateselLoc).click();
	}
	public static void enterState(WebDriver driver,String state)
	{
	driver.findElement(enterstateLoc).sendKeys(state);

	}
	public static void clickOnState(WebDriver driver)
	{
	Actions action1 = new Actions(driver);
	action1.moveToElement(driver.findElement(clickonstateLoc)).click().build().perform();
	}
	public static void enterPincode(WebDriver driver,String pincode)
	{
		driver.findElement(enterpinLoc).clear();
	driver.findElement(enterpinLoc).sendKeys(pincode);
	}
	public static void clickOnPayment(WebDriver driver)
	{
	driver.findElement(clickpaymentLoc).click();
	}
	public static void clickOnPlaceOrder(WebDriver driver)
	{
	driver.findElement(clickplaceorderLoc).click();
	}
	public static String  billText(WebDriver driver)
	{
		String actual=driver.findElement(billtextLoc).getText();
		
		return actual;
		
	}
	public static String orderText(WebDriver driver)
	{
		String text=driver.findElement(orderText).getText();
		return text;
	}
	
	
	}


