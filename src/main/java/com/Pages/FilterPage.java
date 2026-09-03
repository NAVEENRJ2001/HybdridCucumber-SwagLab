package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.ElementUtil;

public class FilterPage {
	
	private final WebDriver driver;
	private ElementUtil elementUtils;

	public FilterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtil(driver);
	}
	
	@FindBy(xpath = "//select[@class='product_sort_container']")
	private WebElement filterButton;
	
	
	
	public void sortProduct(String s) {
		elementUtils.clickElement(filterButton);
		 elementUtils.dropDown(filterButton, s);
		 
		

	}
	
	

}
