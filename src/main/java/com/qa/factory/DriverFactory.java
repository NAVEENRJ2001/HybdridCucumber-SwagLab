package com.qa.factory;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.qa.util.Constants;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public WebDriver driver;
	public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<>();
//drivers
	public void init_driver(String browser) {
		System.out.println("browser value is:" + browser);
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = chromeOptionsSetup();
			tldriver.set(new ChromeDriver(options));

		} else if (browser.equals("firefox")) {

			WebDriverManager.firefoxdriver().setup();
			tldriver.set(new FirefoxDriver());

		} else if (browser.equals("safari")) {

			tldriver.set(new SafariDriver());
			
		}	else if (browser.equals("edge")) {
				WebDriverManager.edgedriver().setup();
				tldriver.set(new EdgeDriver());
				
			}
		 else {

			System.out.println("please pass the correct browser value:" + browser);
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();

	}

	public static WebDriver getDriver() {
		return tldriver.get();
	}

	public void configBrowser() {

		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_WAIT_TIME));
		getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Constants.PAGE_LOAD_TIME));

	}

	public ChromeOptions chromeOptionsSetup() {

		ChromeOptions options = new ChromeOptions();

		Map<String, Object> prefs = new HashMap<>();

		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);

		prefs.put("profile.password_manager_leak_detection", false);

		prefs.put("profile.default_content_setting_values.notifications", 2);

		prefs.put("profile.default_content_setting_values.geolocation", 2);

		prefs.put("profile.default_content_setting_values.media_stream_camera", 2);

		prefs.put("profile.default_content_setting_values.media_stream_mic", 2);

		prefs.put("download.prompt_for_download", false);

		prefs.put("profile.default_content_settings.popups", 0);

		options.setExperimentalOption("prefs", prefs);

		options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });

		options.addArguments("--disable-notifications");

		options.addArguments("--disable-popup-blocking");

		options.addArguments("--disable-infobars");

		options.addArguments("--disable-extensions");

		options.addArguments("--start-maximized");

		return options;
	}
	
	public static void unload() {
		tldriver.remove();
	}

}
