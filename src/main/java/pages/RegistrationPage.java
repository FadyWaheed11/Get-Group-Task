package pages;

import locators.RegistrationPageLocators;
import settings.Settings;

import static utils.SharedSteps.*;

public class RegistrationPage {

    //Prevent instance
    private RegistrationPage() {
    }

    public static RegistrationPage getRegistrationPage() {
        return new RegistrationPage();
    }

    public RegistrationPage fillFirstName(String firstName) {
        sendTextToElement(firstName, RegistrationPageLocators.FIRST_NAME_LOCATOR.by());
        return this;
    }

    public RegistrationPage fillLastName(String lastName) {
        sendTextToElement(lastName, RegistrationPageLocators.LAST_NAME_LOCATOR.by());
        return this;
    }

    public RegistrationPage fillEmail(String email) {
        sendTextToElement(email, RegistrationPageLocators.EMAIL_LOCATOR.by());
        return this;
    }

    public RegistrationPage fillPhoneNumber(String phone) {
        sendTextToElement(phone, RegistrationPageLocators.PHONE_LOCATOR.by());
        return this;
    }

    public RegistrationPage selectCourse(String course) {
        selectFromDropDownByVisibleText(course, RegistrationPageLocators.COURSES_LIST_LOCATOR.by());
        return this;
    }

    public RegistrationPage selectMonth(String month) {
        selectFromDropDownByVisibleText(month, RegistrationPageLocators.MONTHS_LIST_LOCATOR.by());
        return this;
    }

    public RegistrationPage clickLinkedInRadioButton() {
        clickOnElement(RegistrationPageLocators.LINKEDIN_RADIO_BUTTON_LOCATOR.by());
        return this;
    }

    public void clickOnRegisterButton() {
        clickOnElement(RegistrationPageLocators.REGISTER_BUTTON_LOCATOR.by());
        navigateToPage(Settings.loginUrl);
    }
}
