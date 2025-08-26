package org.example.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.example.utils.GrowwUtils;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import java.time.Duration;
import java.util.Collections;

public class ProductPage extends GrowwUtils {
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
//        Seleting Scheme
//        clickByXpath("//android.view.ViewGroup[@content-desc=\"HDFC Flexi Cap Direct Plan Growth\"]");
        waitForElement(AppiumBy.accessibilityId("Motilal Oswal Midcap Fund Direct Growth"),10).click();
        waitForElement(AppiumBy.xpath("//android.widget.TextView[@text=\"1M\"]"), 10).click();
        waitForElement(AppiumBy.xpath("//android.widget.TextView[@text=\"6M\"]"), 10).click();
        waitForElement(AppiumBy.xpath("//android.widget.TextView[@text=\"1Y\"]"), 10).click();
        waitForElement(AppiumBy.xpath("//android.widget.TextView[@text=\"3Y\"]"), 10).click();
        waitForElement(AppiumBy.xpath("//android.widget.TextView[@text=\"5Y\"]"), 10).click();
        waitForElement(AppiumBy.xpath("//android.widget.TextView[@text=\"ALL\"]"), 10).click();
        scrollUpOnce();
        System.out.println("Duration of scheme - success");

//      Checking the Return Calculator Section
        waitForElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Return calculator\"]"), 10).click();
        clickByXpath("//android.widget.TextView[@text=\"Monthly SIP\"]");
        clickById("com.nextbillion.groww:id/text1yBack");
        clickById("com.nextbillion.groww:id/text3yBack");
        clickById("com.nextbillion.groww:id/text5yBack");
        waitForElement(AppiumBy.xpath("//android.widget.TextView[@text=\"One-Time\"]"), 10).click();
        clickById("com.nextbillion.groww:id/text1yBack");
        clickById("com.nextbillion.groww:id/text3yBack");
        clickById("com.nextbillion.groww:id/text5yBack");
        System.out.println("Return calculator Success");

//      Checking the Holdings Section
        clickByTextStart("Holding");
//        waitForElement(AppiumBy.xpath("(//android.view.ViewGroup[@resource-id=\"com.nextbillion.groww:id/viewCardHeader\"])[1]"), 10).click();
        scrollToEnd();
        waitSeconds(2);
        waitForElement(AppiumBy.id("com.nextbillion.groww:id/holdingAnalysis"),10).click();
        scrollToEnd();
        waitSeconds(2);
        clickBack();
        waitForElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.nextbillion.groww:id/seeAllHolding\"]"), 10).click();
        waitSeconds(2);
        scrollToEnd();
        System.out.println("Holdings Section Completed");

//      Checking the Returns & rankings Section
        waitSeconds(2);
        waitForElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Returns & rankings\"]"), 10).click();
        waitForElement(AppiumBy.id("com.nextbillion.groww:id/toggleTv"), 10).click();
        waitForElement(AppiumBy.id("com.nextbillion.groww:id/toggleTv"), 10).click();
        waitForElement(AppiumBy.id("com.nextbillion.groww:id/understandReturns"), 10).click();
        waitSeconds(1);
        clickBack();
        scrollToEnd();
        System.out.println("Returns & rankings completed");


//        Checking Similiar finds
        waitSeconds(2);
        waitForElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Similar funds\"]"), 10).click();
        clickByXpath("//android.widget.TextView[@resource-id=\"com.nextbillion.groww:id/toggleView\"]");
        clickByXpath("//android.widget.TextView[@resource-id=\"com.nextbillion.groww:id/toggleView\"]");
        clickByXpath("//android.widget.TextView[@resource-id=\"com.nextbillion.groww:id/toggleView\"]");
        clickByXpath("//android.widget.TextView[@resource-id=\"com.nextbillion.groww:id/toggleView\"]");
        clickByXpath("//android.widget.TextView[@resource-id=\"com.nextbillion.groww:id/toggleView\"]");
        scrollToEnd();
        System.out.println("Similar Funds Completed");

//        Checking Expense ratio, exit load & tax
        waitSeconds(3);
        waitForElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Expense ratio, exit load & tax\"]"), 10).click();
        scrollToEnd();
        waitSeconds(3);
        waitForElement(AppiumBy.id("com.nextbillion.groww:id/understandTerms"), 10).click();
        waitSeconds(2);
        clickBack();
        waitForElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.nextbillion.groww:id/btn_text\" and @text=\"Check past data\"]"), 10).click();
        waitSeconds(2);
        waitForElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Expense ratio\"]"), 10).click();
        waitSeconds(2);
        waitForElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Exit load\"]"), 10).click();
        waitSeconds(3);
        clickBack();
        System.out.println("Expense ratio, exit load & tax Completed");

//        Checking Fund management
        waitSeconds(5);
        waitForElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Fund management\"]"), 10).click();
        while (true) {
            try {
                clickByTextStart("View details");
                scrollToEnd();
            } catch (Exception e) {
                System.out.println("No more 'View details' elements found.");
                break;
            }
        }



//        Checking Fund house & investment objective
        waitSeconds(4);
        waitForElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Fund house & investment objective\"]"), 10).click();
        waitSeconds(4);
        scrollToEnd();
        waitForElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.nextbillion.groww:id/btn_text\" and @text=\"More Details\"]"), 10).click();
        waitSeconds(4);
        clickBack();
        waitSeconds(4);
//        waitForElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.nextbillion.groww:id/btn_text\" and @text=\"Scheme Information Document\"]"), 10).click();
//        waitSeconds(4);
//        clickBack();
//        waitSeconds(2);
//        clickBack();
//        waitForElement(AppiumBy.xpath("//android.widget.ImageButton[@content-desc=\"Close tab\"]"), 10).click();
//        waitSeconds(4);
//        Checking Other plans in the same fund
        scrollToEnd();
        waitForElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Other plans in the same fund\"]"), 10).click();
        scrollToEnd();



    }
}
