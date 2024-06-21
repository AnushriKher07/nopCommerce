package StepDefinations;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Config.ConfigReader;
import Locators.RegisterationLocators;
import Utility.BaseTest;
import Utility.ScreenshotUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterationSteps extends BaseTest {
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

    @Given("I am on the registration page")
    public void I_am_on_the_registration_page() throws IOException {
		/*
		 * test =
		 * extent.createTest("Registration Test - I am on the registration page");
		 * driver.findElement(RegisterationLocators.REGISTRATION_PAGE_LINK).click();
		 * test.info("Navigated to registration page");
		 */
        WebDriverWait wait = new WebDriverWait(driver, 10); // Timeout in seconds
        WebElement registrationLink = wait.until(ExpectedConditions.elementToBeClickable(RegisterationLocators.REGISTRATION_PAGE_LINK));
        
        registrationLink.click();

        String screenshotPath= ScreenshotUtil.takeScreenshot(driver, "registration_page");
        test.addScreenCaptureFromPath(screenshotPath);
    }
    
    @When("I select the gender as {string}")
    public void I_select_the_gender_as(String gender) throws IOException {
        test = extent.createTest("Registration Test - I select the gender");
		/*
		 * if (gender.equalsIgnoreCase("Male")) {
		 * driver.findElement(RegisterationLocators.GENDER_MALE_RADIO_BUTTON).click(); }
		 * else if (gender.equalsIgnoreCase("Female")) {
		 * driver.findElement(RegisterationLocators.GENDER_FEMALE_RADIO_BUTTON).click();
		 * } test.info("Selected gender: " + gender); String screenshotPath =
		 * ScreenshotUtil.takeScreenshot(driver, "registration_gender");
		 * test.addScreenCaptureFromPath(screenshotPath);
		 */
        WebElement genderOption = gender.equalsIgnoreCase("Male") ?
                driver.findElement(RegisterationLocators.GENDER_MALE_RADIO_BUTTON) :
                driver.findElement(RegisterationLocators.GENDER_FEMALE_RADIO_BUTTON);
        genderOption.click();
        test.info("Selected gender: " + gender);
        String screenshotPath = ScreenshotUtil.takeScreenshot(driver, "registration_gender");
        test.addScreenCaptureFromPath(screenshotPath);
    }

    @When("I enter the first name {string}")
    public void I_enter_the_first_name(String firstName) throws IOException {
        test = extent.createTest("Registration Test - I enter the first name");
        WebElement firstNameInput = driver.findElement(RegisterationLocators.FIRST_NAME_INPUT);
        firstNameInput.sendKeys(firstName);
        test.info("Entered first name: " + firstName);
        String screenshotPath = ScreenshotUtil.takeScreenshot(driver, "registration_firstname");
        test.addScreenCaptureFromPath(screenshotPath);
    }

    @When("I enter the last name {string}")
    public void I_enter_the_last_name(String lastName) throws IOException {
        test = extent.createTest("Registration Test - I enter the last name");
        WebElement lastNameInput = driver.findElement(RegisterationLocators.LAST_NAME_INPUT);
        lastNameInput.sendKeys(lastName);
        test.info("Entered last name: " + lastName);
        String screenshotPath = ScreenshotUtil.takeScreenshot(driver, "registration_lastname");
        test.addScreenCaptureFromPath(screenshotPath);
    }

    @When("I select the date of birth as {string}")
    public void I_select_the_date_of_birth_as(String dob) throws IOException {
        test = extent.createTest("Registration Test - I select the date of birth");
        String[] dobParts = dob.split("/");
        String day = dobParts[0];
        String month = dobParts[1];
        String year = dobParts[2];

        new Select(driver.findElement(RegisterationLocators.DATE_OF_BIRTH_DAY)).selectByVisibleText(day);
        new Select(driver.findElement(RegisterationLocators.DATE_OF_BIRTH_MONTH)).selectByVisibleText(month);
        new Select(driver.findElement(RegisterationLocators.DATE_OF_BIRTH_YEAR)).selectByVisibleText(year);

        test.info("Selected date of birth: " + dob);
        String screenshotPath = ScreenshotUtil.takeScreenshot(driver, "registration_dob");
        test.addScreenCaptureFromPath(screenshotPath);
    }

    @When("I enter the email {string}")
    public void I_enter_the_email(String email) throws IOException {
        test = extent.createTest("Registration Test - I enter the email");
        WebElement emailInput = driver.findElement(RegisterationLocators.EMAIL_INPUT);
        emailInput.sendKeys(email);
        test.info("Entered email: " + email);
        String screenshotPath = ScreenshotUtil.takeScreenshot(driver, "registration_email");
        test.addScreenCaptureFromPath(screenshotPath);
    }

    @When("I enter the company name {string}")
    public void I_enter_the_company_name(String companyName) throws IOException {
        test = extent.createTest("Registration Test - I enter the company name");
        WebElement companyNameInput = driver.findElement(RegisterationLocators.COMPANY_NAME_INPUT);
        companyNameInput.sendKeys(companyName);
        test.info("Entered company name: " + companyName);
        String screenshotPath = ScreenshotUtil.takeScreenshot(driver, "registration_company");
        test.addScreenCaptureFromPath(screenshotPath);
    }

    @When("I enter the password {string}")
    public void I_enter_the_password(String password) throws IOException {
        test = extent.createTest("Registration Test - I enter the password");
        WebElement passwordInput = driver.findElement(RegisterationLocators.PASSWORD_INPUT);
        passwordInput.sendKeys(password);
        test.info("Entered password: " + password);
        String screenshotPath = ScreenshotUtil.takeScreenshot(driver, "registration_password");
        test.addScreenCaptureFromPath(screenshotPath);
    }

    @When("I enter the confirmation password {string}")
    public void I_enter_the_confirmation_password(String confirmPassword) throws IOException {
        test = extent.createTest("Registration Test - I enter the confirmation password");
        WebElement confirmPasswordInput = driver.findElement(RegisterationLocators.CONFIRM_PASSWORD_INPUT);
        confirmPasswordInput.sendKeys(confirmPassword);
        test.info("Entered confirmation password: " + confirmPassword);
        String screenshotPath = ScreenshotUtil.takeScreenshot(driver, "registration_confirm_password");
        test.addScreenCaptureFromPath(screenshotPath);
    }

    @When("I submit the registration form")
    public void I_submit_the_registration_form() throws IOException {
        test = extent.createTest("Registration Test - I submit the registration form");
        driver.findElement(RegisterationLocators.REGISTER_BUTTON).click();
        test.info("Clicked on register button");
        String submitRegistrationPath = ScreenshotUtil.takeScreenshot(driver, "registration_submit");
        test.addScreenCaptureFromPath(submitRegistrationPath);
    }

    @Then("I should see a registration success message")
    public void I_should_see_a_registration_success_message() throws IOException {
        test = extent.createTest("Registration Test - I should see a registration success message");
        WebElement successMessage = driver.findElement(RegisterationLocators.REGISTRATION_SUCCESS_MESSAGE);
        Assert.assertTrue(successMessage.isDisplayed());
        test.pass("Registered successfully, success message is displayed");
        String successMessagePath = ScreenshotUtil.takeScreenshot(driver, "registration_success");
        test.addScreenCaptureFromPath(successMessagePath);
    }
}
