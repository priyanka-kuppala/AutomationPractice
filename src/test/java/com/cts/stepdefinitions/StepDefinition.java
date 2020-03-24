package com.cts.stepdefinitions;

import java.io.File;
import java.sql.Date;
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

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class StepDefinition {
	WebDriver driver;

	@Given("User launch the browser with practiceautomationtestingPage")
	public void user_launch_the_browser_with_practiceautomationtestingPage() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
		System.out.println("Given");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("http://practice.automationtesting.in/");

	}

//scenario 1 add an item to the cart
	@When("I click on login button and enter loginusername as {string} and I enter loginpassword as {string}")
	public void i_click_on_login_button_and_enter_loginusername_as_and_I_enter_loginpassword_as(String emailname,
			String loginpassword) {
		MyAccount.clickOnMyAccount(driver);
		RegisterAccount.enterEmail(driver, emailname);
		RegisterAccount.enterLoginPassword(driver, loginpassword);
		
	}

	@When("click on login button")
	public void click_on_login_button() {
		RegisterAccount.clickOnLogin(driver);
	}

	@When("I click on shop")
	public void i_click_on_shop() {
		LogoutAccount.clickOnShop(driver);
	}

	@When("I select a book")
	public void i_select_a_book() {
		LogoutAccount.clickOnShop(driver);
		LogoutAccount.clickOnHtml(driver);
		LogoutAccount.clickOnBook(driver);
	}

	@When("I click on the add to basket button")
	public void i_click_on_the_add_to_basket_button() {

		LogoutAccount.addtoCart(driver);
		LogoutAccount.viewCart(driver);

	}

	@Then("Item should be added to the view cart")
	public void item_should_be_added_to_the_view_cart() {
		System.out.println("then");
		
		
	}

	// scenario 2 remove an item form the cart
	@When("I delete from cart")
	public void i_delete_from_cart() {
		LogoutAccount.clickOnShop(driver);
		 LogoutAccount.clickOnHtml(driver);
		   LogoutAccount.clickOnBook(driver);
		   LogoutAccount.addtoCart(driver);
		   LogoutAccount.viewCart(driver);
		LogoutAccount.removeAnItem(driver);

	}

	@Then("Item should be removed from the view cart")
	public void item_should_be_removed_from_the_view_cart() {
		System.out.println("then");
	}

	// scenario 3 click on proceed to checkout
	@When("I click on proceed to checkout")
	public void i_click_on_proceed_to_checkout() {
		
		LogoutAccount.clickOnShop(driver);
		LogoutAccount.clickOnHtml(driver);
		LogoutAccount.clickOnBook(driver);
		LogoutAccount.addtoCart(driver);
		LogoutAccount.viewCart(driver);
		CheckOutPage.clickOnCheckOut(driver);

	}

	@Then("It should navigate to the next page")
	public void it_should_navigate_to_the_next_page() {
	   String actualText=BillingPage.billText(driver);
	   String expectedTitle="Billing Details";
	   Assert.assertEquals(expectedTitle,actualText);
	   
	}

	// scenario 4 fill details
	@When("It should navigate to the billing page with details")
	public void it_should_navigate_to_the_billing_page_with_details(io.cucumber.datatable.DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
	 	
			List<Map<String, String>> data = dataTable.asMaps();
			BillingPage.enterFirstName(driver, data.get(0).get("firstname"));
			BillingPage.enterlastName(driver, data.get(0).get("lastname"));
			BillingPage.enterCompany(driver, data.get(0).get("companyname"));
			BillingPage.enterEmail(driver, data.get(0).get("email"));
			BillingPage.enterPhoneNumber(driver, data.get(0).get("phonenumber"));
			BillingPage.enterAddress(driver, data.get(0).get("address"));
			BillingPage.enterAddress2(driver, data.get(0).get("address2"));
		BillingPage.enterCity(driver, data.get(0).get("town"));
			BillingPage.clickonStateSelectBox(driver);
		BillingPage.enterState(driver, data.get(0).get("state"));
			BillingPage.clickOnState(driver);
			BillingPage.enterPincode(driver, data.get(0).get("pincode"));
			BillingPage.clickOnPayment(driver);
			

	}

	@Then("I should get filled form")
	public void i_should_get_filled_form() {
	    System.out.println("then");
	}

	

	@When("I click on the place order")
	public void i_click_on_the_place_order() {
		BillingPage.clickOnPlaceOrder(driver);
		 
	}

	@Then("I should get the message as orderplaced")
	public void i_should_get_the_message_as_orderplaced() {
		
		String ordText=BillingPage.orderText(driver);
		String expected="Thank you. Your order has been received.";
		Assert.assertEquals(expected, ordText);
		System.out.println(ordText);
		
		
		 
	}



	}