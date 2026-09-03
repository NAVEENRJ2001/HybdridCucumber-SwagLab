package stepdefinitions;



import org.testng.Assert;

import com.Pages.FilterPage;
import com.Pages.HomePage;
import com.Pages.LoginPage;
import com.qa.factory.DriverFactory;
import com.qa.util.Constants;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FilterSteps {
	private HomePage homePage;
	private FilterPage filterPage;

	@Given("user logged into the homepage")
	public void user_logged_into_the_homepage() {
		LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
		homePage = loginPage.commonlogin(Constants.USERNAME, Constants.PASSWORD);

	}

	@Given("user clicks the filter button")
	public void user_clicks_the_filter_button() {
	   filterPage = homePage.filterbtn();
	   
	   
	}

	@When("user select the Name \\(Z to A) filter")
	public void user_select_the_name_z_to_a_filter() {
	  filterPage.sortProduct("Name (Z to A)");
	}

	@Then("all product will change into descending order")
	public void all_product_will_change_into_descending_order() {
	    Assert.assertTrue(homePage.gettextFb().contains("Name (Z to A)"));
	    System.out.println("Sucessfully Order Changed");
	}

	@When("user select the Price \\(Low to High) filter")
	public void user_select_the_price_low_to_high_filter() {
		filterPage.sortProduct("Price (low to high)");
	}

	@Then("all product's price will change into low to high")
	public void all_product_s_price_will_change_into_low_to_high() {
		 Assert.assertTrue(homePage.gettextFb().contains("Price (low to high)"));
		    System.out.println("Sucessfully Order Changed");
	}

	@When("user select the Price \\(High to Low) filter")
	public void user_select_the_price_high_to_low_filter() {
		filterPage.sortProduct("Price (high to low)");
	}

	@Then("all product's price will change into high to low")
	public void all_product_s_price_will_change_into_high_to_low() {
		 Assert.assertTrue(homePage.gettextFb().contains("Price (high to low)"));
		    System.out.println("Sucessfully Order Changed");
	}

	@When("user select the Name \\(A to Z) filter")
	public void user_select_the_name_a_to_z_filter() {
		filterPage.sortProduct("Name (A to Z)");
	}

	@Then("all product will change into Ascending order")
	public void all_product_will_change_into_ascending_order() {
		Assert.assertTrue(homePage.gettextFb().contains("Name (A to Z)"));
	    System.out.println("Sucessfully Order Changed");
	}
	
	
}
