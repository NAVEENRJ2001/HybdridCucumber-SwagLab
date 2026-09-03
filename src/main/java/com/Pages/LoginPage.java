package com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.ElementUtil;


public class LoginPage {

	private final WebDriver driver;
	private ElementUtil elementUtils;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtil(driver);
	}

	@FindBy(id = "user-name")
	private WebElement userName;

	@FindBy(id = "password")
	private WebElement passWord;

	@FindBy(id = "login-button")
	private WebElement loginBtn;

	@FindBy(xpath = "//h3[text()='Epic sadface: Username is required']")
	private WebElement emptyError;

	@FindBy(xpath = "//h3[@data-test='error']")
	private WebElement userError;

//====================================ACTIONS=============================================/////////////////////////

	public String getLoginPageTitle() {
		return elementUtils.getTitle();

	}

	public void enterUserName(String user) {
		elementUtils.sendKeys(userName, user);

	}

	public void enterPassword(String pass) {
		elementUtils.sendKeys(passWord, pass);

	}

	public void clickLogin() {
		elementUtils.clickElement(loginBtn);

	}

	public String getHomePageTitle() {
		return elementUtils.getCurrentUrl();

	}

	public String emptyError() {
		return elementUtils.getText(emptyError);

	}

	public String userError() {
		return elementUtils.getText(userError);

	}
	public HomePage commonlogin(String username, String password) {
		elementUtils.sendKeys(userName, username);
		elementUtils.sendKeys(passWord, password);
		elementUtils.clickElement(loginBtn);
		return new HomePage(driver);
		

	}

}
