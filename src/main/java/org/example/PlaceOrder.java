package org.example;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import java.net.MalformedURLException;

public class PlaceOrder extends FirstTest {

    public PlaceOrder(AndroidDriver driver) {super(driver);}


    public void placeOrder() throws MalformedURLException, InterruptedException {

//      Click on Mutual Funds tab
        Thread.sleep(5000);
        clickById("com.nextbillion.groww:id/actionMutualFundTab");

//        Click in Motilal Scheme
        clickByXpath("//android.view.ViewGroup[@content-desc=\"Motilal Oswal Midcap Fund Direct Growth\"]");
        Thread.sleep(2000);


//      Click on One-time
        clickById("com.nextbillion.groww:id/buttonOneTime");
        Thread.sleep(2000);
        WebElement amountField1 = driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"numpad-Ripple-1-undefined-1\"]"));
        WebElement amountField2 = driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"numpad-Ripple-1-undefined-2\"]"));
        WebElement amountField3 = driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"numpad-Ripple-1-undefined-3\"]"));
        WebElement amountField4 = driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"numpad-Ripple-1-undefined-4\"]"));
        WebElement amountField5 = driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"numpad-Ripple-1-undefined-5\"]"));
        WebElement amountField6 = driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"numpad-Ripple-1-undefined-6\"]"));
        WebElement amountField7 = driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"numpad-Ripple-1-undefined-7\"]"));
        WebElement amountField8 = driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"numpad-Ripple-1-undefined-8\"]"));
        WebElement amountField9 = driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"numpad-Ripple-1-undefined-9\"]"));
        WebElement amountField0 = driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"numpad-Ripple-1-undefined-0\"]"));
        amountField5.click();
        amountField0.click();
        amountField0.click();
        Thread.sleep(5000);
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Invest\"]")).click();




    }

}
