package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.factory.DriverFactory;
import com.qa.util.ElementUtil;

public class HomePage {
	
	private final WebDriver driver;
	private ElementUtil elementUtils;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtil(DriverFactory.getDriver());
	}
	
	@FindBy(xpath = "//span[text()='Products']")
	private WebElement homePageTitle;

	@FindBy(xpath = "//select[@class='product_sort_container']")
	private WebElement filterButton;

	@FindBy(xpath = "//a[@class='shopping_cart_link']")
	private WebElement CartIcon;

	@FindBy(id  = ("add-to-cart-sauce-labs-backpack"))
	private WebElement AddToCartButton1;
	
	@FindBy(id = ("add-to-cart-sauce-labs-bike-light"))
	private WebElement AddToCartButton2;
	
	@FindBy(xpath = "//button[text()='Remove']")
	private WebElement removeFromCart;

	
	public String HomePageTitle() {
		return elementUtils.getText(homePageTitle);
		

	}
	public FilterPage filterbtn() {
		 elementUtils.clickElement(filterButton);;
		 return new FilterPage(driver);
		

	}
	public String gettextFb() {
		return elementUtils.getText(filterButton);
		

	}
	public void cartIcon() {
		 
		 elementUtils.clickElement(CartIcon);
		

	}
	public void addtocartbtn() {
		
		elementUtils.clickElement(AddToCartButton1);
		

	}
	public void addtocart2() {
		elementUtils.clickElement(AddToCartButton2);

	}
	public String gettextCartIcon() {
		return elementUtils.getText(CartIcon);

	}
	public void locateTheElement() {
		elementUtils.moveToTheElement(CartIcon);

	}
	public boolean addToCartDisplayed() {
		return elementUtils.isDisplayed(AddToCartButton1);

	}
	public boolean removeIsDispalyed() {
		return elementUtils.isDisplayed(removeFromCart);
		

	}
	public void removeCartClick() {
		elementUtils.clickElement(removeFromCart);

	}

}
