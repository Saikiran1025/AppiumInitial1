package org.example.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.example.utils.GrowwUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.net.MalformedURLException;
import java.time.Duration;



public class Login extends GrowwUtils
{
      public Login(AndroidDriver driver) {super(driver);}

    public void googlelogin() throws MalformedURLException, InterruptedException {
        WebDriver driver = null;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement emailOption = driver.findElement(AppiumBy.id("com.google.android.gms:id/account_name"));
        emailOption.click();
        WebElement allow = driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_button\"]"));
        allow.click();
    }

    public void manualLogin() throws InterruptedException {
        waitSeconds(5);
        clickById("com.nextbillion.groww:id/btnLoginWithOtherEmail");
        waitSeconds(5);
        clickBack();
        waitForElement(AppiumBy.id("com.nextbillion.groww:id/btnLoginWithOtherEmail"),10);
        clickById("com.nextbillion.groww:id/emailSignIn");
        clickBack();

        WebElement emailInput = waitForElement(AppiumBy.id("com.nextbillion.groww:id/editEmailAddress"), 10);
        emailInput.sendKeys("saikiran1025@gmail.com");
        clickByXpath("//android.widget.Button[@resource-id=\"com.nextbillion.groww:id/buttonProceed\"]");
        WebElement password = waitForElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.nextbillion.groww:id/editSetPassword\"]"), 10);
        password.sendKeys("Groww@1234");
        clickByXpath("//android.widget.Button[@resource-id=\"com.nextbillion.groww:id/buttonProceed\"]");
    }

    public void enterPin(String pin) {
        for (char c : pin.toCharArray()) {
            driver.findElement(AppiumBy.id("com.nextbillion.groww:id/button" + c)).click();
        }
        if (isElementPresent(AppiumBy.id("com.nextbillion.groww:id/growwLogoV2")))
            System.out.println("Login Successfull");
        else
            System.out.println("Login Failed");


    }
}

