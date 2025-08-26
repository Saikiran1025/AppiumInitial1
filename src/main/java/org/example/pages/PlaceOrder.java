package org.example.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.example.utils.GrowwUtils;
import org.openqa.selenium.WebElement;
import java.net.MalformedURLException;

public class PlaceOrder extends GrowwUtils {

    public PlaceOrder(AndroidDriver driver) {super(driver);}

    public void enterAmountById(String amount)
    {
        for (char digit : amount.toCharArray())
        {
            WebElement key = driver.findElement(AppiumBy.accessibilityId(String.valueOf(digit)));
            key.click();
        }
    }

    public void placeOrder() throws MalformedURLException, InterruptedException {

////      Click on Mutual Funds tab
//        clickMFTab();
//
////        Click in Motilal Scheme
//        waitForElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"Motilal Oswal Midcap Fund Direct Growth\"]"),10).click();


//      Click on One-time
        waitForElement(AppiumBy.id("com.nextbillion.groww:id/buttonOneTime"),10).click();
        enterAmountById("500");
        waitForElement(AppiumBy.xpath("//android.widget.TextView[@text=\"\uE315\"]"),10).click();
        waitForElement(AppiumBy.accessibilityId("Add new UPI ID, \uEA2B"),10).click();
        waitForElement(AppiumBy.xpath("//android.widget.EditText[@text=\"123456@ybl\"]"),10).sendKeys("saikiranindian25011@ybl");
        waitForElement(AppiumBy.accessibilityId("BUTTON_PAY"),10).click();
        waitSeconds(10);
        waitForElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"Confirm\"]/android.view.ViewGroup"),10).click();

        System.out.println("Place Order Completed");











//        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Invest\"]")).click();
//        By allowButton = AppiumBy.id("com.android.permissioncontroller:id/permission_allow_button");
//        By allowLocationButton = AppiumBy.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button");
//
//        if(isElementPresent(allowButton))
//        {
//            waitForElement(allowButton,10).click();
//            waitSeconds(2);
//            if (isElementPresent(allowButton))
//            {
//                waitForElement(allowButton,10).click();
//                waitSeconds(2);
//                if (isElementPresent(allowLocationButton))
//                    waitForElement(allowLocationButton,10).click();
//                waitSeconds(2);
//            }
//        }





    }

}
