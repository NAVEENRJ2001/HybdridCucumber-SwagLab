package stepdefinitions;



import static org.testng.Assert.assertTrue;

import org.testng.Assert;

import com.Pages.HomePage;
import com.Pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private HomePage homePage = new HomePage(DriverFactory.getDriver());

	@Given("user is in login Page")
	public void user_is_in_login_page() {
		
	}

	@Then("user gets the title of the Page")
	public void user_gets_the_title_of_the_page() {
		Assert.assertTrue(DriverFactory.getDriver().getCurrentUrl().contains("saucedemo"));
		System.out.println(DriverFactory.getDriver().getCurrentUrl());
	}

	@When("user enters the username as {string}")
	public void user_enters_the_username_as(String string) {
	    loginPage.enterUserName(string);
	}

	@When("user enters the password as {string}")
	public void user_enters_the_password_as(String string) {
	   loginPage.enterPassword(string);
	}

	@When("user clicks the Login Button")
	public void user_clicks_the_login_button() {
	   loginPage.clickLogin();
	}

	@Then("user gets the title of the home page")
	public void user_gets_the_title_of_the_home_page() {
	   Assert. assertTrue(homePage.HomePageTitle().contains("Products"));
	   System.out.println("Logged in Sucessfully");
	}

	@When("user enters the empty username as {string}")
	public void user_enters_the_empty_username_as(String string) {
		loginPage.enterUserName(string);
	}

	@When("user enters the empty password as {string}")
	public void user_enters_the_empty_password_as(String string) {
		loginPage.enterPassword(string);
	}

	@When("user clicks the Login Btn")
	public void user_clicks_the_login_btn() {
		 loginPage.clickLogin();
	}

	@Then("user gets the error message")
	public void user_gets_the_error_message() {
	    Assert.assertTrue(loginPage.emptyError().contains("Epic sadface: Username is required"));
	    System.out.println("Login Unsucessfull");
	}

	@When("user enters the invalid username as {string}")
	public void user_enters_the_invalid_username_as(String string) {
		loginPage.enterUserName(string);
	}

	@When("user enters the valid password as {string}")
	public void user_enters_the_valid_password_as(String string) {
		loginPage.enterPassword(string);
	}

	@When("user clicks the login option")
	public void user_clicks_the_login_option() {
		 loginPage.clickLogin();
	}

	@Then("user gets error message on username")
	public void user_gets_error_message_on_username() {
		 Assert.assertTrue(loginPage.userError().contains("Epic sadface: Username and password do not match any user in this service"));
		    System.out.println("Login Unsucessfull");
	}

	@When("user enters the valid username as {string}")
	public void user_enters_the_valid_username_as(String string) {
		loginPage.enterUserName(string);
	}

	@When("user enters the invalid password as {string}")
	public void user_enters_the_invalid_password_as(String string) {
		loginPage.enterPassword(string);
	}

	@When("user clicks on login button")
	public void user_clicks_on_login_button() {
		 loginPage.clickLogin();
	}

	@Then("user gets error message on password")
	public void user_gets_error_message_on_password() {
		 Assert.assertTrue(loginPage.userError().contains("Epic sadface: Username and password do not match any user in this service"));
		    System.out.println("Login Unsucessfull");
	}
	

	

	
	

		


}
