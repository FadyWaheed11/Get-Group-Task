package locators;

import org.openqa.selenium.By;

public enum RegistrationPageLocators {

    FIRST_NAME_LOCATOR(By.id("nf-field-17")),
    LAST_NAME_LOCATOR(By.id("nf-field-18")),
    EMAIL_LOCATOR(By.id("nf-field-19")),
    PHONE_LOCATOR(By.id("nf-field-20")),
    COURSES_LIST_LOCATOR(By.id("nf-field-22")),
    MONTHS_LIST_LOCATOR(By.id("nf-field-24")),
    LINKEDIN_RADIO_BUTTON_LOCATOR(By.id("nf-label-class-field-23-1")),
    REGISTER_BUTTON_LOCATOR(By.id("nf-field-15"));
    private final By locator;

    RegistrationPageLocators(By locator) {
        this.locator = locator;
    }

    public By by() {
        return this.locator;
    }
}
