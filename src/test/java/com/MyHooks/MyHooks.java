package com.MyHooks;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class MyHooks {

	private DriverFactory driverFactory;
	private WebDriver driver;
	private ConfigReader configReader;
	Properties prop;

	@Before(order = 0)
	public void getProperty() throws IOException {
	
		new ConfigReader().init_prop();
	}

	@Before(order = 1)
	public void launchBrowser() {
		
		driverFactory = new DriverFactory();
		driverFactory.init_driver(ConfigReader.getProperty("browser"));
		DriverFactory.getDriver().get(ConfigReader.getProperty("qaurl"));

	}

	@After
	public void tearDown(Scenario scenario) {
		
		WebDriver driver = DriverFactory.getDriver();

		if (scenario.isFailed() && driver != null) {

			byte[] screenshotAs = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

			scenario.attach(screenshotAs, "image/png", "Failed Screenhot");

		}

		if (driver != null) {
			driver.quit();
			DriverFactory.unload();
		}

	}


}
