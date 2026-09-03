package stepdefinitions;

import org.testng.Assert;

import com.Pages.HomePage;
import com.Pages.LoginPage;
import com.qa.factory.DriverFactory;
import com.qa.util.Constants;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddToCartSteps {

	private HomePage homePage = new HomePage(DriverFactory.getDriver());

	@Given("User logged into the homepage")
	public void user_logged_into_the_homepage() {
		LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
		homePage = loginPage.commonlogin(Constants.USERNAME, Constants.PASSWORD);
	}

	@When("user checks the add to cart button is present")
	public void user_checks_the_add_to_cart_button_is_present() {

	}

	@When("user add two products to the cart")
	public void user_add_two_products_to_the_cart() {
		homePage.addtocartbtn();
		homePage.addtocart2();
	}

	@Then("products added sucessfully")
	public void products_added_sucessfully() {
		homePage.locateTheElement();
		Assert.assertTrue(homePage.gettextCartIcon().contains("2"));
		System.out.println("Added Sucessfully");
	}

	@When("user checks the remove from cart button is present")
	public void user_checks_the_remove_from_cart_button_is_present() {

	}

	@When("user remove one of the product")
	public void user_remove_one_of_the_product() {
		homePage.addtocartbtn();
		homePage.addtocart2();
		homePage.removeCartClick();
	}

	@Then("user removed product sucessfully")
	public void user_removed_product_sucessfully() {
		homePage.locateTheElement();
		Assert.assertTrue(homePage.gettextCartIcon().contains("1"));
		System.out.println("Removed Sucessfully");
	}

}
