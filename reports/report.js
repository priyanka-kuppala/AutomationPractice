$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/main/resources/feature/AutomationPractice.feature");
formatter.feature({
  "name": "PracticeAutomation",
  "description": "\tIn order to shop the Automation books \nAs a practice automation user\nI want to connect with the practice automation application",
  "keyword": "Feature"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "User launch the browser with practiceautomationtestingPage",
  "keyword": "Given "
});
formatter.match({
  "location": "com.cts.stepdefinitions.StepDefinition.user_launch_the_browser_with_practiceautomationtestingPage()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "place order",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "I click on login button and enter loginusername as \u0027pavanapriyanaka56@gmail.com\u0027 and I enter loginpassword as \u0027Ramadhiganesh@park12K6\u0027",
  "keyword": "When "
});
formatter.match({
  "location": "com.cts.stepdefinitions.StepDefinition.i_click_on_login_button_and_enter_loginusername_as_and_I_enter_loginpassword_as(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on login button",
  "keyword": "And "
});
formatter.match({
  "location": "com.cts.stepdefinitions.StepDefinition.click_on_login_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on shop",
  "keyword": "And "
});
formatter.match({
  "location": "com.cts.stepdefinitions.StepDefinition.i_click_on_shop()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I select a book",
  "keyword": "And "
});
formatter.match({
  "location": "com.cts.stepdefinitions.StepDefinition.i_select_a_book()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on proceed to checkout",
  "keyword": "And "
});
formatter.match({
  "location": "com.cts.stepdefinitions.StepDefinition.i_click_on_proceed_to_checkout()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "It should navigate to the billing page with details",
  "rows": [
    {},
    {}
  ],
  "keyword": "And "
});
formatter.match({
  "location": "com.cts.stepdefinitions.StepDefinition.it_should_navigate_to_the_billing_page_with_details(io.cucumber.datatable.DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on the place order",
  "keyword": "And "
});
formatter.match({
  "location": "com.cts.stepdefinitions.StepDefinition.i_click_on_the_place_order()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I should get the message as orderplaced",
  "keyword": "Then "
});
formatter.match({
  "location": "com.cts.stepdefinitions.StepDefinition.i_should_get_the_message_as_orderplaced()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});