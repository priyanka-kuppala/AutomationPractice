package com.cts.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class LogoutAccount {
	
	public static By clickOnLogOutLoc = By.xpath("//a[text()='Logout']");
	public static By clickOnShopLoc = By.xpath("//a[text()='Shop']");
	 public static By clickOnHtmlLoc= By.linkText("HTML");
	 public static By clickOnBookLoc=By.xpath("//img[@title='Mastering HTML5 Forms']");
	 public static By addtoCartLoc=By.xpath("//button[text()='Add to basket']");
	 public static By viewCartLoc=By.xpath("//a[@title='View your shopping cart']");
	private static By demositeLoc = By.linkText("Demo Site");
	private static By removeitemLoc=By.xpath("//a[@title='Remove this item']");
	
	
	public static void clickOnLogOut(WebDriver driver)
	{
		driver.findElement(clickOnLogOutLoc).click();
	}
	public static void clickOnShop(WebDriver driver)
	{
		driver.findElement(clickOnShopLoc).click();
	}
	public static void clickOnHtml(WebDriver driver)
	{
		driver.findElement(clickOnHtmlLoc).click();
	}
	
	public static void clickOnBook(WebDriver driver)
	{
		driver.findElement(clickOnBookLoc).click();
	}
	
	public static void addtoCart(WebDriver driver)
	{
		driver.findElement(addtoCartLoc).click();
	}
	public static void viewCart(WebDriver driver)
	{
		driver.findElement(viewCartLoc).click();
	}
	public static void clickOnDemosite(WebDriver driver)
	{

		driver.findElement(demositeLoc).click();
		}
	public static void removeAnItem(WebDriver driver)
	{
		 driver.findElement(removeitemLoc).click();
	}
	
//	public static String emptyCart(WebDriver drievr,String actual)
//	{
//	actual=driver.findElement(By.xpath)

	

}
