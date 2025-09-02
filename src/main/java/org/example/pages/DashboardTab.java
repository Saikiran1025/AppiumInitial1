package org.example.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.example.utils.GrowwUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;


public class DashboardTab extends GrowwUtils {

    public DashboardTab(AndroidDriver driver) {
        super(driver);
    }

    public void sortTitle() throws InterruptedException {
        By btnText = AppiumBy.id("com.nextbillion.groww:id/btn_sort_title");
        if (isElementPresent(btnText)) {
            for (int i = 0; i < 5; i++) {
                waitSeconds(2);
                scrollToEnd();
                waitSeconds(2);
                scrollUp();
                waitSeconds(2);
                waitForElement(btnText, 10).click();
            }
        }
    }

    public void navigatieToDashboard(){
        waitForElement(AppiumBy.accessibilityId("Mutual Funds"),10);
        waitForElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.nextbillion.groww:id/textView\" and @text=\"Dashboard\"]"),10).click();
    }


    public void pendingPayments()  {
        By pendingPaymentsTab = AppiumBy.id("com.nextbillion.groww:id/upcomingSipPaymentTv");
        By payNow = AppiumBy.xpath("(//android.widget.FrameLayout[@resource-id=\"com.nextbillion.groww:id/payNowBtn\"])[1]");
        if (isElementPresent(pendingPaymentsTab)) {
            if (isElementPresent(payNow)){
                waitForElement(AppiumBy.xpath("(//android.widget.FrameLayout[@resource-id=\"com.nextbillion.groww:id/payNowBtn\"])[1]"),10).click();
                clickBack();
            }
            else if (!isElementPresent(payNow)) {
                waitForElement(pendingPaymentsTab,10).click();
                waitForElement(AppiumBy.xpath("(//android.widget.FrameLayout[@resource-id=\"com.nextbillion.groww:id/payNowBtn\"])[1]"),10).click();
                clickBack();
            }
            waitForElement(pendingPaymentsTab,10).click();
        }
        else {
            System.out.println("Pending Payments Tab is not present");
        }
    }

    public void orders() {
        By ordersTab = AppiumBy.id("com.nextbillion.groww:id/orders_in_progress_text");
        By seeMore = AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.nextbillion.groww:id/btn_text\" and @text=\"See more\"]");
        By seeLess = AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.nextbillion.groww:id/btn_text\" and @text=\"See less\"]");
        By allorders = AppiumBy.id("com.nextbillion.groww:id/tvAllOrders");
        By firstOrder = AppiumBy.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.nextbillion.groww:id/mfOrdersInProgressRCV\"]/android.view.ViewGroup[1]");
        if (isElementPresent(ordersTab)){
                if (isElementPresent(firstOrder)){
                    waitForElement(firstOrder,10).click();
                    clickBack();
                    if (isElementPresent(seeMore)){
                        waitForElement(seeMore,10).click();
                        scrollToText("See less");
                        waitForElement(allorders,10).click();
                        clickBack();
                        waitForElement(ordersTab,10).click();
                    }
                    else if (isElementPresent(allorders)) {
                        waitForElement(allorders,10).click();
                        clickBack();
                    }
                    else {
                        scrollToText("See less");
                        waitForElement(allorders,10).click();
                        clickBack();
                        waitForElement(ordersTab,10).click();
                    }
                }
                else {
                    waitForElement(ordersTab,10).click();
                    waitForElement(firstOrder,10).click();
                    clickBack();
                    if (isElementPresent(seeMore)){
                        waitForElement(seeMore,10).click();
                        scrollToText("See less");
                        waitForElement(allorders,10).click();
                        clickBack();
                        waitForElement(ordersTab,10).click();
                    }
                    else if (isElementPresent(allorders))
                    {
                        waitForElement(allorders,10).click();
                        clickBack();
                    }
                    else {
                        scrollToText("See less");
                        waitForElement(allorders,10).click();
                        clickBack();
                        waitForElement(ordersTab,10).click();
                    }
                }
        }
        else
            System.out.println("No Order is in Progress");
    }

    public void investments() {
        WebElement currentAmount = waitForElement(AppiumBy.id("com.nextbillion.groww:id/currentAmt"),10);
        String ca = currentAmount.getText();
        String removeChar = ca.replaceAll("[₹,]","");
        int currentAmountValue = Integer.parseInt(removeChar);
        System.out.println("Current Value : "+currentAmountValue);

        WebElement investedAmount = waitForElement(AppiumBy.id("com.nextbillion.groww:id/investedAmt"),10);
        String ia = investedAmount.getText();
        String removeChar1 = ia.replaceAll("[₹,]","");
        int investedAmountValue = Integer.parseInt(removeChar1);
        System.out.println("Invested Value : "+investedAmountValue);

    }

    public void hideUnhide() throws InterruptedException {
        waitForElement(AppiumBy.id("com.nextbillion.groww:id/hide_button"),10).click();
        waitSeconds(2);
        waitForElement(AppiumBy.id("com.nextbillion.groww:id/hide_button"),10).click();

    }

    public void portfolioAnalysis() throws InterruptedException {
        waitForElement(AppiumBy.id("com.nextbillion.groww:id/portfolioAnalysisButton"),10).click();
        String[] duration = {"1M","6M","1Y","3Y","5Y","ALL"};
        for (String s:duration) {
            if (isElementPresent(AppiumBy.xpath("//android.widget.LinearLayout[@content-desc=\""+s+"\"]"))) {
                waitForElement(AppiumBy.xpath("//android.widget.LinearLayout[@content-desc=\"" + s + "\"]"), 10).click();
                waitSeconds(3);
            }
        }
        System.out.println("Graph Verification Done");
        waitForElement(AppiumBy.xpath("//android.widget.LinearLayout[@content-desc=\"Overview\"]"),10).click();
        scrollHalfPageUp();
        String[] category = {"Equity","Debt","Hybrid","Others"};
        for (String s:category) {
            if (isElementPresent(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.nextbillion.groww:id/heading\" and @text=\""+s+"\"]"))) {
                waitForElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.nextbillion.groww:id/heading\" and @text=\""+s+"\"]"), 10).click();
                waitSeconds(2);
                clickBack();
            }
        }
        System.out.println("Category Distribution Verified in Overiew");
        scrollToEnd();

        waitForElement(AppiumBy.xpath("//android.widget.RadioButton[@text=\"Sectors\"]"),10).click();
        waitSeconds(2);
        waitForElement(AppiumBy.xpath("//android.widget.RadioButton[@text=\"Market cap\"]"),10).click();
        waitSeconds(2);
        waitForElement(AppiumBy.xpath("//android.widget.RadioButton[@text=\"Companies\"]"),10).click();
        waitSeconds(2);
        System.out.println("Equity asset allocation Verified in Overiew");
        scrollDownOnce();
        scrollToTop();
        System.out.println("Overview Verification Done");

        waitForElement(AppiumBy.xpath("//android.widget.LinearLayout[@content-desc=\"Tax & capital gains\"]"),10).click();
        waitSeconds(2);
        scrollHalfPageUp();
        if (isElementPresent(AppiumBy.id("com.nextbillion.groww:id/see_all"))){
            waitForElement(AppiumBy.id("com.nextbillion.groww:id/see_all"),10).click();
            System.out.println("Popular ELSS funds Present");
            waitSeconds(2);
            clickBack();
        }


        waitForElement(AppiumBy.id("com.nextbillion.groww:id/tax_report"),10).click();
        waitSeconds(2);
        clickBack();
        waitForElement(AppiumBy.id("com.nextbillion.groww:id/ic_info_capital_gains"),10).click();
        waitSeconds(2);
        clickBack();
        scrollHalfPageUp();
        waitForElement(AppiumBy.id("com.nextbillion.groww:id/gains_report"),10).click();
        waitSeconds(2);
        clickBack();
        scrollToEnd();
        waitSeconds(2);
        waitForElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.nextbillion.groww:id/heading\" and @text=\"Short term funds\"]"),10).click();
        waitForElement(AppiumBy.xpath("//android.widget.RadioButton[@text=\"Equity\"]"),10).click();
        waitSeconds(2);
        waitForElement(AppiumBy.xpath("//android.widget.RadioButton[@text=\"Debt\"]"),10).click();
        waitSeconds(2);
        waitForElement(AppiumBy.xpath("//android.widget.RadioButton[@text=\"Hybrid\"]"),10).click();
        waitSeconds(2);
        clickBack();
        waitForElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.nextbillion.groww:id/heading\" and @text=\"Long term funds\"]"),10).click();
        waitForElement(AppiumBy.xpath("//android.widget.RadioButton[@text=\"Equity\"]"),10).click();
        waitSeconds(2);
        waitForElement(AppiumBy.xpath("//android.widget.RadioButton[@text=\"Debt\"]"),10).click();
        waitSeconds(2);
        waitForElement(AppiumBy.xpath("//android.widget.RadioButton[@text=\"Hybrid\"]"),10).click();
        waitSeconds(2);
        clickBack();
        clickBack();
        System.out.println("Portfolio Analysis Verfied");
    }

    public void dashboardXirr() {
        waitForElement(AppiumBy.id("com.nextbillion.groww:id/view_xirr_click_area"),10).click();
        waitForElement(AppiumBy.id("com.nextbillion.groww:id/view_lifetime_xirr_clickable_area"),10).click();
        waitForElement(AppiumBy.id("com.nextbillion.groww:id/view_xirr_click_area"),10).click();
        waitForElement(AppiumBy.id("com.nextbillion.groww:id/view_active_xirr_clickable_area"),10).click();

    }

    public void sort(){
        waitForElement(AppiumBy.id("com.nextbillion.groww:id/mf_investments_sort"),10).click();
        waitForElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.nextbillion.groww:id/filterText\" and @text=\"Current Value\"]"),10).click();
        String erCurrent = waitForElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.nextbillion.groww:id/btn_text\" and @text=\"Current (Invested)\"]"),10).getText();
        Assert.assertTrue(erCurrent.contains("Current (Invested)"),"Current Filter fail in Sort");

        waitForElement(AppiumBy.id("com.nextbillion.groww:id/mf_investments_sort"),10).click();
        waitForElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.nextbillion.groww:id/filterText\" and @text=\"Returns %\"]"),10).click();
        String erReturns = waitForElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.nextbillion.groww:id/btn_text\" and @text=\"Returns (%)\"]"),10).getText();
        Assert.assertTrue(erReturns.contains("Returns (%)"),"Returns Filter fail in Sort");


        waitForElement(AppiumBy.id("com.nextbillion.groww:id/mf_investments_sort"),10).click();
        waitForElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.nextbillion.groww:id/filterText\" and @text=\"Day Change %\"]"),10).click();
        String erDayChange = waitForElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.nextbillion.groww:id/btn_text\" and @text=\"Day Change (%)\"]"),10).getText();
        Assert.assertTrue(erDayChange.contains("Day Change (%)"),"Day Change Filter fail in Sort");

        waitForElement(AppiumBy.id("com.nextbillion.groww:id/mf_investments_sort"),10).click();
        waitForElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.nextbillion.groww:id/filterText\" and @text=\"XIRR %\"]"),10).click();
        String erXIRR = waitForElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.nextbillion.groww:id/btn_text\" and @text=\"XIRR\"]"),10).getText();
        Assert.assertTrue(erXIRR.contains("XIRR"),"XIRR Filter fail in Sort");

        waitForElement(AppiumBy.id("com.nextbillion.groww:id/mf_investments_sort"),10).click();
        waitForElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.nextbillion.groww:id/filterText\" and @text=\"Alphabetical\"]"),10).click();

    }

    public void dashboardSchemeValidation() throws InterruptedException {
        By parent = AppiumBy.xpath("(//android.widget.LinearLayout[@resource-id=\"com.nextbillion.groww:id/item_container\"])[1]/android.view.ViewGroup");
        WebElement parentElement = waitForElement(parent,10);
        WebElement child = parentElement.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.nextbillion.groww:id/scheme_name\" and @index=\"0\"]"));
        String s = child.getText();
        waitForElement(parent,10).click();
        String s1 = waitForElement(AppiumBy.id("com.nextbillion.groww:id/fund_name_"),10).getText();
        waitForElement(AppiumBy.id("com.nextbillion.groww:id/fund_name_"),10).click();
        String s2 = waitForElement(AppiumBy.id("com.nextbillion.groww:id/textMfTitle"),10).getText();
        waitSeconds(1);
        Assert.assertEquals(s,s1,"Pop-up viewed is Incorrect");
        Assert.assertEquals(s1,s2,"Product Page viewed is Incorrect");
        clickBack();
    }

    public void dashboardRedeem() throws InterruptedException {
        waitForElement(AppiumBy.xpath("(//android.widget.LinearLayout[@resource-id=\"com.nextbillion.groww:id/item_container\"])[1]/android.view.ViewGroup"),10).click();
        By redeem = AppiumBy.id("com.nextbillion.groww:id/rlRedeemCta");
        if (isClickable(redeem, 10)) {
            waitForElement(redeem, 10).click();
            redeemFolioSelection();
        }
        else {
            System.out.println("Redeem not Allowed");
        }
        clickBack();
        clickBack();
    }

    public void dashboardInvestmentDetails(){
        waitForElement(AppiumBy.xpath("(//android.widget.LinearLayout[@resource-id=\"com.nextbillion.groww:id/item_container\"])[1]/android.view.ViewGroup"),10).click();
        waitForElement(AppiumBy.id("com.nextbillion.groww:id/see_more_cta"),10).click();
        clickBack();
    }

    public void dashboardPurchase(){
        waitForElement(AppiumBy.xpath("(//android.widget.LinearLayout[@resource-id=\"com.nextbillion.groww:id/item_container\"])[1]/android.view.ViewGroup"),10).click();
        if(isElementPresent(AppiumBy.id("com.nextbillion.groww:id/isExternal")) || isElementPresent(AppiumBy.id("com.nextbillion.groww:id/isRegular"))){
            System.out.println("Scheme is not Available for Purchase");
        }
        else {
            waitForElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.nextbillion.groww:id/btn_text\" and @text=\"One Time\"]"),10).click();
            clickBack();
            waitForElement(AppiumBy.xpath("(//android.widget.LinearLayout[@resource-id=\"com.nextbillion.groww:id/item_container\"])[1]/android.view.ViewGroup"),10).click();
            waitForElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.nextbillion.groww:id/btn_text\" and @text=\"Start SIP\"]"),10).click();
            clickBack();
        }
    }



}




















//
//    public void dashbord() throws InterruptedException
//    {
//
////        Clicking on MF tab
//        clickMFTab();
//
//        Clicking on Dashboard Tab
//        waitForElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.nextbillion.groww:id/textView\" and @text=\"Dashboard\"]"), 10).click();
//
//        Dismiss Message Box if shown
//        By messageBox = AppiumBy.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.nextbillion.groww:id/mfDashboardRCV\"]/android.view.ViewGroup[1]/android.view.ViewGroup");
//        if (isElementPresent(messageBox))
//        {
//            waitForElement(AppiumBy.id("com.nextbillion.groww:id/btn_close"), 10).click();
//        }
//
//
//
//
//        verifying the Orders Tab
//        By seeMore = AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.nextbillion.groww:id/btn_text\" and @text=\"See more\"]");
//        By allorders = AppiumBy.id("com.nextbillion.groww:id/tvAllOrders");
//        By orders = AppiumBy.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.nextbillion.groww:id/mfOrdersInProgressRCV\"]/android.view.ViewGroup[1]");
//        By oneOrder = AppiumBy.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.nextbillion.groww:id/mfOrdersInProgressRCV\"]/android.view.ViewGroup");
////        By oneOrderTab = AppiumBy.androidUIAutomator("new UiSelector().textStartsWith(\"Orders(1)\")");
////        By mulOrderTab = AppiumBy.androidUIAutomator("new UiSelector().textStartsWith(\"Orders\")");
////        if (isElementPresent(oneOrderTab))
////        {
////            if (isElementPresent(oneOrder))
////            {
////                waitForElement(oneOrder,10).click();
////                clickBack();
////                waitForElement(allorders,10).click();
////                clickBack();
////                waitForElement(oneOrderTab,10).click();
////            }
////            else
////            {
////                waitForElement(oneOrderTab,10).click();
////                waitForElement(oneOrder,10).click();
////                clickBack();
////                waitForElement(allorders,10).click();
////                clickBack();
////                waitForElement(oneOrderTab,10).click();
////            }
////        }
////
////        if(isElementPresent(mulOrderTab))
////        {
////            if (isElementPresent(orders))
////            {
////                waitForElement(orders, 10).click();
////                clickBack();
////                if (isElementPresent(seeMore))
////                {
////                    waitForElement(seeMore,10).click();
////                    if (isElementPresent(allorders))
////                    {
////                        waitForElement(allorders,10).click();
////                        clickBack();
////                    }
////                    else
////                    {
////                        scrollDownOnce();
////                        waitForElement(allorders,10).click();
////                        clickBack();
////                        scrollUpOnce();
////                        waitForElement(mulOrderTab,10).click();
////                    }
////                }
////                else
////                {
////                    if(isElementPresent(allorders))
////                    {
////                        waitForElement(allorders,10).click();
////                        clickBack();
////                    }
////                    else
////                    {
////                        scrollDownOnce();
////                        waitForElement(allorders, 10).click();
////                        clickBack();
////                        scrollUpOnce();
////                        waitSeconds(3);
////                        waitForElement(mulOrderTab, 10).click();
////                    }
////                }
////            }
////            else
////            {
////                waitForElement(mulOrderTab, 10).click();
////                waitForElement(orders, 10).click();
////                clickBack();
////                if (isElementPresent(seeMore))
////                {
////                    waitForElement(seeMore,10).click();
////                    if (isElementPresent(allorders))
////                    {
////                        waitForElement(allorders,10).click();
////                        clickBack();
////                    }
////                    else
////                    {
////                        scrollDownOnce();
////                        waitForElement(allorders,10).click();
////                        clickBack();
////                        scrollUpOnce();
////                        waitForElement(mulOrderTab,10).click();
////                    }
////                }
////                else
////                {
////                    scrollDownOnce();
////                    waitForElement(allorders,10).click();
////                    clickBack();
////                    scrollUpOnce();
////                    waitForElement(mulOrderTab,10).click();
////                }
////            }
////        }
////        else
////        {
////            System.out.println("No Pending Orders");
////        }
////
//////        verifying the Holdingds Tab
////        if (isElementPresent(AppiumBy.id("com.nextbillion.groww:id/lottie")))
////        {
////            waitForElement(AppiumBy.id("com.nextbillion.groww:id/lottie"),10).click();
////        }
////        else
////        {
////            waitForElement(AppiumBy.id("com.nextbillion.groww:id/portfolioAnalysisButton"),10).click();
////        }
////
//////        verifying the Graph of Holdingds Tab
//        By oneMonth = AppiumBy.xpath("//android.widget.LinearLayout[@content-desc=\"1M\"]");
//        By sixMonths = AppiumBy.xpath("//android.widget.LinearLayout[@content-desc=\"6M\"]");
//        By oneYear = AppiumBy.xpath("//android.widget.LinearLayout[@content-desc=\"1Y\"]");
//        By all = AppiumBy.xpath("//android.widget.LinearLayout[@content-desc=\"ALL\"]");
////        if (isElementPresent(oneMonth))
////            waitForElement(oneMonth,10).click();
////        waitSeconds(1);
////        if (isElementPresent(sixMonths))
////            waitForElement(sixMonths,10).click();
////        waitSeconds(1);
////        if (isElementPresent(oneYear))
////            waitForElement(oneYear,10).click();
////        waitSeconds(1);
////        if (isElementPresent(all))
////            waitForElement(all,10).click();
////        waitSeconds(1);
////
//////        Verifying the overview tab
//        waitForElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Overview\"]"),10).click();
//
//        Verifying the Category distribution
//        waitForElement(AppiumBy.xpath("//androidx.appcompat.widget.LinearLayoutCompat[@resource-id=\"com.nextbillion.groww:id/list\"]/android.view.ViewGroup[1]"),10).click();
//        sortTitle();
//        waitForElement(AppiumBy.xpath("//android.widget.RadioButton[@text=\"Debt\"]"),10).click();
//        sortTitle();
//        waitForElement(AppiumBy.xpath("//android.widget.RadioButton[@text=\"Hybrid\"]"),10).click();
//        sortTitle();
//        waitForElement(AppiumBy.xpath("//android.widget.RadioButton[@text=\"Others\"]"),10).click();
//        sortTitle();
//        clickBack();
//        scrollDownOnce();
//
//        Verifying the Equity asset allocation
//        waitForElement(AppiumBy.xpath("//android.widget.RadioButton[@text=\"Sectors\"]"),10).click();
//        waitForElement(AppiumBy.xpath("(//androidx.appcompat.widget.LinearLayoutCompat[@resource-id=\"com.nextbillion.groww:id/list\"])[2]/android.view.ViewGroup[6]"),10).click();
//        waitSeconds(3);
//        scrollToEnd();
//        clickBack();
//        waitForElement(AppiumBy.xpath("//android.widget.RadioButton[@text=\"Market cap\"]"),10).click();
//        waitSeconds(3);
//        waitForElement(AppiumBy.xpath("//android.widget.RadioButton[@text=\"Companies\"]"),10).click();
//        waitSeconds(3);
//        waitForElement(AppiumBy.xpath("(//androidx.appcompat.widget.LinearLayoutCompat[@resource-id=\"com.nextbillion.groww:id/list\"])[2]/android.view.ViewGroup[6]"),10).click();
////        waitSeconds(3);
////        scrollToEnd();
////        clickBack();
////        scrollUp();
////
//////        Verifying the Tax and Capital gains tab
////            waitSeconds(3);
//            waitForElement(AppiumBy.xpath("//android.widget.LinearLayout[@content-desc=\"Tax & capital gains\"]"),10).click();
////
//////        Verifying the Popular ELSS funds
////            By seeAll = AppiumBy.id("com.nextbillion.groww:id/see_all");
////            if (isElementPresent(seeAll))
////            {
////                waitForElement(AppiumBy.id("com.nextbillion.groww:id/see_all"),10).click();
////                waitSeconds(3);
////                waitForElement(AppiumBy.id("com.nextbillion.groww:id/returnChangeTv"),10).click();
////                waitForElement(AppiumBy.id("com.nextbillion.groww:id/returnChangeTv"),10).click();
////                waitForElement(AppiumBy.id("com.nextbillion.groww:id/returnChangeTv"),10).click();
////                clickBack();
////                waitSeconds(3);
////                scrollDownOnce();
////            }
////            else
////            {
////                scrollDownOnce();
////        }
////
////
////
////
//////        Verifying the Tax report - 80C ELSS proof
////        waitForElement(AppiumBy.id("com.nextbillion.groww:id/tax_report"),10).click();
////        waitSeconds(3);
////        clickBack();
////        waitSeconds(3);
////
//////        Verifying the Capital Gains
////        clickById("com.nextbillion.groww:id/ic_info_capital_gains");
////        waitSeconds(2);
////        clickBack();
////        scrollDownOnce();
////        waitSeconds(3);
////
//////        Verifying the Short term funds
//        clickByXpath("//android.widget.TextView[@resource-id=\"com.nextbillion.groww:id/heading\" and @text=\"Short term funds\"]");
//        waitForElement(AppiumBy.xpath("//android.widget.RadioButton[@text=\"Equity\"]"),10).click();
//        scrollToEnd();
//        waitForElement(AppiumBy.xpath("//android.widget.RadioButton[@text=\"Debt\"]"),10).click();
//        scrollToEnd();
//        waitForElement(AppiumBy.xpath("//android.widget.RadioButton[@text=\"Hybrid\"]"),10).click();
//        scrollToEnd();
//        clickBack();
//
////        Verifying the Long term funds
//        waitForElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.nextbillion.groww:id/heading\" and @text=\"Long term funds\"]"),10).click();
//        waitForElement(AppiumBy.xpath("//android.widget.RadioButton[@text=\"Equity\"]"),10).click();
//        scrollToEnd();
//        waitForElement(AppiumBy.xpath("//android.widget.RadioButton[@text=\"Debt\"]"),10).click();
//        scrollToEnd();
//        waitForElement(AppiumBy.xpath("//android.widget.RadioButton[@text=\"Hybrid\"]"),10).click();
//        scrollToEnd();
////        clickBack();
////        clickBack();
//
//////        verifying Sort Functionality
////        By sort = AppiumBy.id("com.nextbillion.groww:id/mf_investments_sort");
////        waitForElement(sort,10).click();
////        for (int i = 1; i<6;i++)
////        {
//            WebElement filter = driver.findElement(AppiumBy.xpath("//android.widget.LinearLayout[@resource-id=\"com.nextbillion.groww:id/listFilters\"]/android.view.ViewGroup["+i+"]"));
////            filter.click();
////            waitSeconds(3);
////            waitForElement(sort,10).click();
////        }
////        clickBack();
////        for(int i =1; i<5;i++)
////        {
////            clickById("com.nextbillion.groww:id/sort_title");
////            waitSeconds(3);
////        }
//
////        Verifying Invested Scheme
////        Select any scheme
//        waitForElement(AppiumBy.xpath("(//android.widget.LinearLayout[@resource-id=\"com.nextbillion.groww:id/item_container\"])[1]/android.view.ViewGroup"), 10).click();
////        Verifying product page
//        waitForElement(AppiumBy.xpath("//android.view.ViewGroup[@resource-id=\"com.nextbillion.groww:id/actionTrayBs\"]/android.view.View[1]"), 10).click();
//        clickBack();
//        waitForElement(AppiumBy.xpath("(//android.widget.LinearLayout[@resource-id=\"com.nextbillion.groww:id/item_container\"])[1]/android.view.ViewGroup"), 10).click();
////        Verifying redeem functionality
//        waitForElement(AppiumBy.id("com.nextbillion.groww:id/rlRedeemCta"), 10).click();
////        Verifying using amount
//        waitForElement(AppiumBy.id("com.nextbillion.groww:id/tvAvailableAmtOrUnits"), 10).click();
//        waitForElement(AppiumBy.id("com.nextbillion.groww:id/btnOkay"), 10).click();
//        waitForElement(AppiumBy.id("com.nextbillion.groww:id/mint_internal_selectable_control_underlying_icon_view"), 10).click();
//        waitSeconds(2);
//        By exitAmount = AppiumBy.id("com.nextbillion.groww:id/containerMb");
//        if (isElementPresent(AppiumBy.id("com.nextbillion.groww:id/containerMb")))
//        {
//            waitForElement(AppiumBy.id("com.nextbillion.groww:id/containerMb"), 10).click();
//
//        }
//        waitForElement(AppiumBy.id("com.nextbillion.groww:id/btnOkay"), 10).click();
//        waitSeconds(2);
//        waitForElement(AppiumBy.id("com.nextbillion.groww:id/btnProceed"), 10).click();
////        clickByTextStart("Read more");
//        waitForElement(AppiumBy.id("com.nextbillion.groww:id/ivApplicableNavInfo"), 10).click();
//        waitForElement(AppiumBy.id("com.nextbillion.groww:id/btnOkay"), 10).click();
//        waitForElement(AppiumBy.id("com.nextbillion.groww:id/ivExitLoadInfo"), 10).click();
//        waitForElement(AppiumBy.id("com.nextbillion.groww:id/btnOkay"), 10).click();
//        waitForElement(AppiumBy.id("com.nextbillion.groww:id/ivCapitalTaxInfo"), 10).click();
//        waitForElement(AppiumBy.id("com.nextbillion.groww:id/btnOkay"), 10).click();
//        clickBack();
////        Verifying using units
//        waitForElement(AppiumBy.id("com.nextbillion.groww:id/btnSettings"), 10).click();
//        waitForElement(AppiumBy.id("com.nextbillion.groww:id/viewUnits"), 10).click();
//        waitForElement(AppiumBy.id("com.nextbillion.groww:id/btnConfirm"), 10).click();
//        waitSeconds(2);
//        By exitiunts = AppiumBy.id("com.nextbillion.groww:id/containerMb");
//        if (isElementPresent(AppiumBy.id("com.nextbillion.groww:id/containerMb")))
//        {
//            waitForElement(AppiumBy.id("com.nextbillion.groww:id/containerMb"), 10).click();
//
//        }
//        waitForElement(AppiumBy.id("com.nextbillion.groww:id/btnOkay"), 10).click();
//        waitForElement(AppiumBy.id("com.nextbillion.groww:id/btnProceed"), 10).click();
////        clickByTextStart("Read more");
//        waitForElement(AppiumBy.id("com.nextbillion.groww:id/ivApplicableNavInfo"), 10).click();
//        waitForElement(AppiumBy.id("com.nextbillion.groww:id/btnOkay"), 10).click();
//        waitForElement(AppiumBy.id("com.nextbillion.groww:id/ivExitLoadInfo"), 10).click();
//        waitForElement(AppiumBy.id("com.nextbillion.groww:id/btnOkay"), 10).click();
//        waitForElement(AppiumBy.id("com.nextbillion.groww:id/ivCapitalTaxInfo"), 10).click();
//        waitForElement(AppiumBy.id("com.nextbillion.groww:id/btnOkay"), 10).click();
//        clickBack();
//        clickBack();
////        Verifying Investment Details funcionality
//        waitForElement(AppiumBy.xpath("(//android.widget.LinearLayout[@resource-id=\"com.nextbillion.groww:id/item_container\"])[1]/android.view.ViewGroup"), 10).click();
//        waitForElement(AppiumBy.id("com.nextbillion.groww:id/tv_more_cta"), 10).click();
//        waitForElement(AppiumBy.id("com.nextbillion.groww:id/viewNavigateToProductPage"), 10).click();
//        waitSeconds(3);
//        clickBack();
////        Verifying Switch funcionality
//        waitForElement(AppiumBy.id("com.nextbillion.groww:id/viewSwitchEntryPoint"), 10).click();
//        clickBack();
////        scrollDownOnce();
////        Verifying Transaction history funcionality
//        waitForElement(AppiumBy.xpath("(//android.widget.ImageView[@resource-id=\"com.nextbillion.groww:id/icon_view\"])[2]"), 10).click();
//        clickBack();
//        scrollToEnd();
//
//        System.out.println("Dasboard Completed");
//
//    }
//
//}
