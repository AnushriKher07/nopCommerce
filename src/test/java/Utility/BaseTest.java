package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;

import Config.ConfigReader;


public class BaseTest {
	protected static WebDriver driver;
    protected ConfigReader configReader;
    //protected static ExtentReports extent;


    @BeforeMethod
    public void setUp() {
        configReader = new ConfigReader();
        System.setProperty("webdriver.gecko.driver", ConfigReader.getProperty("firefoxDriverPath"));
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(ConfigReader.getProperty("baseUrl"));
    }
    

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
