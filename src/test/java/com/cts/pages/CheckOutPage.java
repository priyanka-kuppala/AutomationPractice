package com.cts.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutPage {
	
	
	public static By checkoutLoc=By.xpath("//a[@class='checkout-button button alt wc-forward']");

	public static void clickOnCheckOut(WebDriver driver)
	{
	driver.findElement(checkoutLoc).click();
	}

}
