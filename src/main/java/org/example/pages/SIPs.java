package org.example.pages;

import com.beust.ah.A;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.example.utils.GrowwUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class SIPs extends GrowwUtils {

    public SIPs(AndroidDriver driver) {
        super(driver);
    }

    By firstSIP = AppiumBy.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.nextbillion.groww:id/rv_sips_v2\"]/android.view.ViewGroup[3]");
    By secondSIP = AppiumBy.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.nextbillion.groww:id/rv_sips_v2\"]/android.view.ViewGroup[4]");

    public void validateSIPOptions() throws InterruptedException {
        By reasonHeading = AppiumBy.id("com.nextbillion.groww:id/tv_bs_heading");
        List<String> options = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            WebElement option = waitForElement(AppiumBy.xpath("(//android.view.ViewGroup[@resource-id=\"com.nextbillion.groww:id/layout_action_btns\"])[" + i + "]"), 10);
            WebElement s = option.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.nextbillion.groww:id/tv_cancel_reason\" and @index='1']"));
            String s1 = s.getText();
            options.add(s1);
        }
        Assert.assertEquals(options.size(), 6, "All 6 options are not displayed");
        Assert.assertTrue(options.get(0).contains("Not satisfied with returns"), "Option 1 is incorrect");
        Assert.assertTrue(options.get(1).contains("Want to withdraw money"), "Option 2 is incorrect");
        Assert.assertTrue(options.get(2).contains("Want to pause investing"), "Option 3 is incorrect");
        Assert.assertTrue(options.get(3).contains("Want to change SIP amount/date"), "Option 4 is incorrect");
        Assert.assertTrue(options.get(4).contains("Goal is completed"), "Option 5 is incorrect");
        Assert.assertTrue(options.get(5).contains("Other reason to cancel"), "Option 6 is incorrect");

        waitForElement(AppiumBy.xpath("(//android.view.ViewGroup[@resource-id=\"com.nextbillion.groww:id/layout_action_btns\"])[1]"), 10).click();
        Assert.assertEquals(waitForElement(reasonHeading, 10).getText(), "Your SIP is still young", "Reason 1 is incorrect");
        clickBack();

        waitForElement(AppiumBy.xpath("(//android.view.ViewGroup[@resource-id=\"com.nextbillion.groww:id/layout_action_btns\"])[2]"), 10).click();
        Assert.assertEquals(waitForElement(reasonHeading, 10).getText(), "Your money won't be withdrawn by cancelling");
        clickBack();

        waitForElement(AppiumBy.xpath("(//android.view.ViewGroup[@resource-id=\"com.nextbillion.groww:id/layout_action_btns\"])[3]"), 10).click();
        String reason3 = waitForElement(AppiumBy.id("com.nextbillion.groww:id/tvHeading"), 10).getText();
        if (reason3.contains("You can skip 1 instalment in this SIP") || reason3.contains("Are you sure you want to skip")) {
            waitSeconds(2);
        } else {
            Assert.fail("Reason 3 is incorrect");
        }
        clickBack();

        waitForElement(AppiumBy.xpath("(//android.view.ViewGroup[@resource-id=\"com.nextbillion.groww:id/layout_action_btns\"])[4]"), 10).click();
        Assert.assertEquals(waitForElement(reasonHeading, 10).getText(), "You can change SIP amount/date without cancelling", "Reason 4 is incorrect");
        clickBack();

        waitForElement(AppiumBy.xpath("(//android.view.ViewGroup[@resource-id=\"com.nextbillion.groww:id/layout_action_btns\"])[5]"), 10).click();
        Assert.assertEquals(waitForElement(reasonHeading, 10).getText(), "Your dedication and patience paid off!", "Reason 5 is incorrect");
        clickBack();

        waitForElement(AppiumBy.xpath("(//android.view.ViewGroup[@resource-id=\"com.nextbillion.groww:id/layout_action_btns\"])[6]"), 10).click();
        Assert.assertEquals(waitForElement(reasonHeading, 10).getText(), "Future instalments will be stopped", "Reason 6 is incorrect");
        clickBack();
    }

    public void navigateToSIPs() {
        waitForElement(AppiumBy.accessibilityId("Mutual Funds"), 10).click();
        waitForElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.nextbillion.groww:id/textView\" and @text=\"SIPs\"]"), 10).click();
    }

    public void sortByFunctionality() throws InterruptedException {
        waitForElement(AppiumBy.id("com.nextbillion.groww:id/btn_sips_sort"), 10).click();
        waitSeconds(1);
        waitForElement(AppiumBy.id("com.nextbillion.groww:id/ll_by_due_date"), 10).click();
        waitSeconds(1);
        waitForElement(AppiumBy.id("com.nextbillion.groww:id/btn_sips_sort"), 10).click();
        waitSeconds(1);
        waitForElement(AppiumBy.id("com.nextbillion.groww:id/ll_by_fund_name"), 10).click();
        waitSeconds(1);
        waitForElement(AppiumBy.id("com.nextbillion.groww:id/btn_sips_sort"), 10).click();
        waitSeconds(1);
        waitForElement(AppiumBy.id("com.nextbillion.groww:id/ll_by_due_date"), 10).click();
    }



    public void cancelSIPFunctionality() throws InterruptedException {
        if (isElementPresent(firstSIP)){
            //todo redeem sccreen handling
            waitForElement(firstSIP,10).click();
            WebElement cancelSIPButton = waitForElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.nextbillion.groww:id/btn_text\" and @text=\"Cancel SIP\"]"), 10);
            if (cancelSIPButton.isEnabled()) {
                cancelSIPButton.click();
                if (isElementPresent(AppiumBy.id("com.nextbillion.groww:id/cta_primary"))) {
                    waitForElement(AppiumBy.id("com.nextbillion.groww:id/cta_primary"), 10).click();
                    validateSIPOptions();
                }
                else {
                    validateSIPOptions();
                }
            }
            else {
                System.out.println("Cancel SIP button is not enabled");
            }
        }
        else {
                System.out.println("No Active SIPs available");
        }
        clickBack();
        clickBack();
    }

    public void stepUpSIPFunctionality() throws InterruptedException {
        waitForElement(firstSIP,10).click();
        waitForElement(AppiumBy.id("com.nextbillion.groww:id/btn_step_up"),10).click();
        Assert.assertEquals(waitForElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.nextbillion.groww:id/mint_internal_appbar_titlebar_title\" and @text=\"Step-up SIP\"]"),10).getText(),"Step-up SIP","Step-up SIP functionality is not working");
        By enterValue = AppiumBy.id("com.nextbillion.groww:id/etIncreaseAmount");
        By selectAmount = AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.nextbillion.groww:id/btn_text\" and @text=\"Amount\"]");
        By selectPercentage = AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.nextbillion.groww:id/btn_text\" and @text=\"Percentage\"]");
        By sixMonths = AppiumBy.xpath("//android.widget.CheckedTextView[@text=\"6M\"]");
        By oneYear = AppiumBy.xpath("//android.widget.CheckedTextView[@text=\"1Y\"]");

        if (isElementPresent(selectAmount)){
            waitForElement(enterValue,10).clear();
            waitForElement(enterValue,10).sendKeys("99");
            Assert.assertTrue(isElementPresent(AppiumBy.id("com.nextbillion.groww:id/tvNote")),"Note for minimum amount is not displayed");
        }
        else if (isElementPresent(selectPercentage)){
            waitForElement(selectPercentage,10).click();
            waitForElement(enterValue,10).clear();
            waitForElement(enterValue,10).sendKeys("99");
            Assert.assertTrue(isElementPresent(AppiumBy.id("com.nextbillion.groww:id/tvNote")),"Note for minimum amount is not displayed");
        }

        if (isElementPresent(selectAmount)){
            waitForElement(selectAmount,10).click();
            waitForElement(enterValue,10).clear();
            waitForElement(enterValue,10).sendKeys("9");
            Assert.assertTrue(isElementPresent(AppiumBy.id("com.nextbillion.groww:id/tvNote")),"Note for minimum percentage is not displayed");
        }
        else if (isElementPresent(selectPercentage)){
            waitForElement(enterValue,10).clear();
            waitForElement(enterValue,10).sendKeys("9");
            Assert.assertTrue(isElementPresent(AppiumBy.id("com.nextbillion.groww:id/tvNote")),"Note for minimum percentage is not displayed");
        }
        waitForElement(sixMonths,10).click();
        waitForElement(oneYear,10).click();
        waitForElement(selectPercentage,10).click();
        waitForElement(enterValue,10).clear();
        waitForElement(enterValue,10).sendKeys("110");
        waitForElement(AppiumBy.id("com.nextbillion.groww:id/buttonProceed"),10).click();
        System.out.println("Enter OTP manually");
        waitSeconds(15);
        clickBack();
        clickBack();
        navigateToSIPs();
        waitForElement(firstSIP,10).click();

        if (isElementPresent(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.nextbillion.groww:id/btn_text\" and @text=\"Step-up added\"]"))){
            waitForElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.nextbillion.groww:id/btn_text\" and @text=\"Step-up added\"]"),10).click();
            Assert.assertEquals(waitForElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.nextbillion.groww:id/btn_text\" and @text=\"Remove step-up\"]"),10).getText(),"Remove step-up","Remove Step-up SIP functionality is not working");
            waitForElement(AppiumBy.id("com.nextbillion.groww:id/btn_remove"),10).click();
            Assert.assertEquals(waitForElement(AppiumBy.id("com.nextbillion.groww:id/tv_title"),10).getText(),"Are you sure you want to remove step-up?","Remove Step-up SIP functionality is not working");
            waitForElement(AppiumBy.id("com.nextbillion.groww:id/btn_skip"),10).click();
            Assert.assertEquals(waitForElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.nextbillion.groww:id/btn_text\" and @text=\"Add step-up\"]"),10).getText(),"Add step-up","Step-up SIP is not removed");
        }
        else {
            System.out.println("Step-up SIP is not added for the selected SIP" );
        }


        // Can not proceed further due to screen issue.
    }

    public void changeAmountDateFunctionality() throws InterruptedException {
        if (isElementPresent(firstSIP)){
            waitForElement(firstSIP,10).click();
            if(!isClickable(AppiumBy.id("com.nextbillion.groww:id/btn_change_amt_date"),10)){
                clickBack();
                waitForElement(secondSIP,10).click();
                waitForElement(AppiumBy.id("com.nextbillion.groww:id/btn_change_amt_date"),10).click();
                By enteramount = AppiumBy.id("com.nextbillion.groww:id/et_invest_amt");
                waitForElement(enteramount,10).clear();

                waitForElement(By.xpath("//android.widget.TextView[@text=\"₹1,000\"]"),10).click();
                Assert.assertEquals(waitForElement(enteramount,10).getText(),"1000","Amount selection(1000) is not working");

                waitForElement(By.xpath("//android.widget.TextView[@text=\"₹2,000\"]"),10).click();
                Assert.assertEquals(waitForElement(enteramount,10).getText(),"3000","Amount selection(2000) is not working");

                waitForElement(By.xpath("//android.widget.TextView[@text=\"₹5,000\"]"),10).click();
                Assert.assertEquals(waitForElement(enteramount,10).getText(),"8000","Amount selection(3000) is not working");

                waitForElement(AppiumBy.id("com.nextbillion.groww:id/btn_sip_calendar"),10).click();
                waitForElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.nextbillion.groww:id/sipDate\" and @text=\"18\"]"),10).click();
                String s= waitForElement(AppiumBy.id("com.nextbillion.groww:id/textNextSip"),10).getText();
                Assert.assertEquals(s.contains("18th"),"Date selection is not working");
                waitForElement(AppiumBy.id("com.nextbillion.groww:id/buttonOkay"),10).click();
                String s1 = waitForElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.nextbillion.groww:id/btn_text\" and @text=\"18th of every month\"]"),10).getText();
                Assert.assertEquals(s1.contains("18th"),"Date selection is not working");

                waitForElement(enteramount,10).clear();
                waitForElement(enteramount,10).sendKeys("110");
                waitForElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.nextbillion.groww:id/btn_text\" and @text=\"Save changes\"]"),10).click();

                Assert.assertEquals(waitForElement(AppiumBy.id("com.nextbillion.groww:id/titleTv"),10).getText(),"Confirm new amount and date","Change Amount/Date functionality is not working");
                Assert.assertEquals(waitForElement(AppiumBy.id("com.nextbillion.groww:id/firstValue"),10).getText(),"₹110","Change Amount/Date functionality is not working");
                Assert.assertEquals(waitForElement(AppiumBy.id("com.nextbillion.groww:id/editDone"),10).getText(),"Monthly on 18th","Change Amount/Date functionality is not working");
                waitForElement(AppiumBy.id("com.nextbillion.groww:id/confirmBtn"),10).click();
                System.out.println("Need to enter OTP manually");
                waitSeconds(15);
                Assert.assertEquals(waitForElement(AppiumBy.id("com.nextbillion.groww:id/tvOrderSuccessTitle"),10).getText(),"SIP edit success","Change Amount/Date functionality is not working");
                waitForElement(AppiumBy.id("com.nextbillion.groww:id/btnDone"),10).click();
                clickBack();

            }
            else {
                waitForElement(AppiumBy.id("com.nextbillion.groww:id/btn_change_amt_date"),10).click();
                By enteramount = AppiumBy.id("com.nextbillion.groww:id/et_invest_amt");
                waitForElement(enteramount,10).clear();

                waitForElement(By.xpath("//android.widget.TextView[@text=\"₹1,000\"]"),10).click();
                Assert.assertEquals(waitForElement(enteramount,10).getText(),"1000","Amount selection(1000) is not working");

                waitForElement(By.xpath("//android.widget.TextView[@text=\"₹2,000\"]"),10).click();
                Assert.assertEquals(waitForElement(enteramount,10).getText(),"3000","Amount selection(2000) is not working");

                waitForElement(By.xpath("//android.widget.TextView[@text=\"₹5,000\"]"),10).click();
                Assert.assertEquals(waitForElement(enteramount,10).getText(),"8000","Amount selection(3000) is not working");

                waitForElement(AppiumBy.id("com.nextbillion.groww:id/btn_sip_calendar"),10).click();
                waitForElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.nextbillion.groww:id/sipDate\" and @text=\"18\"]"),10).click();
                String s= waitForElement(AppiumBy.id("com.nextbillion.groww:id/textNextSip"),10).getText();
                Assert.assertEquals(s,"Next SIP instalment on 18th September","Date selection is not working");
                waitForElement(AppiumBy.id("com.nextbillion.groww:id/buttonOkay"),10).click();
                String s1 = waitForElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.nextbillion.groww:id/btn_text\" and @text=\"18th of every month\"]"),10).getText();
                Assert.assertEquals(s1,"18th of every month","Date selection is not working");

                waitForElement(enteramount,10).clear();
                waitForElement(enteramount,10).sendKeys("110");
                waitForElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.nextbillion.groww:id/btn_text\" and @text=\"Save changes\"]"),10).click();

                Assert.assertEquals(waitForElement(AppiumBy.id("com.nextbillion.groww:id/titleTv"),10).getText(),"Confirm new amount and date","Change Amount/Date functionality is not working");
                Assert.assertEquals(waitForElement(AppiumBy.id("com.nextbillion.groww:id/firstValue"),10).getText(),"₹110","Change Amount/Date functionality is not working");
                Assert.assertEquals(waitForElement(AppiumBy.id("com.nextbillion.groww:id/editDone"),10).getText(),"Monthly on 18th","Change Amount/Date functionality is not working");
                waitForElement(AppiumBy.id("com.nextbillion.groww:id/confirmBtn"),10).click();
                System.out.println("Need to enter OTP manually");
                waitSeconds(15);
                Assert.assertEquals(waitForElement(AppiumBy.id("com.nextbillion.groww:id/tvOrderSuccessTitle"),10).getText(),"SIP edit success","Change Amount/Date functionality is not working");
                waitForElement(AppiumBy.id("com.nextbillion.groww:id/btnDone"),10).click();
                clickBack();
            }
        }
        else {
            System.out.println("No Active SIPs available");
        }

    }






    public void paymentDueFunctionality(){
        if (isElementPresent(firstSIP)){
            String paymentDueText = waitForElement(AppiumBy.xpath("(//android.widget.TextView[@resource-id=\"com.nextbillion.groww:id/tv_tag\"])[1]"),10).getText();
            if (paymentDueText.contains("Payment due")) {
                waitForElement(firstSIP,10).click();
                String paymentDueText1 = waitForElement(AppiumBy.id("com.nextbillion.groww:id/tv_upcoming_sip_header"),10).getText();
                Assert.assertEquals(paymentDueText1,"Payment due","Payment due functionality is not working");
                waitForElement(AppiumBy.id("com.nextbillion.groww:id/btn_pay"),10).click();
                clickBack();
                clickBack();
            }
            else {
                System.out.println("No Payment due SIPs available");
            }
        }
        else {
            System.out.println("No Active SIPs available");
        }
    }

    public void dueInOneDayFunctionality(){
        if (isElementPresent(firstSIP)){
            String paymentDueText = waitForElement(AppiumBy.xpath("(//android.widget.TextView[@resource-id=\"com.nextbillion.groww:id/tv_tag\"])[1]"),10).getText();
            if (paymentDueText.contains("Due in 1 day")) {
                waitForElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.nextbillion.groww:id/tv_tag\" and @text=\"Due in 1 day\"]"),10).click();
                String dueInOneDayText = waitForElement(AppiumBy.id("com.nextbillion.groww:id/tv_upcoming_sip_header"),10).getText();
                Assert.assertEquals(dueInOneDayText,"Upcoming","Due in 1 day functionality is not working");
            }
            else {
                System.out.println("No Due in 1 day SIPs available");
            }
        }
        else {
            System.out.println("No Active SIPs available");
        }

//        waitForElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.nextbillion.groww:id/tv_tag\" and @text=\"Due in 1 day\"]"),10).click();
//        String dueInOneDayText = waitForElement(AppiumBy.id("com.nextbillion.groww:id/tv_upcoming_sip_header"),10).getText();
//        Assert.assertEquals(dueInOneDayText,"Upcoming","Due in 1 day functionality is not working");

    }

    public void autoCancelledSIPsFunctionality(){
        if (isElementPresent(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.nextbillion.groww:id/tv_header\"]"))){
            String acs= waitForElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.nextbillion.groww:id/tv_header\"]"),10).getText();
            Assert.assertTrue(acs.contains("Auto-cancelled SIPs"),"Auto-cancelled SIPs functionality is not working");
            String description = waitForElement(AppiumBy.id("com.nextbillion.groww:id/tv_mb"),10).getText();
            Assert.assertTrue(description.contains("As per SEBI's latest regulations"),"Description for Auto-cancelled SIPs is incorrect");
            waitForElement(AppiumBy.xpath("(//android.widget.FrameLayout[@resource-id=\"com.nextbillion.groww:id/btn_restart_sip\"])[1]"),10).click();
            clickBack();
        }
        else {
            System.out.println("No Auto-cancelled SIPs available");
        }
    }

    public void sIPsCancelledByYouFunctionality(){
        if (isElementPresent(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.nextbillion.groww:id/tv_header\"]"))){
            String scby= waitForElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.nextbillion.groww:id/tv_header\"]"),10).getText();
            Assert.assertTrue(scby.contains("SIPs cancelled by you"),"SIPs cancelled by you functionality is not working");
            waitForElement(AppiumBy.xpath("(//android.widget.FrameLayout[@resource-id=\"com.nextbillion.groww:id/btn_restart_sip\"])[1]"),10).click();
            clickBack();
        }
        else {
            System.out.println("No SIPs cancelled by you available");
        }

    }






//    public void calenderDate(int i) {
//        String xpath = "//android.widget.TextView[@resource-id=\"com.nextbillion.groww:id/sipDate\" and @text='" + i + "']";
//        waitForElement(AppiumBy.xpath(xpath), 10).click();
//    }
//
//
//    public void cancelSIP() throws InterruptedException {
//        waitForElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.nextbillion.groww:id/textView\" and @text=\"SIPs\"]"), 10).click();
//        WebElement cs = waitForElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.nextbillion.groww:id/btn_text\" and @text=\"Cancel SIP\"]"),10);
//        for (int i = 1; i <= 1; i++) {
//            waitForElement(AppiumBy.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.nextbillion.groww:id/rv_sips_v2\"]/android.view.ViewGroup[3]"), 10).click();
//            WebElement cs = waitForElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.nextbillion.groww:id/btn_text\" and @text=\"Cancel SIP\"]"), 10);
//            if (cs.isEnabled()) {
//                waitForElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.nextbillion.groww:id/btn_text\" and @text=\"Cancel SIP\"]"), 10).click();
//                if (isElementPresent(AppiumBy.id("com.nextbillion.groww:id/cta_primary"))) {
//                    waitForElement(AppiumBy.id("com.nextbillion.groww:id/cta_primary"), 10).click();
//                    waitForElement(AppiumBy.xpath("(//android.view.ViewGroup[@resource-id=\"com.nextbillion.groww:id/layout_action_btns\"])[6]"), 10).click();
//                    waitForElement(AppiumBy.id("com.nextbillion.groww:id/btn_primary_cta"), 10).click();
//                    waitForElement(AppiumBy.id("com.nextbillion.groww:id/btnDone"), 10).click();
//                } else {
//                    waitForElement(AppiumBy.xpath("(//android.view.ViewGroup[@resource-id=\"com.nextbillion.groww:id/layout_action_btns\"])[6]"), 10).click();
//                    waitForElement(AppiumBy.id("com.nextbillion.groww:id/btn_primary_cta"), 10).click();
//                    waitForElement(AppiumBy.id("com.nextbillion.groww:id/btnDone"), 10).click();
//                }
//            } else {
//                clickBack();
//                waitForElement(AppiumBy.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.nextbillion.groww:id/rv_sips_v2\"]/android.view.ViewGroup[4]"), 10).click();
//                WebElement cs1 = waitForElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.nextbillion.groww:id/btn_text\" and @text=\"Cancel SIP\"]"), 10);
//                waitSeconds(2);
//                if (cs1.isEnabled()) {
//                    waitForElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.nextbillion.groww:id/btn_text\" and @text=\"Cancel SIP\"]"), 10).click();
//                    if (isElementPresent(AppiumBy.id("com.nextbillion.groww:id/cta_primary"))) {
//                        waitForElement(AppiumBy.id("com.nextbillion.groww:id/cta_primary"), 10).click();
//                        waitForElement(AppiumBy.xpath("(//android.view.ViewGroup[@resource-id=\"com.nextbillion.groww:id/layout_action_btns\"])[6]"), 10).click();
//                        waitForElement(AppiumBy.id("com.nextbillion.groww:id/btn_primary_cta"), 10).click();
//                        waitForElement(AppiumBy.id("com.nextbillion.groww:id/btnDone"), 10).click();
//                    } else {
//                        waitForElement(AppiumBy.xpath("(//android.view.ViewGroup[@resource-id=\"com.nextbillion.groww:id/layout_action_btns\"])[6]"), 10).click();
//                        waitForElement(AppiumBy.id("com.nextbillion.groww:id/btn_primary_cta"), 10).click();
//                        waitForElement(AppiumBy.id("com.nextbillion.groww:id/btnDone"), 10).click();
//                    }
//                }
//            }
//
//        }
//
//
//    }
}










//    public void sips() throws InterruptedException {

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
//        By cartAvailable =  AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"com.nextbillion.groww:id/react_container\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup");
//        By delete = AppiumBy.xpath("(//android.widget.TextView[@text=\"\uE92E\"])[1]");
//        waitForElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"Motilal Oswal Midcap Fund Direct Growth\"]"),10).click();
//        waitForElement(AppiumBy.xpath("//android.widget.RelativeLayout[@resource-id=\"com.nextbillion.groww:id/toolbarCart\"]"),10).click();
//        waitSeconds(5);
//        while (isElementPresent(cartAvailable)) {
//            if (isElementPresent(cartAvailable)) {
//                waitForElement(delete, 10).click();
//
//            }
//            else
//                System.out.println("Empty cart");
//        }























//        waitForElement(AppiumBy.id("com.nextbillion.groww:id/ll_by_fund_name"),10).click();

//        System.out.println("SIP Tab Completed");



//
//    }
//}


