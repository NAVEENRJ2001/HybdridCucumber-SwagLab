package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features ="src\\test\\resource\\com\\features", glue = {"stepdefinitions", "com.MyHooks"},
plugin = {"pretty", "summary", "html:target/CucumberReport.html",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:,rerun:target/failed.txt",
		"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}, publish = true, tags = "@test", 
dryRun = false)

public class TestRunner extends AbstractTestNGCucumberTests {

	
}
