package Locators;

import org.openqa.selenium.By;

public class RegisterationLocators {
	public static final By REGISTRATION_PAGE_LINK = By.linkText("Register");
	public static final By GENDER_MALE_RADIO_BUTTON = By.id("gender-male");
    public static final By GENDER_FEMALE_RADIO_BUTTON = By.id("gender-female");
    public static final By FIRST_NAME_INPUT = By.id("FirstName");
    public static final By LAST_NAME_INPUT = By.id("LastName");
    public static final By DATE_OF_BIRTH_DAY = By.name("DateOfBirthDay");
    public static final By DATE_OF_BIRTH_MONTH = By.name("DateOfBirthMonth");
    public static final By DATE_OF_BIRTH_YEAR = By.name("DateOfBirthYear");
    public static final By EMAIL_INPUT = By.id("Email");
    public static final By COMPANY_NAME_INPUT = By.id("Company");
    public static final By PASSWORD_INPUT = By.id("Password");
    public static final By CONFIRM_PASSWORD_INPUT = By.id("ConfirmPassword");
    public static final By REGISTER_BUTTON = By.id("register-button");
    public static final By REGISTRATION_SUCCESS_MESSAGE = By.className("result");

}
