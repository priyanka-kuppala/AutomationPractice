Feature: PracticeAutomation 
	In order to shop the Automation books 
As a practice automation user
I want to connect with the practice automation application

Background: 
	Given User launch the browser with practiceautomationtestingPage 
	
Scenario: Add to cart 
	When I enter login details from Excel "src/test/resources/resources/Book1.xlsx" with SheetName "LoginCredentials" 
	And click on login button 
	And I click on shop 
	And I select a book 
	And I click on the add to basket button 
	Then Item should be added to the view cart 
	
Scenario: Add to cart and Remove
	When I click on login button and enter loginusername as 'pavanapriyanaka56@gmail.com' and I enter loginpassword as 'Ramadhiganesh@park12K6' 
	And click on login button 
	And I click on shop 
	And I select a book 
	And I click on the add to basket button 
	And I delete from cart
	Then Item should be removed from the view cart 
	
Scenario: Add to cart and Proceed to checkout 
	When I click on login button and enter loginusername as 'pavanapriyanaka56@gmail.com' and I enter loginpassword as 'Ramadhiganesh@park12K6' 
	And click on login button 
	And I click on shop 
	And I select a book 
	And I click on proceed to checkout
	Then It should navigate to the next page 
	
Scenario: Billing details
	When I click on login button and enter loginusername as 'pavanapriyanaka56@gmail.com' and I enter loginpassword as 'Ramadhiganesh@park12K6' 
	And click on login button 
	And I click on shop 
	And I select a book 
	And I click on proceed to checkout
	And It should navigate to the billing page with details 
		|firstname|lastname|companyname|email|phonenumber|address|address2|town|state|pincode|
		|priyanka|kuppala|cts|pavanapriyanaka56@gmail.com|9563214569|bluelotus|lotus pg|chennai|tamil|600119|
	Then I should get filled form 
	
	
	
	Scenario: place order 
	When I click on login button and enter loginusername as 'pavanapriyanaka56@gmail.com' and I enter loginpassword as 'Ramadhiganesh@park12K6' 
	And click on login button 
	And I click on shop 
	And I select a book 
	And I click on proceed to checkout
	And It should navigate to the billing page with details 
		|firstname|lastname|companyname|email|phonenumber|address|address2|town|state|pincode|
		|priyanka|kuppala|cts|pavanapriyanaka56@gmail.com|9563214569|bluelotus|lotus pg|chennai|tamil|600119|
	And I click on the place order
	Then  I should get the message as orderplaced
	
	