package end_to_end;

import base.BaseTest;
import data_driven.RegisterData;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.RegistrationPage;

import static data_driven.RegisterData.getRegisterData;
import static org.testng.AssertJUnit.assertFalse;
import static pages.LoginPage.getLoginPage;
import static pages.RegistrationPage.getRegistrationPage;

@Listeners(utils.TestListener.class)
public class EndToEndTest extends BaseTest {

    RegistrationPage registrationPage = getRegistrationPage();
    LoginPage loginPage = getLoginPage();
    RegisterData registerData = getRegisterData();

    @Test
    public void test() {
        registrationPage
                .fillFirstName(registerData.getFirstName())
                .fillLastName(registerData.getLastName())
                .fillEmail(registerData.getEmail())
                .fillPhoneNumber(registerData.getPhoneNumber())
                .selectCourse(registerData.getCourse())
                .selectMonth(registerData.getMonth())
                .clickLinkedInRadioButton()
                .clickOnRegisterButton();

        boolean actualResult = loginPage
                .fillEmail(registerData.getEmail())
                .fillPassword(registerData.getPassword())
                .clickOnRememberMeCheckBox()
                .clickOnLoginButton()
                .loginErrorMessageIsDisplayed();

        assertFalse(actualResult);
    }
}
