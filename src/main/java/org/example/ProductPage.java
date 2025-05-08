package org.example;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import java.time.Duration;
import java.util.Collections;

public class ProductPage extends FirstTest{
    public ProductPage(AndroidDriver driver) {
        super(driver); //  Sets the inherited driver
    }

    public void tapByCoordinates(int x, int y) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence tap = new Sequence(finger, 1);
        tap.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x, y));
        tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singletonList(tap));  // Correct way to perform the action
    }


    public void productpage() throws InterruptedException {
        clickMFTab();
        waitSeconds(1);
//        Click in Motilal Scheme
//        clickByXpath("//android.view.ViewGroup[@content-desc=\"HDFC Flexi Cap Direct Plan Growth\"]");
        clickByXpath("//android.view.ViewGroup[@content-desc=\"HDFC Flexi Cap Direct Plan Growth\"]");
        waitForElement(AppiumBy.xpath("//android.widget.TextView[@text=\"1M\"]"),10).click();
        waitForElement(AppiumBy.xpath("//android.widget.TextView[@text=\"6M\"]"),10).click();
        waitForElement(AppiumBy.xpath("//android.widget.TextView[@text=\"1Y\"]"),10).click();
        waitForElement(AppiumBy.xpath("//android.widget.TextView[@text=\"3Y\"]"),10).click();
        waitForElement(AppiumBy.xpath("//android.widget.TextView[@text=\"5Y\"]"),10).click();
        waitForElement(AppiumBy.xpath("//android.widget.TextView[@text=\"ALL\"]"),10).click();
        scrollDownOnce();
        System.out.println("Duration of scheme - success");

//      Checking the Return Calculator Section
        waitForElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Return calculator\"]"),10).click();
        clickByXpath("//android.widget.TextView[@text=\"Monthly SIP\"]");
        clickById("com.nextbillion.groww:id/text1yBack");
        clickById("com.nextbillion.groww:id/text3yBack");
        clickById("com.nextbillion.groww:id/text5yBack");
        waitForElement(AppiumBy.xpath("//android.widget.TextView[@text=\"One-Time\"]"),10).click();
        clickById("com.nextbillion.groww:id/text1yBack");
        clickById("com.nextbillion.groww:id/text3yBack");
        clickById("com.nextbillion.groww:id/text5yBack");
        System.out.println("Return calculator Success");

//      Checking the Holdings Section
        waitForElement(AppiumBy.xpath("(//android.view.ViewGroup[@resource-id=\"com.nextbillion.groww:id/viewCardHeader\"])[1]"),10).click();
        scrollDownOnce();
        waitForElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.nextbillion.groww:id/holdingAnalysis\"]"),10).click();
        scrollDownOnce();
        waitSeconds(2);
        clickBack();
        waitForElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.nextbillion.groww:id/seeAllHolding\"]"),10).click();
        scrollToEnd();
        scrollToEnd();
        System.out.println("Holdings Section Completed");

//      Checking the Returns & rankings Section
        waitSeconds(2);
        waitForElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Returns & rankings\"]"),10).click();
        waitForElement(AppiumBy.id("com.nextbillion.groww:id/toggleTv"),10).click();
        waitForElement(AppiumBy.id("com.nextbillion.groww:id/toggleTv"),10).click();
        waitForElement(AppiumBy.id("com.nextbillion.groww:id/understandReturns"),10).click();
        waitSeconds(1);
        clickBack();
        scrollToEnd();
        System.out.println("Returns & rankings completed");


//        Checking Similiar finds
        waitSeconds(2);
        clickByXpath("//android.widget.TextView[@content-desc=\"Similar funds\"]");
        clickByXpath("//android.widget.TextView[@resource-id=\"com.nextbillion.groww:id/toggleView\"]");
        clickByXpath("//android.widget.TextView[@resource-id=\"com.nextbillion.groww:id/toggleView\"]");
        clickByXpath("//android.widget.TextView[@resource-id=\"com.nextbillion.groww:id/toggleView\"]");
        clickByXpath("//android.widget.TextView[@resource-id=\"com.nextbillion.groww:id/toggleView\"]");
        clickByXpath("//android.widget.TextView[@resource-id=\"com.nextbillion.groww:id/toggleView\"]");
        scrollToEnd();
        System.out.println("Similar Funds Completed");

//        Checking Expense ratio, exit load & tax
        waitSeconds(3);
        waitForElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Expense ratio, exit load & tax\"]"),10).click();
        scrollToEnd();
        waitSeconds(3);
        waitForElement(AppiumBy.id("com.nextbillion.groww:id/understandTerms"),10).click();
        waitSeconds(2);
        clickBack();
        waitForElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.nextbillion.groww:id/btn_text\" and @text=\"Check past data\"]"),10).click();
        waitSeconds(2);
        waitForElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Expense ratio\"]"),10).click();
        waitSeconds(2);
        waitForElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Exit load\"]"),10).click();
        clickBack();
        System.out.println("Expense ratio, exit load & tax Completed");


//        Checking Fund management
        waitSeconds(5);


//        clickByTextStart("View details");


        clickByXpath("//android.widget.TextView[@content-desc=\"Fund management\"]");
        scrollToEnd();
        waitSeconds(1);
        clickByXpath("//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.nextbillion.groww:id/mainItemRv\"]/android.widget.LinearLayout[2]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]");
        scrollToEnd();
        waitSeconds(1);
        clickByXpath("//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.nextbillion.groww:id/mainItemRv\"]/android.widget.LinearLayout[1]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]");
        scrollToEnd();
        waitSeconds(1);
        clickByXpath("//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.nextbillion.groww:id/mainItemRv\"]/android.widget.LinearLayout[1]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]");
        scrollToEnd();
        waitSeconds(1);
        clickByXpath("//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.nextbillion.groww:id/mainItemRv\"]/android.widget.LinearLayout[1]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.view.View");
        scrollToEnd();


//        Checking Fund house & investment objective
        waitSeconds(5);
        clickByXpath("//android.widget.TextView[@content-desc=\"Fund house & investment objective\"]");
        waitSeconds(1);
        scrollToEnd();
        clickByXpath("//android.widget.TextView[@resource-id=\"com.nextbillion.groww:id/btn_text\" and @text=\"More Details\"]");
        waitSeconds(5);
        clickByXpath("//android.widget.ImageButton[@content-desc=\"Close tab\"]");
        waitSeconds(5);
        clickByXpath("//android.widget.TextView[@resource-id=\"com.nextbillion.groww:id/btn_text\" and @text=\"Scheme Information Document\"]");
        waitSeconds(5);
        clickByXpath("//android.widget.ImageButton[@content-desc=\"Close tab\"]");


//        Checking Other plans in the same fund
        scrollToEnd();
        waitSeconds(5);
        clickByXpath("//android.widget.TextView[@content-desc=\"Other plans in the same fund\"]");
        scrollToEnd();



//          driver.findElement(AppiumBy.xpath("")).click();


        waitSeconds(1);
//        driver.removeApp("com.nextbillion.groww");




//        System.out.println("App Unistalled");





    }
}
