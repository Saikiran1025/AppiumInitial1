package org.example;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Dashboard extends FirstTest {
    public Dashboard(AndroidDriver driver) {super(driver); }

    public void dashbord() throws InterruptedException
    {
//        waitSeconds(5);
//        clickMFTab();
////        Clicking on Dashboard Tab
//        clickByXpath("//android.widget.TextView[@resource-id=\"com.nextbillion.groww:id/textView\" and @text=\"Dashboard\"]");
////        verifying the Pending Payments Tab
////        Trying to make payment for Pending order
//        clickByXpath("(//android.widget.FrameLayout[@resource-id=\"com.nextbillion.groww:id/payNowBtn\"])[1]");
//        clickBack();
////        Collapse Pending Payments Tab
//        clickById("com.nextbillion.groww:id/upcomingSipPaymentTv");
////        verifying the Orders Tab
//        clickByXpath("//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.nextbillion.groww:id/mfOrdersInProgressRCV\"]/android.view.ViewGroup");
//        clickBack();
//        clickByXpath("//android.widget.TextView[@resource-id=\"com.nextbillion.groww:id/btn_text\" and @text=\"See more\"]");
//        clickById("com.nextbillion.groww:id/tvAllOrders");
//        scrollToEnd();
//        clickBack();
//        clickById("com.nextbillion.groww:id/btn_text");
////        verifying the Holdingds Tab
//        clickById("com.nextbillion.groww:id/portfolioAnalysisButton");
////        Verifying the overview tab
//        clickByXpath("//android.widget.TextView[@text=\"Overview\"]");
//        scrollDownOnce();
//        clickByXpath("//android.widget.RadioButton[@text=\"Sectors\"]");
//        clickByXpath("//android.widget.RadioButton[@text=\"Market cap\"]");
//        clickByXpath("//android.widget.RadioButton[@text=\"Companies\"]");
//        scrollDownOnce();
//        waitSeconds(3);
//        clickByXpath("(//androidx.appcompat.widget.LinearLayoutCompat[@resource-id=\"com.nextbillion.groww:id/list\"])[2]/android.view.ViewGroup[6]");
//        scrollDownOnce();
//        clickBack();
//        scrollUp();
//        Verifying the Tax and Capital gains tab
//        waitSeconds(3);
//        clickByXpath("//android.widget.TextView[@text=\"Tax & capital gains\"]");
//        waitSeconds(3);
//        scrollDownOnce();
//        clickById("com.nextbillion.groww:id/see_all");
//        waitSeconds(3);
//        clickById("com.nextbillion.groww:id/returnChangeTv");
//        clickById("com.nextbillion.groww:id/returnChangeTv");
//        clickById("com.nextbillion.groww:id/returnChangeTv");
//        clickBack();
//        waitSeconds(3);
////        clicking on 80cTax Report
//        clickById("com.nextbillion.groww:id/tax_report");
//        clickBack();
//        waitSeconds(3);
//        clickById("com.nextbillion.groww:id/ic_info_capital_gains");
//        clickBack();
//
//        scrollDownOnce();
//        waitSeconds(3);
//        clickByXpath("//android.widget.TextView[@resource-id=\"com.nextbillion.groww:id/heading\" and @text=\"Short term funds\"]");
//        clickByXpath("//android.widget.RadioButton[@text=\"Equity\"]");
//        scrollToEnd();
//        clickByXpath("//android.widget.RadioButton[@text=\"Debt\"]");
//        scrollToEnd();
//        clickByXpath("//android.widget.RadioButton[@text=\"Hybrid\"]");
//        scrollToEnd();
//        clickBack();
//        clickByXpath("//android.widget.TextView[@resource-id=\"com.nextbillion.groww:id/heading\" and @text=\"Long term funds\"]");
//        clickByXpath("//android.widget.RadioButton[@text=\"Equity\"]");
//        scrollToEnd();
//        clickByXpath("//android.widget.RadioButton[@text=\"Debt\"]");
//        scrollToEnd();
//        clickByXpath("//android.widget.RadioButton[@text=\"Hybrid\"]");
//        scrollToEnd();
//        clickBack();
//        clickBack();
//        verifying Sort Functionality
        clickByXpath("//android.widget.FrameLayout[@resource-id=\"com.nextbillion.groww:id/mf_investments_sort\"]/android.widget.LinearLayout");
        for (int i = 1; i<6;i++)
        {
            WebElement filter = driver.findElement(AppiumBy.xpath(
                    "//androidx.recyclerview.widget.RecyclerView[@resource-id='com.nextbillion.groww:id/listFilters']/android.view.ViewGroup["+i+"]"));
            filter.click();
            waitSeconds(5);
            clickByXpath("//android.widget.FrameLayout[@resource-id=\"com.nextbillion.groww:id/mf_investments_sort\"]/android.widget.LinearLayout");

        }
        clickBack();
        for(int i =1; i<5;i++)
        {
            clickById("com.nextbillion.groww:id/sort_title");
            waitSeconds(5);
        }














        System.out.println("Dasboard Completed");





    }

}
