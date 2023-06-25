package utils;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import settings.Settings;

import static utils.SharedSteps.takeScreenShot;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Error " + result.getName() + " test has failed *****");
        String methodName = result.getName().trim();
        ITestContext context = result.getTestContext();
        WebDriver driver = (WebDriver) context.getAttribute("driver");
        takeScreenShot(Settings.screenShotFailedTestsPath);
    }
}
