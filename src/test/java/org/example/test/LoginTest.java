package org.example.test;
import com.sun.source.tree.AssertTree;
import io.appium.java_client.AppiumBy;
import org.example.utils.GrowwUtils;
import org.example.test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

//    @Test(priority = 1, description = "Verify manual login with valid credentials")
//    public void testManualLoginWithValidCredentials() throws InterruptedException {
//        loginPage.manualLogin();
//        loginPage.enterPin("1234");
//    }
//
//    @Test(priority = 2, description = "Verify manual login flow navigation")
//    public void testManualLoginFlowNavigation() throws InterruptedException {
//        // Test the navigation through login steps without completing
//        waitSeconds(5);
//        clickBack();
//        clickById("com.nextbillion.groww:id/emailSignIn");
//        // Verify login form elements are present
//        assert isElementPresent(io.appium.java_client.AppiumBy.id("com.nextbillion.groww:id/editEmailAddress"));
//    }
//
//    @Test(priority = 3, description = "Verify Google login option availability")
//    public void testGoogleLoginOption() throws Exception {
//        // This test is disabled as it requires Google Play Services
//        loginPage.googlelogin();
//    }

    @Test(priority = 4, description = "Verify PIN entry functionality")
    public void testPinEntry() throws InterruptedException {
        launchApp();
        loginPage.enterPin("1025");
        waitSeconds(3);
        Assert.assertTrue(isElementPresent(AppiumBy.id("com.nextbillion.groww:id/growwLogoV2")), "Login was not successful");
        System.out.println("Login successful, Groww logo is displayed.");
    }

//    @Test(priority = 5, description = "Verify login form validation")
//    public void testLoginFormValidation() throws InterruptedException {
//        waitSeconds(5);
//        clickBack();
//        clickById("com.nextbillion.groww:id/emailSignIn");
//
//        // Test with empty email
//        clickByXpath("//android.widget.Button[@resource-id=\"com.nextbillion.groww:id/buttonProceed\"]");
//
//        // Verify validation message appears
//        waitSeconds(2);
//    }
}