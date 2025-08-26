package org.example.pages;

import com.sun.source.tree.AssertTree;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.example.utils.GrowwUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.testng.Assert;

import javax.swing.*;
import java.time.Duration;
import java.util.*;


public class ExploreTab extends GrowwUtils {
    public ExploreTab(AndroidDriver driver) {
        super(driver); //  Sets the inherited driver
    }

    public void clickReturns() throws InterruptedException {
        for (int i = 1; i < 3; i++) {
            waitForElement(AppiumBy.id("com.nextbillion.groww:id/btn_text"), 10).click();
            waitSeconds(2);
            scrollUpOnce();
            waitSeconds(2);
            scrollDownOnce();
        }
    }

    public void verifyTabNavigation(By locator, String expected, String failMessage) {
        String actual = waitForElement(locator, 10).getText();
        Assert.assertEquals(actual, expected, failMessage);
    }

    public void screener() {
        waitForElement(AppiumBy.id("com.nextbillion.groww:id/quickFilterContainer"), 10).click();
        waitForElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.nextbillion.groww:id/mtv_filter_type_heading\" and @text=\"Sort by\"]"), 10).click();
        waitForElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.nextbillion.groww:id/mtv_filter_type_heading\" and @text=\"3Y Returns\"]"), 10).click();
        waitForElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.nextbillion.groww:id/mtv_filter_type_heading\" and @text=\"Categories\"]"), 10).click();
        waitForElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.nextbillion.groww:id/mtv_filter_type_heading\" and @text=\"Equity\"]"), 10).click();
        waitForElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.nextbillion.groww:id/mtv_filter_type_heading\" and @text=\"Risk\"]"), 10).click();
        waitForElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.nextbillion.groww:id/mtv_filter_type_heading\" and @text=\"Very High\"]"), 10).click();
        waitForElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.nextbillion.groww:id/mtv_filter_type_heading\" and @text=\"Ratings\"]"), 10).click();
        waitForElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.nextbillion.groww:id/mtv_filter_type_heading\" and @text=\"1+\"]"), 10).click();
        waitForElement(AppiumBy.id("com.nextbillion.groww:id/btn_apply"), 10).click();
        clickBack();
    }

    public void searchBehaviourRegularKeyword() {
        waitForElement(AppiumBy.id("com.nextbillion.groww:id/searchIconV2"), 10).click();
        waitForElement(AppiumBy.id("com.nextbillion.groww:id/search_edit_text"), 10).click();
        waitForElement(AppiumBy.xpath("//android.widget.RadioButton[@text=\"MF\"]"), 10).click();
        waitForElement(AppiumBy.id("com.nextbillion.groww:id/search_edit_text"), 10).sendKeys("regular");
        if (isElementPresent(AppiumBy.id("com.nextbillion.groww:id/empty_container")))
            System.out.println("No Regular Scheme Fund found for Regular keyword");
        else {
            waitForElement(AppiumBy.xpath("(//android.view.ViewGroup[@resource-id=\"com.nextbillion.groww:id/search_item\"])[1]"), 10).click();
            WebElement schemeName = waitForElement(AppiumBy.id("com.nextbillion.groww:id/textMfTitle"), 10);
            String actualSchemeName = schemeName.getText();
            Assert.assertTrue(actualSchemeName.toLowerCase().contains("direct"), "Regular Scheme found for basic user");
        }
        clickBack();
        clickBack();
    }

    public void searchSchemename(String schemeName) throws InterruptedException {
        waitForElement(AppiumBy.id("com.nextbillion.groww:id/searchIconV2"), 10).click();
        waitForElement(AppiumBy.xpath("//android.widget.RadioButton[@text=\"MF\"]"), 10).click();
        waitForElement(AppiumBy.id("com.nextbillion.groww:id/search_edit_text"), 10).click();
        WebElement search = waitForElement(AppiumBy.id("com.nextbillion.groww:id/search_edit_text"), 10);
        search.sendKeys(schemeName);
        for (int i = 1; i <= 1; i++) {
            if (isElementPresent(AppiumBy.xpath("(//android.view.ViewGroup[@resource-id=\"com.nextbillion.groww:id/search_item\"])[1]"))) {
                waitSeconds(2);
                waitForElement(AppiumBy.xpath("(//android.view.ViewGroup[@resource-id=\"com.nextbillion.groww:id/search_item\"])[" + i + "]"), 10).click();
                String s = waitForElement(AppiumBy.id("com.nextbillion.groww:id/textMfTitle"), 10).getText();
                Assert.assertTrue(s.toLowerCase().contains("direct"), "pass");
                clickBack();
                clickBack();
            }
            else {
                System.out.println("No scheme found for searched keyword");
                waitSeconds(1);
                clickBack();
            }
        }
    }

    public void trendingSearches() throws InterruptedException {
        waitForElement(AppiumBy.id("com.nextbillion.groww:id/searchIconV2"), 10).click();
        waitForElement(AppiumBy.id("com.nextbillion.groww:id/search_edit_text"), 10).click();
        waitForElement(AppiumBy.xpath("//android.widget.RadioButton[@text=\"MF\"]"), 10).click();
        for (int i = 1; i <= 8; i++) {
            waitForElement(AppiumBy.xpath("(//android.view.ViewGroup[@resource-id=\"com.nextbillion.groww:id/item_grid_pill\"])[" + i + "]"), 10).click();
            WebElement schemeName = waitForElement(AppiumBy.id("com.nextbillion.groww:id/textMfTitle"), 10);
            String actualSchemeName = schemeName.getText();
            Assert.assertTrue(actualSchemeName.toLowerCase().contains("direct"), "Regular Scheme is found in basic");
            waitSeconds(1);
            clickBack();
        }
        clickBack();
        System.out.println("No Regular Scheme found for Trending Searches");
    }

    public void popularFunds() {
        WebElement parent = waitForElement(AppiumBy.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.nextbillion.groww:id/mainList\"]/android.widget.RelativeLayout/android.widget.GridView"), 10);
        if (isElementPresent(AppiumBy.xpath("//android.view.ViewGroup[@index=\"4\"]")))
            Assert.fail("More than 4 funds are showing in Popular Funds");
        for (int i = 0; i < 4; ++i) {
            parent.findElement(AppiumBy.xpath("//android.view.ViewGroup[@index="+i+"]\n")).click();
            String s = waitForElement(AppiumBy.id("com.nextbillion.groww:id/textMfTitle"), 10).getText();
            Assert.assertTrue(s.toLowerCase().contains("direct"), "Regular Scheme Found in Popular Funds");
            clickBack();
        }
        waitForElement(AppiumBy.id("com.nextbillion.groww:id/viewAllFundsTv"),10).click();
        screener();
    }

    public void verifyCollectionList() throws InterruptedException {
        List<String> fundNames = new ArrayList<>();
        for (int i=1;i<10;i++) {
            waitForElement(AppiumBy.xpath("(//android.widget.RelativeLayout[@resource-id=\"com.nextbillion.groww:id/productDescCard\"])["+i+"]"),10).click();
            String s = waitForElement(AppiumBy.id("com.nextbillion.groww:id/textMfTitle"), 10).getText();
            fundNames.add(s);
            Assert.assertTrue(s.toLowerCase().contains("direct"), "Regular Scheme Found in High Returns");
            clickBack();
        }
        if (isScrollable()) {
            scrollToEnd();
            waitSeconds(1);
            for (int i = 9; i < 10; i++) {
                waitForElement(AppiumBy.xpath("(//android.widget.RelativeLayout[@resource-id=\"com.nextbillion.groww:id/productDescCard\"])[" + i + "]"), 10).click();
                String s1 = waitForElement(AppiumBy.id("com.nextbillion.groww:id/textMfTitle"), 10).getText();
                fundNames.add(s1);
                Assert.assertTrue(s1.toLowerCase().contains("direct"), "Regular Scheme Found in High Returns");
                clickBack();
            }
        }
        System.out.println(fundNames.toArray().length);
        Set<String> uniqueFundNames = new HashSet<>(fundNames);
        if (uniqueFundNames.size()<fundNames.size())
            Assert.fail("Duplicate Scheme Names Found");
    }

    public void collections() throws InterruptedException {
        waitForElement(AppiumBy.accessibilityId("High return"), 10).click();
        verifyTabNavigation((AppiumBy.id("com.nextbillion.groww:id/tvTitle")), "High return", "High return Navigation failed");
        verifyCollectionList();
//        clickReturns();
        clickBack();
        waitForElement(AppiumBy.accessibilityId("Best SIP funds"), 10).click();
        verifyTabNavigation((AppiumBy.id("com.nextbillion.groww:id/tvTitle")), "Best SIP funds", "Best SIP funds Navigation failed");
        verifyCollectionList();
//        clickReturns();
        clickBack();
        waitForElement(AppiumBy.accessibilityId("Gold Funds"), 10).click();
        verifyTabNavigation((AppiumBy.id("com.nextbillion.groww:id/tvTitle")), "Gold Funds", "Gold Funds Navigation failed");
        verifyCollectionList();
//        clickReturns();
        clickBack();
        waitForElement(AppiumBy.accessibilityId("5 Star Funds"), 10).click();
        verifyTabNavigation((AppiumBy.id("com.nextbillion.groww:id/tvTitle")), "5 Star Funds", "5 Star Funds Navigation failed");
        verifyCollectionList();
//        clickReturns();
        clickBack();
        waitForElement(AppiumBy.accessibilityId("Large & Mid Cap"), 10).click();
        verifyTabNavigation((AppiumBy.id("com.nextbillion.groww:id/tvTitle")), "Large & Mid", "Large & Mid Navigation failed");
        verifyCollectionList();
//        clickReturns();
        clickBack();
        waitForElement(AppiumBy.accessibilityId("Small Cap"), 10).click();
        verifyTabNavigation((AppiumBy.id("com.nextbillion.groww:id/tvTitle")), "Small Cap", "Small Cap Navigation failed");
        verifyCollectionList();
//        clickReturns();
        clickBack();
    }

    public void recentlyViewed() {
        for (int i = 1; i <= 4; i++) {
            waitForElement(AppiumBy.xpath("(//android.widget.GridView[@resource-id=\"com.nextbillion.groww:id/collectionItems\"])[2]/android.widget.LinearLayout[" + i + "]"), 10).click();
            clickBack();
        }
    }

    public void fundsByGroww() throws InterruptedException {
        waitForElement(AppiumBy.id("com.nextbillion.groww:id/viewAllFundsTv"), 10).click();
        verifyTabNavigation((AppiumBy.id("com.nextbillion.groww:id/tv_amc_title")), "Funds By Groww", "Funds By Groww navigation failed");
        if (isElementPresent(AppiumBy.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.nextbillion.groww:id/rv_special_funds\"]/android.view.ViewGroup"))) {
            waitForElement(AppiumBy.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.nextbillion.groww:id/rv_special_funds\"]/android.view.ViewGroup"), 10).click();
            waitForElement(AppiumBy.accessibilityId("Fund House & investment objective"), 10).click();
            scrollUpOnce();
            waitSeconds(2);
            waitForElement(AppiumBy.accessibilityId("Fund management"), 10).click();
            scrollUpOnce();
            waitSeconds(2);
            waitForElement(AppiumBy.accessibilityId("Minimum investment amounts"), 10).click();
            scrollUpOnce();
            waitSeconds(2);
            waitForElement(AppiumBy.accessibilityId("Exit load & tax implications"), 10).click();
            scrollUpOnce();
            clickBack();
            waitForElement(AppiumBy.xpath("//android.widget.RadioButton[@text=\"Popular\"]"), 10).click();
            scrollUpOnce();
            waitSeconds(1);
            scrollDownOnce();
            waitSeconds(1);
            waitForElement(AppiumBy.xpath("//android.widget.RadioButton[@text=\"Equity\"]"), 10).click();
            scrollUpOnce();
            waitSeconds(1);
            scrollDownOnce();
            waitSeconds(1);
            waitForElement(AppiumBy.xpath("//android.widget.RadioButton[@text=\"Debt & Hybrid\"]"), 10).click();
            scrollUpOnce();
            waitSeconds(1);
            scrollDownOnce();
            waitSeconds(1);
            clickBack();
        }
        else {
            waitForElement(AppiumBy.xpath("//android.widget.RadioButton[@text=\"Popular\"]"), 10).click();
            scrollUpOnce();
            waitSeconds(1);
            scrollDownOnce();
            waitSeconds(1);
            waitForElement(AppiumBy.xpath("//android.widget.RadioButton[@text=\"Equity\"]"), 10).click();
            scrollUpOnce();
            waitSeconds(1);
            scrollDownOnce();
            waitSeconds(1);
            waitForElement(AppiumBy.xpath("//android.widget.RadioButton[@text=\"Debt & Hybrid\"]"), 10).click();
            scrollUpOnce();
            System.out.println("1");
            waitSeconds(1);
            scrollDownOnce();
            waitSeconds(1);
            clickBack();
        }
    }

    public void productAndTools() throws InterruptedException {
//        waitForElement(AppiumBy.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.nextbillion.groww:id/mainList\"]/android.widget.LinearLayout/android.widget.GridView/android.view.ViewGroup[1]"),10).click();
//        waitSeconds(3);
//        clickBack();
        waitForElement(AppiumBy.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.nextbillion.groww:id/mainList\"]/android.widget.LinearLayout/android.widget.GridView/android.view.ViewGroup[2]"), 10).click();
        verifyTabNavigation((AppiumBy.id("com.nextbillion.groww:id/mint_internal_appbar_titlebar_title")), "NFO - New Fund Offerings", "NFOs Navigation failed");
        waitForElement(AppiumBy.id("com.nextbillion.groww:id/nfo_intro"), 10).click();
        waitSeconds(3);
        scrollToEnd();
        clickBack();
        clickBack();
        waitForElement(AppiumBy.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.nextbillion.groww:id/mainList\"]/android.widget.LinearLayout/android.widget.GridView/android.view.ViewGroup[3]"), 10).click();
        verifyTabNavigation((AppiumBy.xpath("//android.widget.TextView[@text=\"SIP Calculator\"]")), "SIP Calculator", "SIP Calculator Navigation failed");
        waitForElement(AppiumBy.xpath("//android.widget.TextView[@text=\"SIP\"]"), 10).click();
        scrollUpOnce();
        scrollDownOnce();
        waitForElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Lumpsum\"]"), 10).click();
        scrollUpOnce();
        clickBack();
        waitForElement(AppiumBy.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.nextbillion.groww:id/mainList\"]/android.widget.LinearLayout/android.widget.GridView/android.view.ViewGroup[4]"), 10).click();
        verifyTabNavigation((AppiumBy.xpath("//android.widget.TextView[@text=\"Compare Funds\"]")), "Compare Funds", "Compare funds navigation failed");
        waitForElement(AppiumBy.xpath("//android.webkit.WebView[@text=\"Compare\"]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[1]"), 10).click();
        waitForElement(AppiumBy.xpath("//android.widget.EditText"), 10).sendKeys("axis");
        waitForElement(AppiumBy.xpath("//android.widget.ListView/android.view.View[1]"), 10).click();
        waitForElement(AppiumBy.xpath("//android.webkit.WebView[@text=\"Compare Axis Small Cap Fund Direct Growth\"]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[2]"), 10).click();
        waitForElement(AppiumBy.xpath("//android.widget.EditText"), 10).sendKeys("moti");
        waitForElement(AppiumBy.xpath("//android.widget.ListView/android.view.View[1]"), 10).click();
        waitForElement(AppiumBy.xpath("//android.widget.TextView[@text=\"1Y\"]"), 10).click();
        waitSeconds(2);
        waitForElement(AppiumBy.xpath("//android.widget.TextView[@text=\"3Y\"]"), 10).click();
        waitSeconds(2);
        waitForElement(AppiumBy.xpath("//android.widget.TextView[@text=\"5Y\"]"), 10).click();
        waitSeconds(2);
        scrollUpOnce();
        waitForElement(AppiumBy.xpath("//android.widget.TextView[@text=\"FUND DETAILS\"]"), 10).click();
        scrollUpOnce();
        waitSeconds(2);
        waitForElement(AppiumBy.xpath("//android.widget.TextView[@text=\"RETURNS\"]"), 10).click();
        scrollUpOnce();
        waitForElement(AppiumBy.xpath("//android.widget.TextView[@text=\"PROS & CONS\"]"), 10).click();
        scrollUpOnce();
        waitForElement(AppiumBy.xpath("//android.widget.TextView[@text=\"TOP 5 HOLDINGS\"]"), 10).click();
        scrollUpOnce();
        waitForElement(AppiumBy.xpath("//android.widget.TextView[@text=\"FUND MANAGERS\"]"), 10).click();
        scrollUpOnce();
        waitForElement(AppiumBy.xpath("//android.widget.TextView[@text=\"ABOUT FUND\"]"), 10).click();
        scrollUpOnce();
        waitForElement(AppiumBy.xpath("//android.widget.TextView[@text=\"POPULAR COMPARISONS\"]"), 10).click();
        scrollUpOnce();
        clickBack();
    }

    public void addCart() throws InterruptedException {
        waitForElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"Motilal Oswal Midcap Fund Direct Growth\"]"), 10).click();
        waitForElement(AppiumBy.id("com.nextbillion.groww:id/buttonOneTime"), 10).click();
        waitSeconds(1);
        enterAmount("1000");
        waitForElement(AppiumBy.id("com.nextbillion.groww:id/btn_add_to_cart"), 10).click();
        clickBack();
        clickBack();
    }

    public void removeCart() throws InterruptedException {
        if (isElementPresent(AppiumBy.xpath("//android.view.ViewGroup[@resource-id=\"com.nextbillion.groww:id/cartSection\"]/android.widget.RelativeLayout"))) {
            waitForElement(AppiumBy.xpath("//android.view.ViewGroup[@resource-id=\"com.nextbillion.groww:id/cartSection\"]/android.widget.RelativeLayout"), 10).click();
            waitSeconds(2);
            while (isElementPresent(AppiumBy.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.nextbillion.groww:id/rv_cart_items\"]/android.view.ViewGroup[1]"))) {
                if (isElementPresent(AppiumBy.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.nextbillion.groww:id/rv_cart_items\"]/android.view.ViewGroup[1]"))) {
                    waitForElement(AppiumBy.xpath("(//android.widget.FrameLayout[@resource-id=\"com.nextbillion.groww:id/btn_remove_from_cart\"])[1]"), 10).click();
                    waitSeconds(2);
                } else if (isElementPresent(AppiumBy.xpath("//android.widget.TextView[@text=\"Your cart is empty\"]")))
                    break;
            }
            clickBack();
        }
    }

    public void allMutualFunds() {
        waitForElement(AppiumBy.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.nextbillion.groww:id/mainList\"]/android.view.ViewGroup[1]/android.view.ViewGroup"), 10).click();
        verifyTabNavigation((AppiumBy.id("com.nextbillion.groww:id/mint_internal_appbar_titlebar_title")), "All Mutual Funds", "Screener havent opened");
        screener();
    }


    public void collectionsData() {
        ArrayList<String> allSchemes = new ArrayList<String>();
        List<WebElement> firstBatch = driver.findElements(AppiumBy.id("com.nextbillion.groww:id/productDescCard"));
        for (WebElement card : firstBatch) {
            WebElement schemeNameElement = card.findElement(AppiumBy.id("com.nextbillion.groww:id/schemeNameTv"));
            String schemeName = schemeNameElement.getText();
            if (!allSchemes.contains(schemeName)) {
                allSchemes.add(schemeName);
//                System.out.println(schemeName);
            }
        }
        scrollToEnd();
        String lastItem = allSchemes.get(allSchemes.size() - 1);
        ArrayList<String> secondList = new ArrayList<>();
        List<WebElement> secondBatch = driver.findElements(AppiumBy.id("com.nextbillion.groww:id/productDescCard"));
        for (WebElement card : secondBatch) {
            try {
                WebElement schemeNameElement = card.findElement(AppiumBy.id("com.nextbillion.groww:id/schemeNameTv"));
                String schemeName = schemeNameElement.getText();
                if (secondList.contains(schemeName)) {
                    System.out.println("New from second batch: " + schemeName);
                } else {
                    secondList.add(schemeName);
//                    allSchemes.add(schemeName);
                    System.out.println("New from second batch: " + schemeName);
//                    System.out.println(schemeName);
                }
            } catch (Exception e) {
//                e.printStackTrace();
            }
        }
        int startIndex = secondList.indexOf(lastItem);
        List<String> finalSecondList = secondList.subList(startIndex + 1, secondList.size());
        System.out.println(allSchemes);
        System.out.println(finalSecondList);
    }
}

