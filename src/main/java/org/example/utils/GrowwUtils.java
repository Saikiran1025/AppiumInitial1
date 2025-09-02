package org.example.utils;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GrowwUtils {
    public AndroidDriver driver;
    public GrowwUtils(){}

    public GrowwUtils(AndroidDriver driver) {
        this.driver = driver;
    }

    public void setup() throws MalformedURLException, InterruptedException {
        String appiumServerUrl = "http://127.0.0.1:4723";
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("platformName", "Android");
        dc.setCapability("deviceName", "emulator-5554");
        dc.setCapability("appium:automationName", "uiautomator2");
//        dc.setCapability("appium:app", "/Users/skiran/IdeaProjects/AppiumInitial/Apps/groww20apr.apk");
        dc.setCapability("appium:appPackage","com.nextbillion.groww");
        dc.setCapability("appium:appActivity","com.nextbillion.groww.genesys.loginsignup.activities.LoginActivity");
        dc.setCapability("noReset", true);
        driver = new AndroidDriver(new URL(appiumServerUrl), dc);

    }

    public void enterAmount(String amount) {
        for (char c : amount.toCharArray()) {
            driver.findElement(AppiumBy.id("com.nextbillion.groww:id/button" + c)).click();
        }
    }

    public void launchApp() {driver.activateApp("com.nextbillion.groww");}

    public void closeApp() {driver.terminateApp("com.nextbillion.groww");}

    public void clickById(String id) {driver.findElement(AppiumBy.id(id)).click();}

    public void clickByXpath(String xpath) {driver.findElement(AppiumBy.xpath(xpath)).click();}

    public void waitSeconds(int sec) throws InterruptedException {Thread.sleep(sec * 1000);}

    public By clickByTextStart(String text) {
        By locator = AppiumBy.androidUIAutomator("new UiSelector().textStartsWith(\"" + text + "\")");
        driver.findElement(locator).click();
        return locator;
    }

    public void clickMFTab(){ waitForElement(AppiumBy.id("com.nextbillion.groww:id/actionMutualFundTab"), 10).click();}

    public void clickSipTab(){ waitForElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.nextbillion.groww:id/textView\" and @text=\"SIPs\"]"), 10).click();}

    public void clickBack(){driver.navigate().back();}

    public void scrollToEnd() {
        List<WebElement> scrollables = driver.findElements(
                AppiumBy.androidUIAutomator("new UiSelector().scrollable(true)"));
        if (!scrollables.isEmpty()) {
            driver.findElement(AppiumBy.androidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(10)"));
        }
    }

    public void scrollToTop() {
        List<WebElement> scrollables = driver.findElements(
                AppiumBy.androidUIAutomator("new UiSelector().scrollable(true)"));
        if (!scrollables.isEmpty()) {
            driver.findElement(AppiumBy.androidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true)).scrollToBeginning(10)"));
        }
    }

    public void scrollUpOnce(){
        List<WebElement> scrollables = driver.findElements(
                AppiumBy.androidUIAutomator("new UiSelector().scrollable(true)"));
        if (!scrollables.isEmpty()) {
            driver.findElement(AppiumBy.androidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true)).scrollForward()"));
        }
    }

    public void scrollUp() {
        List<WebElement> scrollables = driver.findElements(
                AppiumBy.androidUIAutomator("new UiSelector().scrollable(true)"));
        if (!scrollables.isEmpty()) {
            driver.findElement(AppiumBy.androidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true)).scrollToBeginning(7)"));
            System.out.println("Scrolled to the top of the page.");
        }
    }

    public void scrollDownOnce() {
        List<WebElement> scrollables = driver.findElements(
                AppiumBy.androidUIAutomator("new UiSelector().scrollable(true)"));
        if (!scrollables.isEmpty()) {
            driver.findElement(AppiumBy.androidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true)).scrollBackward()"));
        }
    }

    public void scrollHalfPageUp() {
        Dimension size = driver.manage().window().getSize();
        int startX = size.width / 2;
        int startY = (int) (size.height * 0.8);  // bottom area
        int endY = (int) (size.height * 0.4);    // middle area
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);
        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(), startX, endY));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singletonList(swipe));
    }

    public void scrollToText(String text) {
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().textContains(\"" + text + "\"))"));
    }

    public boolean isScrollable() {
        List<WebElement> scrollables = driver.findElements(AppiumBy.androidUIAutomator("new UiSelector().scrollable(true)"));
        return !scrollables.isEmpty();
    }

    public WebElement waitForElement(By locator, int i) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(i));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        }
        catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isChildPresentInParent(WebElement element, By locator) {
        try {
            element.findElement(locator);
            return true;
        }
        catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isClickable(By locator, int timeoutInSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            if (element.isEnabled()){
                if (element.isDisplayed()) {
                    return true;
                }
            }
            else {
                return false;
            }
            return true;
        }
        catch (Exception e) {
            System.out.println("Element is not clickable: " + locator.toString());
            return false;
        }
    }

    public void redeemFolioSelection() throws InterruptedException {
        By redeem = AppiumBy.id("com.nextbillion.groww:id/btnPrimary");
        if (isElementPresent(AppiumBy.id("com.nextbillion.groww:id/tvRedeemAll"))) {
            System.out.println("Redeem is Available");
        }
        else if (isElementPresent(AppiumBy.xpath("(//android.view.ViewGroup[@resource-id=\"com.nextbillion.groww:id/container\"])[1]"))){
            waitForElement(redeem,10).click();
        }
        else if (isElementPresent(AppiumBy.xpath("(//android.view.ViewGroup[@resource-id=\"com.nextbillion.groww:id/container\"])[2]"))){
            waitForElement(redeem,10).click();
        }
        else if (isElementPresent(AppiumBy.xpath("(//android.view.ViewGroup[@resource-id=\"com.nextbillion.groww:id/container\"])[3]"))){
            waitForElement(redeem,10).click();
        }
        else if (isElementPresent(AppiumBy.xpath("(//android.view.ViewGroup[@resource-id=\"com.nextbillion.groww:id/container\"])[4]"))){
            waitForElement(redeem,10).click();
        }
        else {
            System.out.println("Redeem Button is not clickable");
        }
    }

    public void slideProceedButtonLeftToRight(By locator) throws InterruptedException {
        try {
            // 1. Locate the btnProceed element using your waitForElement method.
            WebElement proceedButton = waitForElement(locator, 10);

            if (proceedButton == null || !proceedButton.isDisplayed() || !proceedButton.isEnabled()) {
                System.out.println("'Proceed' button not found or not interactable. Cannot perform swipe.");
                return;
            }

            // 2. Get the location and size of the element to define the swipe area.
            int x = proceedButton.getLocation().getX();
            int y = proceedButton.getLocation().getY();
            int width = proceedButton.getSize().getWidth();
            int height = proceedButton.getSize().getHeight();

            // Define the swipe start and end points within the element's bounds.
            // We'll swipe from 10% of the element's width to 90% of its width.
            // The Y coordinate will be in the middle of the element's height.
            int swipeStartX = (int) (x + width * 0.1);  // Start near the left edge of the button
            int swipeStartY = (int) (y + height * 0.5); // Middle of the button vertically
            int swipeEndX = (int) (x + width * 0.9);    // End near the right edge of the button

            // The 'width' parameter for mobile:swipeGesture is the distance of the swipe,
            // not the width of the element.
            int swipeDistance = swipeEndX - swipeStartX;


            driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
                    "left", swipeStartX,
                    "top", swipeStartY,
                    "width", swipeDistance, // The distance to swipe horizontally
                    "height", 1, // Minimal height for a mostly horizontal swipe
                    "direction", "right", // Swipe from left to right
                    "percent", 1.0 // Ensure the swipe covers the defined distance
            ));

            Thread.sleep(2000); // Wait for the UI to react after the swipe

            // Optional: After sliding, you might want to assert a new state or
            // check for a new element.
            // For example, if sliding enables/disables the button, you can check its status.

        } catch (org.openqa.selenium.NoSuchElementException e) {
            System.err.println("'Proceed' button not found. Cannot perform swipe. Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An error occurred during sliding the 'Proceed' button: " + e.getMessage());
        }
    }



}
