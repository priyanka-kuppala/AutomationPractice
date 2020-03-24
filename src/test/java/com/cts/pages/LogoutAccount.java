package com.cts.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class LogoutAccount {
	
	private  By clickOnLogOutLoc = By.xpath("//a[text()='Logout']");
	private  By clickOnShopLoc = By.xpath("//a[text()='Shop']");
	 private  By clickOnHtmlLoc= By.linkText("HTML");
	 private  By clickOnBookLoc=By.xpath("//img[@title='Mastering HTML5 Forms']");
	 private  By addtoCartLoc=By.xpath("//button[text()='Add to basket']");
	 private  By viewCartLoc=By.xpath("//a[@title='View your shopping cart']");
	private  By demositeLoc = By.linkText("Demo Site");
	private  By removeitemLoc=By.xpath("//a[@title='Remove this item']");
	
	private WebDriver driver;
	public LogoutAccount(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public  void clickOnLogOut()
	{
		driver.findElement(clickOnLogOutLoc).click();
	}
	public  void clickOnShop()
	{
		driver.findElement(clickOnShopLoc).click();
	}
	public  void clickOnHtml()
	{
		driver.findElement(clickOnHtmlLoc).click();
	}
	
	public  void clickOnBook()
	{
		driver.findElement(clickOnBookLoc).click();
	}
	
	public  void addtoCart()
	{
		driver.findElement(addtoCartLoc).click();
	}
	public  void viewCart()
	{
		driver.findElement(viewCartLoc).click();
	}
	public  void clickOnDemosite()
	{

		driver.findElement(demositeLoc).click();
		}
	public  void removeAnItem()
	{
		 driver.findElement(removeitemLoc).click();
	}
	
//	public static String emptyCart(WebDriver drievr,String actual)
//	{
//	actual=driver.findElement(By.xpath)

	

}
