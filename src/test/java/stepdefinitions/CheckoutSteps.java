package stepdefinitions;

import org.testng.Assert;

import com.Pages.CheckoutPage;
import com.Pages.HomePage;
import com.Pages.LoginPage;
import com.qa.factory.DriverFactory;
import com.qa.util.Constants;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckoutSteps {
	private HomePage homePage = new HomePage(DriverFactory.getDriver());
	private CheckoutPage checkPage = new CheckoutPage(DriverFactory.getDriver());
	
	
	@Given("user logged in Sucessfully")
	public void user_logged_in_sucessfully() {
		LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
		homePage = loginPage.commonlogin(Constants.USERNAME, Constants.PASSWORD);
	}

	@When("user clicks add to cart button")
	public void user_clicks_add_to_cart_button() {
	    homePage.addtocartbtn();
	}

	@When("user clicks the cart icon")
	public void user_clicks_the_cart_icon() {
	    homePage.cartIcon();
	   
	}

	@Then("user finds the product added")
	public void user_finds_the_product_added() {
	    Assert.assertTrue(checkPage.productText().contains("Sauce Labs Backpack"));
	    System.out.println("Product Founded");
	}

	@Then("user clicks the checkout button")
	public void user_clicks_the_checkout_button() {
	    checkPage.checkoutButton();
	}

	@Then("user enters the name as {string}")
	public void user_enters_the_name_as(String string) {
	    checkPage.firstName(string);
	}

	@Then("user enters te lastname as {string}")
	public void user_enters_te_lastname_as(String string) {
	   checkPage.lastName(string);
	}

	@Then("user enters the zipcode as {string}")
	public void user_enters_the_zipcode_as(String string) {
	   checkPage.zipCode(string);
	   checkPage.continuebtn();
	}

	@Then("user clicks the finish button")
	public void user_clicks_the_finish_button() {
	    checkPage.locateFb();
	    checkPage.finishBtn();
	}

	@Then("user ordered the product sucessfully")
	public void user_ordered_the_product_sucessfully() {
	    Assert.assertTrue(checkPage.checkoutVali().contains("Thank you for your order!"));
	    System.out.println("Product ordered Sucessfully");
	}



}
