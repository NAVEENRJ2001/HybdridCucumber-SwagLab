package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.factory.DriverFactory;
import com.qa.util.ElementUtil;

public class CheckoutPage {
	
	private final WebDriver driver;
	private ElementUtil elementUtils;

	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtil(DriverFactory.getDriver());
	}
	
	@FindBy(xpath = "//div[text()='Sauce Labs Backpack']")
	private WebElement productText;
	
	@FindBy(xpath = "//button[text()='Checkout']")
	private WebElement checkoutButton;
	
	@FindBy(id = "first-name")
	private WebElement firstName;
	
	@FindBy(id = "last-name")
	private WebElement lastName;
	
	@FindBy(id = "postal-code")
	private WebElement zipCode;
	
	@FindBy(id = "continue")
	private WebElement continuebtn;
	
	@FindBy(id = "finish")
	private WebElement finishBtn;
	
	@FindBy(xpath = "//h2[text()='Thank you for your order!']")
	private WebElement checkoutVali;
	
	
	public String productText() {
		return elementUtils.getText(productText);
		

	}
	public void checkoutButton() {
		elementUtils.clickElement(checkoutButton);

	}
	public void firstName(String fn) {
		elementUtils.sendKeys(firstName, fn);

	}
	public void lastName(String ln) {
		elementUtils.sendKeys(lastName, ln);

	}
	public void zipCode(String zp) {
		elementUtils.sendKeys(zipCode, zp);

	}
	public void continuebtn() {
		elementUtils.clickElement(continuebtn);

	}
	public void finishBtn() {
		elementUtils.clickElement(finishBtn);

	}
	public void locateFb() {
		elementUtils.moveToTheElement(finishBtn);

	}
	public String checkoutVali() {
		return elementUtils.getText(checkoutVali);
		

	}
	
	
	
	

}
