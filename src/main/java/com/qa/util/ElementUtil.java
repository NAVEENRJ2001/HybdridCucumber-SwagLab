package com.qa.util;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {

	private final WebDriver driver;
	private final WebDriverWait wait;

	public ElementUtil(WebDriver driver) {

		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT_TIME));
	}

//============================WAITS===============================================================//
	public WebElement waitForElementToBeClickable(WebElement element) {

		return wait.until(ExpectedConditions.elementToBeClickable(element));

	}

	public WebElement waitForVisibilityOfElement(WebElement element) {

		return wait.until(ExpectedConditions.visibilityOf(element));
	}

	public List<WebElement> waitForVisibilityOfAllElements(List<WebElement> element) {

		return wait.until(ExpectedConditions.visibilityOfAllElements(element));
	}

	public Alert waitForAlertIsPresent() {

		return wait.until(ExpectedConditions.alertIsPresent());
	}

	public WebElement waitForFrameIsPresent(WebElement element) {
		return (WebElement) wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));

	}

//==============SELENIUM METHODS====================================================================//	

	// 1.CLICK
	public void clickElement(WebElement element) {
		WebElement webelement = waitForElementToBeClickable(element);
		webelement.click();

	}

	// 2.SENKEYS
	public void sendKeys(WebElement element, String s) {
		WebElement webelement = waitForVisibilityOfElement(element);
		webelement.click();
		webelement.clear();
		webelement.sendKeys(s);

	}

	// 3.GETTEXT
	public String getText(WebElement element) {
		WebElement webelement = waitForVisibilityOfElement(element);
		return webelement.getText();

	}

	// 4. IS DISPLAYED
	public boolean isDisplayed(WebElement element) {
		WebElement webelement = waitForVisibilityOfElement(element);
		return webelement.isDisplayed();

	}

	// 5. GET TITLE
	public String getTitle() {
		return driver.getTitle();

	}

	// 6. GET CURRENT URL
	public String getCurrentUrl() {
		return driver.getCurrentUrl();

	}

	// 7. DROP DOWN (TEXT)
	public void dropDown(WebElement element, String s) {
		Select select = new Select(element);
		select.selectByVisibleText(s);

	}

	// 8. DROP DOWN (VALUE)
	public void dropdownValue(WebElement element, String s) {
		Select select = new Select(element);
		select.selectByValue(s);

	}

	// 9.DROP DOWN (INDEX)
	private void dropdownIndex(WebElement element, String s) {
		Select select = new Select(element);
		select.selectByValue(s);

	}

	// 10.MOVE TO THE ELEMENT (ACTION CLASS)
	public void moveToTheElement(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();

	}

	// 11.CLEAR
	public void clearField(WebElement element) {
		WebElement el = waitForVisibilityOfElement(element);
		el.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		el.sendKeys(Keys.DELETE);

	}

	// 12.GET TEXTS
	public List<String> getTexts(List<WebElement> elements) {
		List<WebElement> el = waitForVisibilityOfAllElements(elements);
		List<String> texts = new ArrayList<>();
		for (WebElement element : elements) {
			texts.add(element.getText());
		}
		return texts;

	}

	// 13. GET SIZE

	public int getSize(List<WebElement> element) {
		List<WebElement> el = waitForVisibilityOfAllElements(element);
		return el.size();

	}
	// 14.IS ENABLED

	public boolean isEnabled(WebElement element) {
		WebElement el = waitForVisibilityOfElement(element);
		return el.isEnabled();

	}
	// 15.IS SELECTED

	public boolean isSelected(WebElement element) {
		WebElement el = waitForVisibilityOfElement(element);
		return el.isSelected();

	}
	// 16.IS ELEMENT PRESENT

	public boolean isElementPresent(By element) {
		return driver.findElements(element).size() > 0;

	}
	// 17. READ OTP

	public String readOTPFromConsole() {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter OTP: ");
			return sc.nextLine();
		}

	}
	// 18.SELECT CHECK BOX

	public void selectCheckBox(WebElement cb) {
		WebElement el = waitForElementToBeClickable(cb);
		if (!cb.isSelected()) {
			el.click();
		}

	}
	// 19.UNSELECT CHECK BOX

	public void unselectCheckBox(WebElement cb) {
		WebElement el = waitForElementToBeClickable(cb);
		if (cb.isSelected()) {
			el.click();
		}

	}

	public void selectRadiobtn(WebElement radio) {
		WebElement el = waitForElementToBeClickable(radio);
		if (!radio.isSelected()) {
			el.click();
		}

	}
	// 20. HOVER TO ELEMENT

	public void hoverToElement(WebElement element1, WebElement element2) {
		WebElement el1 = waitForVisibilityOfElement(element1);
		WebElement el2 = waitForVisibilityOfElement(element2);
		new Actions(driver).moveToElement(el1).moveToElement(el2).click().perform();

	}
	// 21. SLIDER

	public void slider(WebElement element, int value1, int value2) {
		WebElement el = waitForVisibilityOfElement(element);
		new Actions(driver).dragAndDropBy(el, value1, value2).perform();

	}
	// 22.DOUBLE CLICK

	public void doubleClick(WebElement element) {
		WebElement el = waitForVisibilityOfElement(element);
		new Actions(driver).doubleClick(element).perform();

	}
	// 23.RIGHT CLICK

	public void rightClick(WebElement element) {
		WebElement el = waitForVisibilityOfElement(element);
		new Actions(driver).contextClick(element).perform();

	}
	// 24.JS CLICK

	public void jsClick(WebElement element) {
		WebElement el = waitForVisibilityOfElement(element);
		((JavascriptExecutor) driver).executeScript("argument[0].click", element);

	}
	// 25.JS SVG

	public void jsSVGClick(WebElement element) {
		WebElement el = waitForVisibilityOfElement(element);
		((JavascriptExecutor) driver)
				.executeScript("argument[0].dispatchEvent(new MouseEvent('click',{bubblers:true}));", element);

	}
	// 26.SCROLL TO ELEMENT

	public void scrollToElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("argument[0].scrollIntoView({block:'center'});", element);

	}
	// 27.ACCEPT ALERT

	public void acceptAlert() {
		Alert al = waitForAlertIsPresent();
		al.accept();

	}
	// 28.DISMISS ALERT

	public void dismissAlert() {
		Alert al = waitForAlertIsPresent();
		al.dismiss();

	}
	// 29.TEXT ALERT

	public void textAlert(String s) {
		Alert al = waitForAlertIsPresent();
		al.sendKeys(s);

	}

	// 30.FRAME
	public void switchToFrame(WebElement element) {
		WebElement el = waitForFrameIsPresent(element);

	}

	// 31.PARENT FRAME
	public void SwitchtoParentFrame() {
		driver.switchTo().parentFrame();

	}
	// 32.CHILD WINDOW SWITCH

	public void childWindow(String pw) {
		for (String window : driver.getWindowHandles()) {
			if (!window.equals(pw)) {
				driver.switchTo().window(window);
				break;
			}

		}

	}
	// 33.PARENT WINDOW SWITCH

	public String parentWindow() {
		return driver.getWindowHandle();

	}
	// 34.CHILD WINDOW SWITCH BY URL

	public void childWindowByUrl(String value) {
		for (String window : driver.getWindowHandles()) {
			driver.switchTo().window(window);
			if (driver.getCurrentUrl().contains(value)) {
				break;
			}
		}

	}
	// 35.PARENT WINDOW SWITCH

	public void switchToParentWindow(String pw) {
		driver.switchTo().window(pw);

	}
	// 36.CLOSE CURRENT WINDOW AND RETURNS TO PARENT

	public void closeCurrentWindowandReturns(String pw) {
		driver.close();
		driver.switchTo().window(pw);

	}
	// 37.CLOSE ALL CHILD WINDOW

	public void closeAllChildWindow(String pw) {
		for (String window : driver.getWindowHandles()) {
			if (!window.equals(pw)) {
				driver.switchTo().window(pw);
				driver.close();
			}
		}

	}

	// 38.UPLOAD FILES
	public void uploadFile(WebElement element, String filename) {
		WebElement el = waitForVisibilityOfElement(element);
		String filepath = System.getProperty("user.dir") + File.separator + "uploads" + File.separator + filename;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
		System.out.println(filepath);
		element.sendKeys(filepath);

	}

	// 39.SCREENSHOTS
	public static String screenShot(WebDriver driver, String screenshotName) {
		String timestamp = new SimpleDateFormat("yyyyMMdd HHmmss").format(new Date());
		String filepath = System.getProperty("user.dir") + "/screenshots/" + screenshotName + "_" + timestamp + ".png";
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File(filepath);
		try {
			FileUtils.copyFile(source, destination);
		} catch (IOException e) {
			throw new RuntimeException("Failed to save screenshot", e);
		}
		return filepath;

	}

	// 40.UPLOAD USING ROBOT (WHEN INPUT IS HIDDEN)
	public void uploadUsingRobot(WebElement upload, String filePath) throws AWTException {
		WebElement el = waitForElementToBeClickable(upload);
		el.click();
		StringSelection selection = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

		Robot robot = new Robot();
		robot.delay(3000);

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.delay(500);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

	}

	// 41. VERIFY FILE DOWNLOAD
	public boolean verifyFileDownload(String downloadPath, String expectedFileName) {
		File folder = new File(downloadPath);
		File[] files = folder.listFiles();

		if (files == null) {
			return false;
		}
		for (File file : files) {
			if (file.getName().equals(expectedFileName)) {
				return true;
			}
		}
		return false;

	}

	// 42.DOWNLOAD AND VERIFY
	public void downloadAndVerify(WebElement element, String path, String fileName) {
		WebElement el = waitForElementToBeClickable(element);
		el.click();

		boolean status = verifyFileDownload(path, fileName);

		if (status) {
			System.out.println("File Downloaded Sucessfully");
		} else {
			System.out.println("File Not Downloaded");

		}

	}

	// 43.AUTO COMPLETE SUGGESTION
	public void autoCompleteSuggestion(List<WebElement> suggestion, String options) {
		List<WebElement> el = waitForVisibilityOfAllElements(suggestion);
		List<WebElement> list = suggestion;
		for (WebElement item : list) {
			if (item.getText().equals(options)) {
				item.click();
				break;
			}
		}

	}
	
	//44.ENTER ACTION CLASS
	public void enterKey(WebElement element) {
		WebElement el = waitForVisibilityOfElement(element);
		el.sendKeys(Keys.ENTER);
		

	}

}
