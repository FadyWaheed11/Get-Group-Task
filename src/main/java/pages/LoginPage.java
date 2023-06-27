package pages;

import static locators.LoginPageLocators.*;
import static utils.SharedSteps.*;

public class LoginPage {

    //Prevent instance
    private LoginPage() {
    }

    public static LoginPage getLoginPage() {
        return new LoginPage();
    }

    public LoginPage fillEmail(String email) {
        sendTextToElement(email, EMAIL_LOCATOR.by());
        return this;
    }

    public LoginPage fillPassword(String password) {
        sendTextToElement(password, PASSWORD_LOCATOR.by());
        return this;
    }

    public LoginPage clickOnRememberMeCheckBox() {
        clickOnElement(REMEMBER_ME_CHECKBOX_LOCATOR.by());
        return this;
    }

    public LoginPage clickOnLoginButton() {
        clickOnElement(LOGIN_BUTTON_LOCATOR.by());
        return this;
    }

    public boolean loginErrorMessageIsDisplayed() {
        return isDisplayed(LOGIN_ERROR_MESSAGE_LOCATOR.by());
    }
}
