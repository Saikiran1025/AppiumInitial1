package org.example.test;

import org.testng.annotations.Test;

public class SIPsTest extends BaseTest{

//    @Test(priority = 1,description = "Verify SIPs page loads correctly")
//    public void testNavigateToSIPs(){
//        sipsPage.navigateToSIPs();
//        System.out.println("Succesfully Navigated to SIPs page");
//        // Verify that the SIPs page loads correctly
//    }
//
//    @Test(priority = 2,description = "Verify Sort By functionality on SIPs page")
//    public void testSortByFunctionality() throws InterruptedException {
//        sipsPage.sortByFunctionality();
//        System.out.println("Sort By functionality on SIPs page is working correctly");
//        // Verify that the Sort By functionality works as expected
//    }
//
//
//    @Test(priority = 3,description = "Cancel SIP functionality on SIPs page")
//    public void testcancelSIPFunctionality() throws InterruptedException {
//        sipsPage.cancelSIPFunctionality();
//        System.out.println("Cancel SIP functionality on SIPs page is working correctly");
//
//        // Verify that the Cancel SIP functionality works as expected
//    }
//
//    @Test(priority = 4,description = "Step-up SIP functionality on SIPs page")
//    public void teststepUpSIPFunctionality() throws InterruptedException {
//        sipsPage.stepUpSIPFunctionality();
//        System.out.println("Step-up SIP functionality on SIPs page is working correctly");
//
//        // Verify that the Step-up SIP functionality works as expected
//    }

    @Test(priority = 5,description = "Change Amount/Date functionality on SIPs page")
    public void testchangeAmountDateFunctionality() throws InterruptedException {
        sipsPage.changeAmountDateFunctionality();
        System.out.println("Change Amount/Date functionality on SIPs page is working correctly");

        // Verify that the Change Amount/Date functionality works as expected

    }



//    @Test(priority = 3,description = "Verify Payment due functionality in Active SIPs on SIPs page")
//    public void testPaymentDueFunctionality() {
//        sipsPage.paymentDueFunctionality();
//        System.out.println("Payment due functionality in Active SIPs on SIPs page is working correctly");
//        scrollToText("Due in 1 day");
//        // Verify that the Payment due functionality works as expected
//    }
//
//    @Test(priority = 4,description = "Verify Due in 1 day functionality in Active SIPs on SIPs page")
//    public void testDueInOneDayFunctionality() {
//        sipsPage.dueInOneDayFunctionality();
//        System.out.println("Due in 1 day functionality in Active SIPs on SIPs page is working correctly");
//
//        // Verify that the Due in 1 day functionality works as expected
//    }











//    @Test(priority = 5,description = "Verify Auto-cancelled SIPs functionality in Active SIPs on SIPs page")
//    public void testAutoCancelledSIPsFunctionality() {
//        scrollToText("Auto-cancelled SIPs");
//        sipsPage.autoCancelledSIPsFunctionality();
//        System.out.println("Auto-cancelled SIPs functionality in Active SIPs on SIPs page is working correctly");
//
//        // Verify that the Auto-cancelled SIPs functionality works as expected
//    }
//
//    @Test(priority = 6,description = "Verify SIPs cancelled by you functionality in Active SIPs on SIPs page")
//    public void testSIPsCancelledByYouFunctionality() {
//        scrollHalfPageUp();
//        sipsPage.sIPsCancelledByYouFunctionality();
//        System.out.println("SIPs cancelled by you functionality in Active SIPs on SIPs page is working correctly");
//
//        // Verify that the SIPs cancelled by you functionality works as expected
//    }








}
