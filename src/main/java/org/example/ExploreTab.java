package org.example;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class ExploreTab extends FirstTest {
    public ExploreTab(AndroidDriver driver) {
        super(driver); //  Sets the inherited driver
    }

    public void exploreTab() throws InterruptedException {
        Thread.sleep(5000);
//        Click on Mutual Funds Tab
        clickMFTab();
//        Click on Explore Tab
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.nextbillion.groww:id/textView\" and @text=\"Explore\"]")).click();
//        Verify All Mutual Funds Tab
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.nextbillion.groww:id/btn_text\" and @text=\"All Mutual Funds\"]")).click();
        clickBack();
//        Verify All High return Tab
        driver.findElement(AppiumBy.xpath("(//android.widget.ImageView[@resource-id=\"com.nextbillion.groww:id/ivCollectionImage\"])[1]")).click();
        clickById("com.nextbillion.groww:id/btn_text");
        clickById("com.nextbillion.groww:id/btn_text");
        clickById("com.nextbillion.groww:id/btn_text");
        Thread.sleep(2000);
        scrollToEnd();
        Thread.sleep(2000);
        clickBack();
//        Verify All SIP with 500 Tab
        clickByXpath("(//android.widget.ImageView[@resource-id=\"com.nextbillion.groww:id/ivCollectionImage\"])[2]");
        clickById("com.nextbillion.groww:id/btn_text");
        clickById("com.nextbillion.groww:id/btn_text");
        clickById("com.nextbillion.groww:id/btn_text");
        Thread.sleep(2000);
        scrollToEnd();
        Thread.sleep(2000);
        clickBack();
//        Verify All Tax Saving Tab
        driver.findElement(AppiumBy.xpath("//android.widget.LinearLayout[@content-desc=\"Tax Saving\"]")).click();
        clickById("com.nextbillion.groww:id/btn_text");
        clickById("com.nextbillion.groww:id/btn_text");
        clickById("com.nextbillion.groww:id/btn_text");
        Thread.sleep(2000);
        scrollToEnd();
        Thread.sleep(2000);
        clickBack();
//        Verify All Large Cap Tab
        driver.findElement(AppiumBy.xpath("(//android.widget.ImageView[@resource-id=\"com.nextbillion.groww:id/ivCollectionImage\"])[4]")).click();
        clickById("com.nextbillion.groww:id/btn_text");
        clickById("com.nextbillion.groww:id/btn_text");
        clickById("com.nextbillion.groww:id/btn_text");
        Thread.sleep(2000);
        scrollToEnd();
        Thread.sleep(2000);
        clickBack();
//        Verify All Mid Cap Tab
        driver.findElement(AppiumBy.xpath("(//android.widget.ImageView[@resource-id=\"com.nextbillion.groww:id/ivCollectionImage\"])[5]")).click();
        clickById("com.nextbillion.groww:id/btn_text");
        clickById("com.nextbillion.groww:id/btn_text");
        clickById("com.nextbillion.groww:id/btn_text");
        Thread.sleep(2000);
        scrollToEnd();
        Thread.sleep(2000);
        clickBack();
//        Verify All Small Cap Tab
        driver.findElement(AppiumBy.xpath("(//android.widget.ImageView[@resource-id=\"com.nextbillion.groww:id/ivCollectionImage\"])[6]")).click();
        clickById("com.nextbillion.groww:id/btn_text");
        clickById("com.nextbillion.groww:id/btn_text");
        clickById("com.nextbillion.groww:id/btn_text");
        Thread.sleep(2000);
        scrollToEnd();
        Thread.sleep(2000);
        clickBack();
//        Verify All Funds by Groww Tab
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.nextbillion.groww:id/btn_text\" and @text=\"View all\"]")).click();
        Thread.sleep(2000);
        scrollToEnd();
        Thread.sleep(2000);
        scrollUp();
        Thread.sleep(2000);
        driver.findElement(AppiumBy.xpath("//android.widget.RadioButton[@text=\"Equity\"]")).click();
        Thread.sleep(2000);
        scrollDownOnce();
        Thread.sleep(2000);
        scrollUp();
        Thread.sleep(2000);
        driver.findElement(AppiumBy.xpath("//android.widget.RadioButton[@text=\"Debt & Hybrid\"]")).click();
        Thread.sleep(2000);
        clickBack();
        Thread.sleep(2000);
        scrollDownOnce();
//        Verify Import funds Tab
        driver.findElement(AppiumBy.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.nextbillion.groww:id/mainList\"]/android.widget.LinearLayout/android.widget.GridView/android.view.ViewGroup[1]")).click();
        Thread.sleep(5000);
        clickBack();
        clickBack();
//        Verify NFOs Tab
        driver.findElement(AppiumBy.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.nextbillion.groww:id/mainList\"]/android.widget.LinearLayout/android.widget.GridView/android.view.ViewGroup[2]")).click();
        Thread.sleep(5000);
        clickBack();
//        Verify SIP calculator Tab
        driver.findElement(AppiumBy.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.nextbillion.groww:id/mainList\"]/android.widget.LinearLayout/android.widget.GridView/android.view.ViewGroup[3]")).click();
        Thread.sleep(4000);
    //            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"SIP\"]")).click();
        Thread.sleep(3000);
        scrollDownOnce();
        Thread.sleep(3000);
        scrollUpOnce();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Lumpsum\"]")).click();
        scrollDownOnce();
        Thread.sleep(3000);
        clickBack();
//        Verify Compare funds Tab
        scrollDownOnce();
        clickByXpath("(//android.widget.RelativeLayout[@resource-id=\"com.nextbillion.groww:id/icon\"])[4]");
        Thread.sleep(3000);
        clickByXpath("//android.webkit.WebView[@text=\"Compare\"]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[1]");
        Thread.sleep(3000);
        driver.findElement(AppiumBy.xpath("//android.widget.EditText")).sendKeys("Moti");
        Thread.sleep(3000);
        clickByXpath("//android.widget.ListView/android.view.View[1]");
        clickByXpath("//android.webkit.WebView[@text=\"Compare\"]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[2]");
        Thread.sleep(3000);
        driver.findElement(AppiumBy.xpath("//android.widget.EditText")).sendKeys("SBI");
        Thread.sleep(3000);
        clickByXpath("//android.widget.ListView/android.view.View[1]");
        Thread.sleep(2000);

        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"1Y\"]")).click();
        Thread.sleep(2000);
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"3Y\"]")).click();
        Thread.sleep(2000);
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"5Y\"]")).click();
        Thread.sleep(2000);
        scrollDownOnce();
        clickByXpath("//android.widget.TextView[@text=\"FUND DETAILS\"]");
        scrollDownOnce();
        Thread.sleep(2000);
        clickByXpath("//android.widget.TextView[@text=\"RETURNS\"]");
        scrollDownOnce();
        clickByXpath("//android.widget.TextView[@text=\"PROS & CONS\"]");
        scrollDownOnce();
        clickByXpath("//android.widget.TextView[@text=\"TOP 5 HOLDINGS\"]");
        scrollDownOnce();
        clickByXpath("//android.widget.TextView[@text=\"FUND MANAGERS\"]");
        scrollDownOnce();
        clickByXpath("//android.widget.TextView[@text=\"ABOUT FUND\"]");
        scrollDownOnce();
        clickByXpath("//android.widget.TextView[@text=\"POPULAR COMPARISONS\"]");
        scrollDownOnce();
        clickBack();
//        Verify Cart Section
        driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@resource-id=\"com.nextbillion.groww:id/cartSection\"]/android.widget.RelativeLayout")).click();
        Thread.sleep(3000);
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().textStartsWith(\"Pay\")")).click();
        Thread.sleep(3000);
        clickBack();
        clickBack();
        scrollDownOnce();
//        Verify All Mutual Funds Section
        driver.findElement(AppiumBy.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.nextbillion.groww:id/mainList\"]/android.view.ViewGroup[1]/android.view.ViewGroup")).click();
        Thread.sleep(3000);
        clickBack();


    }

}
