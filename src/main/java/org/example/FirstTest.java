package org.example;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;

public class FirstTest {

//    public AndroidDriver driver;
protected AndroidDriver driver;
    public FirstTest() {}
    public FirstTest(AndroidDriver driver) {
        this.driver = driver;
    }

    public void setup() throws MalformedURLException, InterruptedException {
        String appiumServerUrl = "http://127.0.0.1:4723";
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("platformName", "Android");
        dc.setCapability("appium:automationName", "uiautomator2");
//        dc.setCapability("appium:app", "/Users/skiran/IdeaProjects/AppiumInitial/Apps/groww20apr.apk");
        dc.setCapability("appium:appPackage","com.nextbillion.groww");
        dc.setCapability("appium:appActivity","com.nextbillion.groww.genesys.loginsignup.activities.LoginActivity");
        dc.setCapability("noReset", true);
        driver = new AndroidDriver(new URL(appiumServerUrl), dc);

    }
    public void launchApp() {driver.activateApp("com.nextbillion.groww");}

    public void closeApp()
    {
        driver.terminateApp("com.nextbillion.groww");
    }

    public void clickById(String id) {driver.findElement(AppiumBy.id(id)).click();}

    public void clickByXpath(String xpath) {driver.findElement(AppiumBy.xpath(xpath)).click();}

    public void waitSeconds(int sec) throws InterruptedException {Thread.sleep(sec * 1000);}

    public void clickByTextStart(String text) {driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().textStartsWith(\"" + text + "\")")).click();}

    public void clickMFTab(){ clickById("com.nextbillion.groww:id/actionMutualFundTab");}

    public void clickBack(){driver.navigate().back();}

    public void scrollToEnd()
    {
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(10)"));
    }

    public void scrollDownOnce()
    {
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(1)"));
    }

    public void scrollUp()
    {
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollToBeginning(7)"));
    }

    public void scrollUpOnce()
    {
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollToBeginning(1)"));
    }

    public WebElement waitForElement(By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


    public static void main(String[] args) throws MalformedURLException, InterruptedException
    {
        FirstTest f = new FirstTest();
        f.setup();
//        f.launchApp();
//        Thread.sleep(5000);
        Login l = new Login(f.driver);
//        l.googlelogin();
//        l.manualLogin();
//        l.enterPin("1025");
        ProductPage pp = new ProductPage(f.driver);
//        f.launchApp();
//        Thread.sleep(5000);
//        l.enterPin("1025");
        pp.productpage();
//        System.out.println("Product Page Completed");
//        f.closeApp();
//        Thread.sleep(5000);
//        PlaceOrder p = new PlaceOrder(f.driver);
//        f.launchApp();
//        Thread.sleep(5000);
//        l.enterPin("1025");
//        Thread.sleep(5000);
//        p.placeOrder();
//        System.out.println("Place Order Completed");
//        f.closeApp();
//        Thread.sleep(5000);
//        ExploreTab e = new ExploreTab(f.driver);
//        f.launchApp();
//        Thread.sleep(5000);
//        l.enterPin("1025");
//        Thread.sleep(5000);
//        e.exploreTab();
//        System.out.println("Explore Tab completed");

//        Dashboard d = new Dashboard(f.driver);
//        f.launchApp();
//        Thread.sleep(5000);
//        l.enterPin("1025");
//        d.dashbord();





//        f.closeApp();


        System.out.println("Completed");



    }
}

