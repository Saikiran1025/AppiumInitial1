package org.example.test;

import org.example.test.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DashboardTabTest extends BaseTest {


    @Test(priority = 1,description = "Verify dashboard page loads correctly")
    public void testnavigatieToDashboard() {
        dashboardPage.navigatieToDashboard();
        // Verify that the dashboard page loads correctly
    }


    @Test(priority = 2, description = "Verify pending payments section functionality")
    public void testPendingPaymentsSection() {
        dashboardPage.pendingPayments();

        // This test will check if pending payments are handled correctly
        // Either payments exist and can be processed, or no payments message is shown
    }

    @Test(priority = 3, description = "Verify orders in progress functionality")
    public void testOrdersInProgress() {
        dashboardPage.orders();

        // Verify orders section behavior
        // Should handle both cases - when orders exist and when they don't
    }

    @Test(priority = 4, description = "Verify hide/unhide investment amounts")
    public void testHideUnhideAmounts() throws InterruptedException {
        dashboardPage.hideUnhide();

        // Verify that amounts can be hidden/shown
        waitSeconds(2);
    }

    @Test(priority = 5, description = "Verify comprehensive portfolio analysis")
    public void testPortfolioAnalysis() throws InterruptedException {
        dashboardPage.portfolioAnalysis();

        // This test covers multiple portfolio analysis features:
        // - Duration selection (1M, 6M, 1Y, 3Y, 5Y, ALL)
        // - Category distribution
        // - Tax & capital gains analysis
    }

    @Test(priority = 6, description = "Verify XIRR display and calculation")
    public void testXirrDisplay() {
        dashboardPage.dashboardXirr();
        scrollHalfPageUp();
        // Verify XIRR values are displayed and interactive
    }

    @Test(priority = 7, description = "Verify sorting functionality for investments")
    public void testInvestmentSorting() {
        dashboardPage.sort();

        // Test all sorting options:
        // - Current Value, Returns %, Day Change %, XIRR %, Alphabetical
    }

    @Test(priority = 8, description = "Verify scheme validation between dashboard and detail pages")
    public void testSchemeValidation() throws InterruptedException {
        dashboardPage.dashboardSchemeValidation();

        // Verify scheme names match across different views
    }

    @Test(priority = 9,
            description = "Verify redeem functionality from dashboard")
    public void testRedeemFromDashboard() throws InterruptedException {
        dashboardPage.dashboardRedeem();

        // Test redeem flow from dashboard
    }

    @Test(priority = 10, description = "Verify investment details navigation")
    public void testInvestmentDetailsNavigation() {
        dashboardPage.dashboardInvestmentDetails();

        // Verify navigation to investment details page
    }

    @Test(priority = 11, description = "Verify purchase options from dashboard")
    public void testPurchaseFromDashboard() {
        dashboardPage.dashboardPurchase();

        // Test One Time and SIP purchase options from dashboard
    }

    @Test(priority = 12, description = "Verify sort title functionality")
    public void testSortTitle() throws InterruptedException {
        dashboardPage.sortTitle();

        // Test the sort title functionality with scrolling
    }
}
