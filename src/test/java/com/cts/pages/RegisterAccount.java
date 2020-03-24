package com.cts.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterAccount {

	public static By enterUsenameLoc = By.id("reg_email");
	public static By enterPasswordLoc = By.id("reg_password");
	public static By clickonRegisterLoc = By.xpath("//input[@value='Register']");
	public static By enteremailLoc = By.id("username");
	public static By enterPassowrdLoc = By.id("password");
	public static By clickonLoginLoc = By.xpath("//input[@name='login']");
	
	
	
	public static void enterUsername(WebDriver driver, String username)
	{
		driver.findElement(enterUsenameLoc).sendKeys(username);
	}
	public static void enterPassword(WebDriver driver, String password)
	{
		driver.findElement(enterPasswordLoc).sendKeys(password);
	}

	public static void clickOnRegister(WebDriver driver)
	{
		driver.findElement(clickonRegisterLoc).click();
	}
	public static void enterEmail(WebDriver driver, String emailname)
	{
		driver.findElement(enteremailLoc).sendKeys(emailname);
	}
	public static void enterLoginPassword(WebDriver driver, String loginpassword)
	{
		driver.findElement(enterPassowrdLoc).sendKeys(loginpassword);
	}
	public static void clickOnLogin(WebDriver driver)
	{
		driver.findElement(clickonLoginLoc).click();
	}
	
}

	
	
			

