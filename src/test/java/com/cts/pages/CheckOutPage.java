package com.cts.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutPage {
	
	
	private By checkoutLoc=By.xpath("//a[@class='checkout-button button alt wc-forward']");
	
	private WebDriver driver;
	public CheckOutPage(WebDriver driver)
	{
		this.driver=driver;
	}

	public  void clickOnCheckOut()
	{
	driver.findElement(checkoutLoc).click();
	}

}
