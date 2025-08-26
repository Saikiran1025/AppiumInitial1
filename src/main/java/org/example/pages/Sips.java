package org.example.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.example.utils.GrowwUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Sips extends GrowwUtils
{
    public Sips(AndroidDriver driver) {super(driver); }

    public void calenderDate(int i)
    {
        String xpath = "//android.widget.TextView[@resource-id=\"com.nextbillion.groww:id/sipDate\" and @text='" + i +"']";
        waitForElement(AppiumBy.xpath(xpath),10).click();
    }


    public void cancelSIP() throws InterruptedException {
        waitForElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.nextbillion.groww:id/textView\" and @text=\"SIPs\"]"),10).click();
//        WebElement cs = waitForElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.nextbillion.groww:id/btn_text\" and @text=\"Cancel SIP\"]"),10);
        for (int i=1;i<=1;i++) {
            waitForElement(AppiumBy.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.nextbillion.groww:id/rv_sips_v2\"]/android.view.ViewGroup[3]"), 10).click();
            WebElement cs = waitForElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.nextbillion.groww:id/btn_text\" and @text=\"Cancel SIP\"]"),10);
            if (cs.isEnabled())
            {
                waitForElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.nextbillion.groww:id/btn_text\" and @text=\"Cancel SIP\"]"), 10).click();
                if(isElementPresent(AppiumBy.id("com.nextbillion.groww:id/cta_primary")))
                {
                    waitForElement(AppiumBy.id("com.nextbillion.groww:id/cta_primary"), 10).click();
                    waitForElement(AppiumBy.xpath("(//android.view.ViewGroup[@resource-id=\"com.nextbillion.groww:id/layout_action_btns\"])[6]"), 10).click();
                    waitForElement(AppiumBy.id("com.nextbillion.groww:id/btn_primary_cta"), 10).click();
                    waitForElement(AppiumBy.id("com.nextbillion.groww:id/btnDone"), 10).click();
                }
                else
                {
                    waitForElement(AppiumBy.xpath("(//android.view.ViewGroup[@resource-id=\"com.nextbillion.groww:id/layout_action_btns\"])[6]"), 10).click();
                    waitForElement(AppiumBy.id("com.nextbillion.groww:id/btn_primary_cta"), 10).click();
                    waitForElement(AppiumBy.id("com.nextbillion.groww:id/btnDone"), 10).click();
                }
            }
            else {
                clickBack();
                waitForElement(AppiumBy.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.nextbillion.groww:id/rv_sips_v2\"]/android.view.ViewGroup[4]"), 10).click();
                WebElement cs1 = waitForElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.nextbillion.groww:id/btn_text\" and @text=\"Cancel SIP\"]"),10);
                waitSeconds(2);
                if (cs1.isEnabled())
                {
                    waitForElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.nextbillion.groww:id/btn_text\" and @text=\"Cancel SIP\"]"), 10).click();
                    if(isElementPresent(AppiumBy.id("com.nextbillion.groww:id/cta_primary")))
                    {
                        waitForElement(AppiumBy.id("com.nextbillion.groww:id/cta_primary"), 10).click();
                        waitForElement(AppiumBy.xpath("(//android.view.ViewGroup[@resource-id=\"com.nextbillion.groww:id/layout_action_btns\"])[6]"), 10).click();
                        waitForElement(AppiumBy.id("com.nextbillion.groww:id/btn_primary_cta"), 10).click();
                        waitForElement(AppiumBy.id("com.nextbillion.groww:id/btnDone"), 10).click();
                    }
                    else
                    {
                        waitForElement(AppiumBy.xpath("(//android.view.ViewGroup[@resource-id=\"com.nextbillion.groww:id/layout_action_btns\"])[6]"), 10).click();
                        waitForElement(AppiumBy.id("com.nextbillion.groww:id/btn_primary_cta"), 10).click();
                        waitForElement(AppiumBy.id("com.nextbillion.groww:id/btnDone"), 10).click();
                    }
                }
            }

        }



    }








    public void sips() throws InterruptedException {

////        Clicking on MF tab
//        clickMFTab();
//
////        Clicking on SIPs tab
//        clickSipTab();

////    Verifying Sort by Functionality
//        waitForElement(AppiumBy.id("com.nextbillion.groww:id/btn_sips_sort"),10).click();
//        waitForElement(AppiumBy.id("com.nextbillion.groww:id/ll_by_due_date"),10).click();
//        waitForElement(AppiumBy.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.nextbillion.groww:id/rv_sips_v2\"]/android.view.ViewGroup[3]"),10).click();

////        Verifying Step-Up Functionality
//        waitForElement(AppiumBy.id("com.nextbillion.groww:id/btn_step_up"),10).click();
////        Verifying Step-Up Functionality using Amount
//        By stepUpAmount = AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.nextbillion.groww:id/btn_text\" and @text=\"Amount\"]");
//        By select = AppiumBy.id("com.nextbillion.groww:id/btn_trailing_icon");
//        By sixMonths = AppiumBy.xpath("//android.widget.CheckedTextView[@text=\"6M\"]");
//        By oneYear = AppiumBy.xpath("//android.widget.CheckedTextView[@text=\"1Y\"]");
//
//        if(isElementPresent(stepUpAmount))
//        {
//            waitForElement(AppiumBy.id("com.nextbillion.groww:id/etIncreaseAmount"),10).click();
//            waitForElement(AppiumBy.id("com.nextbillion.groww:id/etIncreaseAmount"),10).clear();
//            waitForElement(AppiumBy.id("com.nextbillion.groww:id/etIncreaseAmount"),10).sendKeys("100");
//            waitForElement(sixMonths,10).click();
//            waitForElement(AppiumBy.id("com.nextbillion.groww:id/buttonProceed"),10).click();
//            clickBack();
//        }
//        else
//        {
//            waitForElement(select,10).click();
//            waitForElement(AppiumBy.id("com.nextbillion.groww:id/etIncreaseAmount"),10).click();
//            waitForElement(AppiumBy.id("com.nextbillion.groww:id/etIncreaseAmount"),10).clear();
//            waitForElement(AppiumBy.id("com.nextbillion.groww:id/etIncreaseAmount"),10).sendKeys("100");
//            waitForElement(oneYear,10).click();
//            waitForElement(AppiumBy.id("com.nextbillion.groww:id/buttonProceed"),10).click();
//            clickBack();
//        }
//
////        Verifying Step-Up Functionality using Percentage
//        waitForElement(AppiumBy.id("com.nextbillion.groww:id/btn_step_up"),10).click();
//        if(!isElementPresent(stepUpAmount))
//        {
//            waitForElement(AppiumBy.id("com.nextbillion.groww:id/etIncreaseAmount"),10).click();
//            waitForElement(AppiumBy.id("com.nextbillion.groww:id/etIncreaseAmount"),10).clear();
//            waitForElement(AppiumBy.id("com.nextbillion.groww:id/etIncreaseAmount"),10).sendKeys("100");
//            waitForElement(sixMonths,10).click();
//            waitForElement(AppiumBy.id("com.nextbillion.groww:id/buttonProceed"),10).click();
//            clickBack();
//            clickBack();
//        }
//        else
//        {
//            waitForElement(select,10).click();
//            waitForElement(AppiumBy.id("com.nextbillion.groww:id/etIncreaseAmount"),10).click();
//            waitForElement(AppiumBy.id("com.nextbillion.groww:id/etIncreaseAmount"),10).clear();
//            waitForElement(AppiumBy.id("com.nextbillion.groww:id/etIncreaseAmount"),10).sendKeys("100");
//            waitForElement(oneYear,10).click();
//            waitForElement(AppiumBy.id("com.nextbillion.groww:id/buttonProceed"),10).click();
//            clickBack();
//            clickBack();
//        }


////        verifying Change amount/date
//        waitForElement(AppiumBy.id("com.nextbillion.groww:id/btn_change_amt_date"), 10).click();
//        By amount = AppiumBy.id("com.nextbillion.groww:id/et_invest_amt");
//        waitForElement(amount, 10).clear();
//        waitForElement(amount, 10).sendKeys("100");
//        waitForElement(AppiumBy.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.nextbillion.groww:id/incrementSipAmountRv\"]/android.widget.LinearLayout[1]"), 10).click();
//        waitForElement(AppiumBy.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.nextbillion.groww:id/incrementSipAmountRv\"]/android.widget.LinearLayout[2]"), 10).click();
//        waitForElement(AppiumBy.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.nextbillion.groww:id/incrementSipAmountRv\"]/android.widget.LinearLayout[3]"), 10).click();
//        waitForElement(AppiumBy.id("com.nextbillion.groww:id/btn_sip_calendar"), 10).click();
//        calenderDate(17);
//        waitForElement(AppiumBy.id("com.nextbillion.groww:id/buttonOkay"),10).click();
//        waitForElement(AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"com.nextbillion.groww:id/frameFragContainer\"]/android.view.ViewGroup[2]/android.widget.FrameLayout[2]"),10).click();
//        waitForElement(AppiumBy.id("com.nextbillion.groww:id/confirmBtn"),10).click();
//        System.out.println("Need to enter OTP");
//        waitSeconds(10);
//        clickByTextStart("Done");



////        verifying Cancel SIP
//        waitForElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.nextbillion.groww:id/btn_text\" and @text=\"Cancel SIP\"]"),10).click();


//        Deleting cart
        By cartAvailable =  AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"com.nextbillion.groww:id/react_container\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup");
        By delete = AppiumBy.xpath("(//android.widget.TextView[@text=\"\uE92E\"])[1]");
//        waitForElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"Motilal Oswal Midcap Fund Direct Growth\"]"),10).click();
//        waitForElement(AppiumBy.xpath("//android.widget.RelativeLayout[@resource-id=\"com.nextbillion.groww:id/toolbarCart\"]"),10).click();
//        waitSeconds(5);
        while (isElementPresent(cartAvailable)) {
            if (isElementPresent(cartAvailable)) {
                waitForElement(delete, 10).click();

            }
            else
                System.out.println("Empty cart");
        }























//        waitForElement(AppiumBy.id("com.nextbillion.groww:id/ll_by_fund_name"),10).click();

        System.out.println("SIP Tab Completed");




    }
}


