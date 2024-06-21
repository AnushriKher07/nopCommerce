package Locators;

import org.openqa.selenium.By;

public class LoginLocators {
	public static final By LOGIN_PAGE_LINK = By.linkText("Log in");
    public static final By LOGIN_EMAIL_INPUT = By.id("Email");
    public static final By LOGIN_PASSWORD_INPUT = By.id("Password");
    public static final By LOGIN_BUTTON = By.xpath("//button[contains(text(),'Log in')]");
    public static final By LOGOUT_BUTTON = By.linkText("Log out");

}
