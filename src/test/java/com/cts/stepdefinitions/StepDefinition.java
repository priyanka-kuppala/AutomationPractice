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
		MyAccount myAccount= new MyAccount(driver);
		myAccount.clickOnMyAccount();
		RegisterAccount registerAccount=new RegisterAccount(driver);
		registerAccount.enterEmail(emailname);
		registerAccount.enterLoginPassword(loginpassword);
		
	}

	@When("click on login button")
	public void click_on_login_button() {
		RegisterAccount registerAccount=new RegisterAccount(driver);
		registerAccount.clickOnLogin();
	}

	@When("I click on shop")
	public void i_click_on_shop() {
		LogoutAccount logoutAccount=new LogoutAccount(driver);
		logoutAccount.clickOnShop();
	}

	@When("I select a book")
	public void i_select_a_book() {
		LogoutAccount logoutAccount=new LogoutAccount(driver);
		logoutAccount.clickOnShop();
		logoutAccount.clickOnHtml();
		logoutAccount.clickOnBook();
	}

	@When("I click on the add to basket button")
	public void i_click_on_the_add_to_basket_button() {
		LogoutAccount logoutAccount=new LogoutAccount(driver);
		logoutAccount.addtoCart();
		logoutAccount.viewCart();

	}

	@Then("Item should be added to the view cart")
	public void item_should_be_added_to_the_view_cart() {
		System.out.println("then");
		
		
	}

	// scenario 2 remove an item form the cart
	@When("I delete from cart")
	public void i_delete_from_cart() {
		LogoutAccount logoutAccount=new LogoutAccount(driver);
		logoutAccount.clickOnShop();
		 logoutAccount.clickOnHtml();
		   logoutAccount.clickOnBook();
		   logoutAccount.addtoCart();
		   logoutAccount.viewCart();
		logoutAccount.removeAnItem();

	}

	@Then("Item should be removed from the view cart")
	public void item_should_be_removed_from_the_view_cart() {
		System.out.println("then");
	}

	// scenario 3 click on proceed to checkout
	@When("I click on proceed to checkout")
	public void i_click_on_proceed_to_checkout() {
		LogoutAccount logoutAccount=new LogoutAccount(driver);
		
		logoutAccount.clickOnShop();
		logoutAccount.clickOnHtml();
		logoutAccount.clickOnBook();
		logoutAccount.addtoCart();
		logoutAccount.viewCart();
		
		CheckOutPage checkOutPage=new CheckOutPage(driver);
		checkOutPage.clickOnCheckOut();

	}

	@Then("It should navigate to the next page")
	public void it_should_navigate_to_the_next_page() {
		BillingPage billingPage=new BillingPage(driver);
	   String actualText=billingPage.billText();
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
	 	BillingPage billingPage=new BillingPage(driver);
			List<Map<String, String>> data = dataTable.asMaps();
			billingPage.enterFirstName(data.get(0).get("firstname"));
			billingPage.enterlastName(data.get(0).get("lastname"));
			billingPage.enterCompany(data.get(0).get("companyname"));
			billingPage.enterEmail(data.get(0).get("email"));
			billingPage.enterPhoneNumber(data.get(0).get("phonenumber"));
			billingPage.enterAddress(data.get(0).get("address"));
			billingPage.enterAddress2(data.get(0).get("address2"));
		billingPage.enterCity(data.get(0).get("town"));
			billingPage.clickonStateSelectBox();
		billingPage.enterState(data.get(0).get("state"));
			billingPage.clickOnState();
			billingPage.enterPincode(data.get(0).get("pincode"));
			billingPage.clickOnPayment();
			

	}

	@Then("I should get filled form")
	public void i_should_get_filled_form() {
	    System.out.println("then");
	}

	

	@When("I click on the place order")
	public void i_click_on_the_place_order() {
		BillingPage billingPage=new BillingPage(driver);
		billingPage.clickOnPlaceOrder();
		 
	}

	@Then("I should get the message as orderplaced")
	public void i_should_get_the_message_as_orderplaced() {
		BillingPage billingPage=new BillingPage(driver);
		String ordText=billingPage.orderText();
		String expected="Thank you. Your order has been received.";
		Assert.assertEquals(expected, ordText);
		System.out.println(ordText);
		
		
		 
	}



	}