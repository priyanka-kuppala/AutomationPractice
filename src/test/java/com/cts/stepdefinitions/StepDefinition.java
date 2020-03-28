package com.cts.stepdefinitions;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.cts.pages.BillingPage;
import com.cts.pages.CheckOutPage;
import com.cts.pages.LogoutAccount;
import com.cts.pages.MyAccount;
import com.cts.pages.RegisterAccount;
import com.cts.utils.ReadExcel;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition {
	WebDriver driver;

	@Before
	public void enter() {
		// setting properties to launch browser
		System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
		System.out.println("Given");
		// To launch chrome driver
		driver = new ChromeDriver();
		// To maximize the window
		driver.manage().window().maximize();
		// providing impilcit wait of 40 seconds to all find element
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	}

	@After
	public void end() {
		Date date = new Date();
		String dateStr = date.toString().replace(":", "-");
		// To take screensheet
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		// To save the screenshot into file
		File file = screenshot.getScreenshotAs(OutputType.FILE);
		// Renaming the file
		file.renameTo(new File("src/test/resources/screenshot" + dateStr + ".png"));
		//To close the window
		driver.quit();

	}

	@Given("User launch the browser with practiceautomationtestingPage")
	public void user_launch_the_browser_with_practiceautomationtestingPage() {
// Getting the link to launch in chrome driver
		driver.get("http://practice.automationtesting.in/");
	}

//---scenario 1 add an item to the cart---
	@When("I enter login details from Excel {string} with SheetName {string}")
	public void i_enter_login_details_from_Excel_with_SheetName(String filedetails, String sheetname)
			throws IOException {
		//Taking the data form excel
		String data[][] = ReadExcel.getSheetIntoStringArray("src/test/resources/resources/Book1.xlsx",
				"LoginCredentials");
		// click on myaccount
		MyAccount myAccount = new MyAccount(driver);
		myAccount.clickOnMyAccount();
		//enter email in textbox
		RegisterAccount registerAccount = new RegisterAccount(driver);
		registerAccount.enterEmail(data[0][0]);
		//enter password in text box
		registerAccount.enterLoginPassword(data[0][1]);

	}

	@When("click on login button")
	public void click_on_login_button() {
		//click on login button
		RegisterAccount registerAccount = new RegisterAccount(driver);
		registerAccount.clickOnLogin();
	}

	@When("I click on shop")
	public void i_click_on_shop() {
		LogoutAccount logoutAccount = new LogoutAccount(driver);
		//click on shop
		logoutAccount.clickOnShop();
	}

	@When("I select a book")
	public void i_select_a_book() {
		
		LogoutAccount logoutAccount = new LogoutAccount(driver);
		//click on shop
		logoutAccount.clickOnShop();
		//click on html books
		logoutAccount.clickOnHtml();
		//click on particular html book
		logoutAccount.clickOnBook();
	}

	@When("I click on the add to basket button")
	public void i_click_on_the_add_to_basket_button() {
		LogoutAccount logoutAccount = new LogoutAccount(driver);
		//add an item to the cart
		logoutAccount.addtoCart();
		//view the cart
		logoutAccount.viewCart();

	}

	@Then("Item should be added to the view cart")
	public void item_should_be_added_to_the_view_cart() {
		//getting particular text from pagesource
		String pageSource = driver.getPageSource();
		boolean check = pageSource.contains("HTML5 Forms");
		//assertion check getting text from pagesource
		Assert.assertTrue("Not Passed", check);
		
	}

	
	// ---scenario 2 remove an item form the cart----
	@When("I click on login button and enter loginusername as {string} and I enter loginpassword as {string}")
	public void i_click_on_login_button_and_enter_loginusername_as_and_I_enter_loginpassword_as(String emailname,
			String loginpassword) {

		MyAccount myAccount = new MyAccount(driver);
		//click on myaccount
		myAccount.clickOnMyAccount();
		RegisterAccount registerAccount = new RegisterAccount(driver);
		//enter email
		registerAccount.enterEmail(emailname);
		//enter password
		registerAccount.enterLoginPassword(loginpassword);

	}

	@When("I delete from cart")
	public void i_delete_from_cart() {
		LogoutAccount logoutAccount = new LogoutAccount(driver);
		//click on shop
		logoutAccount.clickOnShop();
		//click on html books
		logoutAccount.clickOnHtml();
		//click on particular html book
		logoutAccount.clickOnBook();
		//add an item to the cart
		logoutAccount.addtoCart();
		//viewing the cart
		logoutAccount.viewCart();
		//removing an item
		logoutAccount.removeAnItem();

	}

	@Then("Item should be removed from the view cart")
	public void item_should_be_removed_from_the_view_cart() {
		LogoutAccount logoutAccount = new LogoutAccount(driver);
		//getting the text and storing in the string variable
		String actual = logoutAccount.emptyCart();
		//comparing actual with expected
		String expected = "Your basket is currently empty.";
		//assert check if both are equal scenario is passed
		Assert.assertEquals(expected, actual);
		//printing the text
		System.out.println(actual);
		//close the current window
		
	}

	// --scenario 3 click on proceed to checkout--
	@When("I click on proceed to checkout")
	public void i_click_on_proceed_to_checkout() throws InterruptedException {
		LogoutAccount logoutAccount = new LogoutAccount(driver);
//click on shop
		logoutAccount.clickOnShop();
		Thread.sleep(5000);
		//click on html
		logoutAccount.clickOnHtml();
		Thread.sleep(5000);
		//click on book
		logoutAccount.clickOnBook();
		Thread.sleep(5000);
		//add an item to cart
		logoutAccount.addtoCart();
		Thread.sleep(5000);
		//viewing the cart
		logoutAccount.viewCart();
		Thread.sleep(5000);
		//click on checkout button
		CheckOutPage checkOutPage = new CheckOutPage(driver);
		checkOutPage.clickOnCheckOut();

	}

	@Then("It should navigate to the next page")
	public void it_should_navigate_to_the_next_page() {
		BillingPage billingPage = new BillingPage(driver);
		//getting the title from the page
		String actualText = billingPage.billText();
		//comparing actual to expected
		String expectedTitle = "Billing Details";
		//assertion to check the titles
		Assert.assertEquals(expectedTitle, actualText);
		//printing the title
		System.out.println(actualText);
		//close the current window
		

	}

	// --scenario 4 fill details in billing page--
	@When("It should navigate to the billing page with details")
	public void it_should_navigate_to_the_billing_page_with_details(io.cucumber.datatable.DataTable dataTable)
			throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
		// Map<K, List<V>>. E,K,V must be a String, Integer, Float,
		// Double, Byte, Short, Long, BigInteger or BigDecimal.
		//
		// For other transformations you can register a DataTableType.
		BillingPage billingPage = new BillingPage(driver);
		//entering the details through data table
		List<Map<String, String>> data = dataTable.asMaps();
		Thread.sleep(5000);
		//enter first name
		billingPage.enterFirstName(data.get(0).get("firstname"));
		Thread.sleep(5000);
		//enter lastname
		billingPage.enterlastName(data.get(0).get("lastname"));
		Thread.sleep(5000);
		//enter company name
		billingPage.enterCompany(data.get(0).get("companyname"));
		Thread.sleep(5000);
		//enter email
		billingPage.enterEmail(data.get(0).get("email"));
		Thread.sleep(5000);
		//enter phone number
		billingPage.enterPhoneNumber(data.get(0).get("phonenumber"));
		Thread.sleep(5000);
		//enter address
		billingPage.enterAddress(data.get(0).get("address"));
		Thread.sleep(5000);
		//enter address2
		billingPage.enterAddress2(data.get(0).get("address2"));
		Thread.sleep(5000);
		//enter city
		billingPage.enterCity(data.get(0).get("town"));
		Thread.sleep(5000);
		//click on state to select the state from selection box
		billingPage.clickonStateSelectBox();
		Thread.sleep(5000);
		//enter state in textbox
		billingPage.enterState(data.get(0).get("state"));
		Thread.sleep(5000);
		//select state form select box
		billingPage.clickOnState();
		Thread.sleep(5000);
		//enter pincode
		billingPage.enterPincode(data.get(0).get("pincode"));
		Thread.sleep(5000);
		//click on payment
		billingPage.clickOnPayment();

	}

	@Then("I should get filled form")
	public void i_should_get_filled_form() {
		//getting the contains text from page source
		String pageSource = driver.getPageSource();
		boolean check = pageSource.contains("Checkout");
		//assert to check the text in the page
		Assert.assertTrue("Not Passed", check);
		System.out.println("then");
		//close the current window
		
	}

// --scenario 5 place order--
	@When("I click on the place order")
	public void i_click_on_the_place_order() throws InterruptedException {
		BillingPage billingPage = new BillingPage(driver);
		Thread.sleep(5000);
		//click on place order
		billingPage.clickOnPlaceOrder();

	}

	@Then("I should get the message as orderplaced")
	public void i_should_get_the_message_as_orderplaced() {
		BillingPage billingPage = new BillingPage(driver);
		String ordText = billingPage.orderText();
		// assertion to check the page is loaded 
		Assert.assertEquals("Thank you. Your order has been received.", ordText);
		//print the text
		System.out.println(ordText);
		// To close the current window
		

	}

}