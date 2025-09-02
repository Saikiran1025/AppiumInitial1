package org.example.pages;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.example.utils.GrowwUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class InvestmentDetails extends GrowwUtils {
    public InvestmentDetails(AndroidDriver driver) {
        super(driver);
    }
    By external = AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.nextbillion.groww:id/tvLabel\" and @text=\"External\"]");
    By demat = AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.nextbillion.groww:id/tvLabel\" and @text=\"Demat\"]");
    By allFolios = AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.nextbillion.groww:id/tvDescription\" and @text=\"All folios\"]");

    public void selectDematFolio() {
        if (isElementPresent(demat)) {
            waitForElement(demat, 10).click();
        } else {
            System.out.println("Demat Folio is not present");
        }
    }

    public void selectExternalFolio() {
        if (isElementPresent(external)) {
            waitForElement(external, 10).click();
        } else {
            System.out.println("External Folio is not present");
        }
    }

    public void selectPhysicalFolio() {
        List<WebElement> folios = driver.findElements(AppiumBy.xpath("(//android.view.ViewGroup[@resource-id=\"com.nextbillion.groww:id/viewFolioItem\"])"));
        if (folios.isEmpty()) {
            System.out.println("No folios found!");
        }
        for (WebElement folio : folios) {
            WebElement child = folio.findElement(AppiumBy.xpath(".//android.widget.TextView[@resource-id='com.nextbillion.groww:id/tvDescription']"));
            String s = child.getText();
            if (s.contains("All folios") || isChildPresentInParent(folio, AppiumBy.id("com.nextbillion.groww:id/tvLabel"))) {
                continue;
            }
            else {
                folio.click();
                break;
            }
        }
    }

    public void selectAllFolios() {
        if (isElementPresent(allFolios)) {
            waitForElement(allFolios, 10).click();
        } else {
            System.out.println("Only One Folio is present");
        }
    }

    public void availableAmountToSwitch() throws InterruptedException {
        waitForElement(AppiumBy.id("com.nextbillion.groww:id/tvAvailableAmtOrUnits"),10).click();
        String s= waitForElement(AppiumBy.id("com.nextbillion.groww:id/tvAvailableUnitOrAmount"),10).getText();
        System.out.println("Available to Switch is: "+s);
        waitSeconds(1);
        waitForElement(AppiumBy.id("com.nextbillion.groww:id/btnOkay"),10).click();
    }

    public void switchAmount(){
        waitForElement(AppiumBy.id("com.nextbillion.groww:id/btnSettings"),10).click();
        waitForElement(AppiumBy.id("com.nextbillion.groww:id/viewAmount"),10).click();
        waitForElement(AppiumBy.id("com.nextbillion.groww:id/btnConfirm"),10).click();
    }

    public void switchUnits(){
        waitForElement(AppiumBy.id("com.nextbillion.groww:id/btnSettings"),10).click();
        waitForElement(AppiumBy.id("com.nextbillion.groww:id/viewUnits"),10).click();
        waitForElement(AppiumBy.id("com.nextbillion.groww:id/btnConfirm"),10).click();
    }

    public void investmentDetailsFolioSelection() {
        if (isElementPresent(AppiumBy.id("com.nextbillion.groww:id/viewSelectionState"))) {
            waitForElement(AppiumBy.id("com.nextbillion.groww:id/viewSelectionState"), 10).click();
        } else {
            System.out.println("Only One Folio is present");
        }
    }

    public void investmentDetails() {
        waitForElement(AppiumBy.xpath("(//android.widget.LinearLayout[@resource-id=\"com.nextbillion.groww:id/item_container\"])[1]/android.view.ViewGroup"), 10).click();
        waitForElement(AppiumBy.id("com.nextbillion.groww:id/see_more_cta"), 10).click();
    }






    public void investmentDetailsSwitch() throws InterruptedException {
        if (isElementPresent(AppiumBy.id("com.nextbillion.groww:id/btnSwitch"))){
            waitForElement(AppiumBy.id("com.nextbillion.groww:id/btnSwitch"),10).click();
            if (isElementPresent(AppiumBy.id("com.nextbillion.groww:id/btn_show_more"))){
                waitForElement(AppiumBy.id("com.nextbillion.groww:id/btn_show_more"),10).click();
                waitSeconds(2);
                waitForElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.nextbillion.groww:id/btn_text\" and @text=\"Show less\"]"),10).click();
                scrollToEnd();
            }
            waitForElement(AppiumBy.id("com.nextbillion.groww:id/cl_search_container"),10).click();
            waitForElement(AppiumBy.id("com.nextbillion.groww:id/mint_internal_freeform_input_advanced"),10).click();
            waitForElement(AppiumBy.className("android.widget.EditText"),10).sendKeys("Navi Nifty 50 Index Fund Direct   Growth");
            waitForElement(AppiumBy.id("com.nextbillion.groww:id/tv_scheme_name"),10).click();
            switchAmount();
            availableAmountToSwitch();
            enterAmount("115");
            waitForElement(AppiumBy.id("com.nextbillion.groww:id/btnProceed"),10).click();
        }
        else {
            System.out.println("Switch option is not available for this fund");
        }
        slideProceedButtonLeftToRight(AppiumBy.id("com.nextbillion.groww:id/btnProceed"));
        System.out.println("Successfully switch Order placed");
        waitSeconds(4);
        waitForElement(AppiumBy.id("com.nextbillion.groww:id/btnOrderDetails"),10).click();
        waitSeconds(2);
        clickBack();
        waitForElement(AppiumBy.id("com.nextbillion.groww:id/btnDone"),10).click();
    }

    public void investmentDetailsSTP() throws InterruptedException {
        if (isElementPresent(AppiumBy.id("com.nextbillion.groww:id/btnSTP"))){
            waitForElement(AppiumBy.id("com.nextbillion.groww:id/btnSTP"),10).click();
            waitSeconds(5);
//            if (isElementPresent(AppiumBy.id("com.nextbillion.groww:id/btn_show_more"))){
//                waitForElement(AppiumBy.id("com.nextbillion.groww:id/btn_show_more"),10).click();
//                waitSeconds(2);
//                waitForElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.nextbillion.groww:id/btn_text\" and @text=\"Show less\"]"),10).click();
//                scrollToEnd();
//            }
//            waitForElement(AppiumBy.id("com.nextbillion.groww:id/cl_search_container"),10).click();
//            waitForElement(AppiumBy.id("com.nextbillion.groww:id/mint_internal_freeform_input_advanced"),10).click();
//            waitForElement(AppiumBy.className("android.widget.EditText"),10).sendKeys("Navi Nifty 50 Index Fund Direct   Growth");
//            waitForElement(AppiumBy.id("com.nextbillion.groww:id/tv_scheme_name"),10).click();
//            waitForElement(AppiumBy.id("com.nextbillion.groww:id/viewAmount"),10).click();
//            enterAmount("100");
//            waitForElement(AppiumBy.id("com.nextbillion.groww:id/btnConfirm"),10).click();
//            waitForElement(AppiumBy.id("com.nextbillion.groww:id/btnProceed"),10).click();
//        }
//        else {
//            System.out.println("STP option is not available for this fund");
//        }
//        slideProceedButtonLeftToRight(AppiumBy.id("com.nextbillion.groww:id/btnProceed"));
//        System.out.println("Successfully STP Order placed");



    }}





























}
