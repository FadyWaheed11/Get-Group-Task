package locators;

import org.openqa.selenium.By;

public enum LoginPageLocators {

    EMAIL_LOCATOR(By.id("user_login")),
    PASSWORD_LOCATOR(By.id("user_pass")),
    REMEMBER_ME_CHECKBOX_LOCATOR(By.id("rememberme")),
    LOGIN_BUTTON_LOCATOR(By.id("wp-submit")),
    LOGIN_ERROR_MESSAGE_LOCATOR(By.id("login_error"));
    private final By locator;

    LoginPageLocators(By locator) {
        this.locator = locator;
    }

    public By by() {
        return this.locator;
    }
}
