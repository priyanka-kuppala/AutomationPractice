package com.cts.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class DemoRegisterPage {
	private static By firstNameLoc = By.xpath("//input[@placeholder='First Name']");
	private static By lastNameLoc = By.xpath("//input[@placeholder='Last Name']");
	private static By addressLoc = By.tagName("textarea");
	private static By emailLoc = By.xpath("//input[@type='email']");
	private static By mobileNumLoc = By.xpath("//input[@type='tel']");
	private static By genderLoc = By.xpath("//input[@value='Male']");
	private static By hobbies_1Loc = By.xpath("//input[@value='Cricket']");
	private static By hobbies_2Loc = By.xpath("//input[@value='Movies']");
	private static By langLoc = By.id("msdd");
	private static By lang_1Loc = By.xpath("//a[text()='Arabic']");
	private static By lang_2Loc = By.xpath("//a[text()='English']");
	private static By skillsLoc = By.id("Skills");
	private static By countriesLoc = By.id("countries");
	private static By countries_1Loc = By.id("country");
	private static By yearLoc = By.id("yearbox");
	private static By monthLoc = By.xpath("//select[@placeholder='Month']");
	private static By dayLoc = By.id("daybox");
	private static By passLoc = By.id("firstpassword");
	private static By confrmPassLoc = By.id("secondpassword");
	private static By submitBttnLoc = By.id("submitbtn");

	public static void formFilling(WebDriver driver,String firstName,String lastName ,String address,String email,String num,String skill,
	String workCountry,String presentCountry,String birthYear,String birthMonth,String birthDay,String password,String confirmPass) {
	driver.findElement(firstNameLoc).sendKeys(firstName);

	driver.findElement(lastNameLoc).sendKeys(lastName);

	driver.findElement(addressLoc).sendKeys(address);

	driver.findElement(emailLoc).sendKeys(email);

	driver.findElement(mobileNumLoc).sendKeys(num);

	driver.findElement(genderLoc).click();

	driver.findElement(hobbies_1Loc).click();

	driver.findElement(hobbies_2Loc).click();

	driver.findElement(langLoc).click();


	driver.findElement(lang_1Loc).click();

	driver.findElement(lang_2Loc).click();

	Select skills = new Select(driver.findElement(skillsLoc));
	skills.selectByVisibleText(skill);

	Select country = new Select(driver.findElement(countriesLoc));
	country.selectByVisibleText(workCountry);

	Select country1 = new Select(driver.findElement(countries_1Loc));
	country1.selectByVisibleText(presentCountry);

	Select year = new Select(driver.findElement(yearLoc));
	year.selectByVisibleText(birthYear);

	Select month = new Select(driver.findElement(monthLoc));
	month.selectByVisibleText(birthMonth);

	Select day = new Select(driver.findElement(dayLoc));
	day.selectByVisibleText(birthDay);

	driver.findElement(passLoc).sendKeys(password);

	driver.findElement(confrmPassLoc).sendKeys(confirmPass);

	driver.findElement(submitBttnLoc).click();

	}

	}









