package StepDefinations;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Config.ConfigReader;
import Locators.LogoutLocators;
import Utility.BaseTest;
import Utility.ScreenshotUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LogoutSteps extends BaseTest {
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

    @Given("I am logged in")
    public void i_am_logged_in() throws IOException {
        // Reuse the login steps here or create a method to ensure the user is logged in
        LoginSteps loginSteps = new LoginSteps();
        loginSteps.setUpScenario();
        loginSteps.I_am_on_the_login_page();
        loginSteps.I_enter_valid_login_details();
        loginSteps.I_submit_the_login_form();
        loginSteps.tearDownScenario();

    }

    @When("I click on the logout button")
    public void I_click_on_the_logout_button() throws IOException {
        test = extent.createTest("Logout Test - I click on the logout button");
        driver.findElement(LogoutLocators.LOGOUT_BUTTON).click();
        test.info("Clicked on logout button");

        String screenshotPath= ScreenshotUtil.takeScreenshot(driver, "logout_button");
        test.addScreenCaptureFromPath(screenshotPath);
    }

    @Then("I should be logged out successfully")
    public void I_should_be_logged_out_successfully() throws IOException {
        test = extent.createTest("Logout Test - I should be logged out successfully");
        WebElement loginPageLink = driver.findElement(LogoutLocators.LOGIN_PAGE_LINK);
        Assert.assertTrue(loginPageLink.isDisplayed());
        test.pass("Logged out successfully, login page link is displayed");

        String screenshotPath= ScreenshotUtil.takeScreenshot(driver, "logout_success");
        test.addScreenCaptureFromPath(screenshotPath);
    }

}
