package com.cts.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccount {
	private By clickOnmyAccountLoc = By.xpath("//a[text()='My Account']");
	
	private WebDriver driver;
	public MyAccount(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	public  void clickOnMyAccount()
	{
		driver.findElement(clickOnmyAccountLoc).click();
	}
	

}
