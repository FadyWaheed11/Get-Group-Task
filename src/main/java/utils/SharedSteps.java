package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import settings.Settings;

import java.io.File;
import java.io.IOException;

import static utils.DriverFactory.*;

public final class SharedSteps {
    private static final WebDriver driver = getDriver(Settings.browserName);
    private static final WebDriverWait wait = getDriverWait();

    public static void clickOnElement(By elementPath) {
        wait.until(ExpectedConditions.elementToBeClickable(elementPath)).click();
    }

    public static void clickOnElement(WebElement elementPath) {
        wait.until(ExpectedConditions.elementToBeClickable(elementPath)).click();
    }

    public static void sendTextToElement(String text, By elementPath) {
        WebElement element = driver.findElement(elementPath);
        wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(text);
    }

    public static void selectFromDropDownByVisibleText(String value, By dropDownPath) {
        findDropDownElement(dropDownPath).selectByVisibleText(value);
    }

    public static void navigateToPage(String url) {
        driver.navigate().to(url);
    }

    public static boolean isDisplayed(By elementPath) {
        return driver.findElement(elementPath).isDisplayed();
    }

    public static void takeScreenShot(String filePath) {
        try {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileHandler.copy(scrFile, new File(filePath + "/failedTest.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Select findDropDownElement(By dropDownPath) {
        return new Select(driver.findElement(dropDownPath));
    }

}
