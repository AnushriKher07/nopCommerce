package StepDefinations;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Config.ConfigReader;
import Locators.LoginLocators;
import Utility.BaseTest;
import Utility.ScreenshotUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends BaseTest {
	/*
	 * private String baseUrl = ConfigReader.getProperty("baseUrl"); private String
	 * firefoxDriverPath = ConfigReader.getProperty("firefoxDriverPath");
	 */
	    private ExtentReports extent;
	    private ExtentTest test;

	    @Before
	    public void setUpScenario() {
	        super.setUp();  // Ensure WebDriver is initialized
	    	ExtentSparkReporter sparkReporter = new ExtentSparkReporter("target/extent-reports.html");
	        sparkReporter.config().setDocumentTitle("Automation Report");
	        sparkReporter.config().setReportName("Cucumber Framework Report");
	        sparkReporter.config().setTheme(Theme.STANDARD);

	        extent = new ExtentReports();
	        extent.attachReporter(sparkReporter);
	    }

	    @After
	    public void tearDownScenario() {
	        extent.flush();
	        super.tearDown();  // Ensure WebDriver is closed

	    }

	    @Given("I am on the login page")
	    public void I_am_on_the_login_page() throws IOException {
	        test = extent.createTest("Login Test");
	        driver.findElement(LoginLocators.LOGIN_PAGE_LINK).click();
	        test.info("Navigated to login page");

	        String screenshotPath = ScreenshotUtil.takeScreenshot(driver, "login_page");	        
	        test.addScreenCaptureFromPath(screenshotPath);
	    }

	    @When("I enter valid login details")
	    public void I_enter_valid_login_details() throws IOException {
	        test = extent.createTest("Login Test - I enter valid login details");
	        WebElement email = driver.findElement(LoginLocators.LOGIN_EMAIL_INPUT);
	        email.sendKeys("john.doe@example.com");
	        test.info("Entered email: john.doe@example.com");

	        String screenshotPathEmail= ScreenshotUtil.takeScreenshot(driver, "login_email");
	        test.addScreenCaptureFromPath(screenshotPathEmail);

	        WebElement password = driver.findElement(LoginLocators.LOGIN_PASSWORD_INPUT);
	        password.sendKeys("Password123");
	        test.info("Entered password: Password123");

	        
	        String screenshotPathPassword=ScreenshotUtil.takeScreenshot(driver, "login_password");
	        test.addScreenCaptureFromPath(screenshotPathPassword);
	    }

	    @When("I submit the login form")
	    public void I_submit_the_login_form() throws IOException {
	        test = extent.createTest("Login Test - I submit the login form");
	        driver.findElement(LoginLocators.LOGIN_BUTTON).click();
	        test.info("Clicked on login button");

	        String screenshotPathSubmit= ScreenshotUtil.takeScreenshot(driver, "login_submit");
	        test.addScreenCaptureFromPath(screenshotPathSubmit);
	    }

	    @Then("I should be logged in successfully")
	    public void I_should_be_logged_in_successfully() throws IOException {
	        test = extent.createTest("Login Test - I should be logged in successfully");
	        WebElement logoutButton = driver.findElement(LoginLocators.LOGOUT_BUTTON);
            test.info("Clicked on login button");

	        Assert.assertTrue(logoutButton.isDisplayed());
	        test.pass("Logged in successfully, logout button is displayed");

	        String screenshotPathSuccess= ScreenshotUtil.takeScreenshot(driver, "login_success");
	        test.addScreenCaptureFromPath(screenshotPathSuccess);
	    }

}
