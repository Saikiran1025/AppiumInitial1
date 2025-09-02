package org.example.test;

import io.appium.java_client.AppiumBy;
import org.example.test.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExploreTabTest extends BaseTest {



//    @Test(priority = 1, description = "Navigate to Explore tab")
//    public void navigateToExplore() {
//        explorePage.navigateToExplore();
//        System.out.println("Navigated to Explore tab successfully.");
//    }
//
//    @Test(priority = 2, description = "Verify add to cart functionality")
//    public void testAddToCartFunctionality() throws InterruptedException {
//        explorePage.addCart();
//        System.out.println("Add to cart functionality verified.");
//
//        // Test adding funds to cart
//    }
//
//    @Test(priority = 3, description = "Verify search behavior with regular keyword")
//    public void testSearchWithRegularKeyword() throws InterruptedException {
//        explorePage.searchBehaviourRegularKeyword();
//        System.out.println("Search with regular keyword functionality verified.");
//    }
//
//    @Test(priority = 4, description = "Verify search functionality with scheme names")
//    public void testSearchBySchemeNames() throws InterruptedException {
//        explorePage.searchSchemename("Navi");
//        System.out.println("Search by scheme names functionality verified.");
//    }
//
//    @Test(priority = 5, description = "Verify trending searches functionality")
//    public void testTrendingSearches() throws InterruptedException {
//        explorePage.trendingSearches();
//        System.out.println("Trending searches functionality verified.");
//    }

    @Test(priority = 0, description = "Verify popular funds section")
    public void testPopularFundsSection() throws InterruptedException {
        explorePage.popularFunds();
        System.out.println("Popular funds section functionality verified.");
        scrollHalfPageUp();
    }

//    @Test(priority = 7, description = "Verify fund collections functionality")
//    public void testFundCollections() throws InterruptedException {
//        explorePage.collections();
//        System.out.println("Fund collections functionality verified.");
//    }
//
//    @Test(priority = 8, description = "Verify recently viewed funds section")
//    public void testRecentlyViewedFunds() {
//        explorePage.recentlyViewed();
//        System.out.println("Recently viewed funds functionality verified.");
//
//        // Test recently viewed funds functionality
//    }
//
//    @Test(priority = 9, description = "Verify funds by Groww section")
//    public void testFundsByGroww() throws InterruptedException {
//        explorePage.fundsByGroww();
//        System.out.println("Funds by Groww functionality verified.");
//        scrollHalfPageUp();
//
//        // Test Groww's own fund offerings
//    }
//
//    @Test(priority = 10, description = "Verify products and tools section")
//    public void testProductsAndTools() throws InterruptedException {
//        explorePage.productAndTools();
//        System.out.println("Products and tools functionality verified.");
//
//        // Test NFO, SIP Calculator, Compare Funds, etc.
//    }
//
//    @Test(priority = 11, description = "Verify remove from cart functionality")
//    public void testRemoveFromCartFunctionality() throws InterruptedException {
//        explorePage.removeCart();
//        System.out.println("Remove from cart functionality verified.");
//        scrollToEnd();
//
//
////        need to verify cart is empty
//
//        // Test removing funds from cart
//    }
//
//    @Test(priority = 12, description = "Verify all mutual funds screener")
//    public void testAllMutualFundsScreener() {
//        explorePage.allMutualFunds();
//        System.out.println("All mutual funds screener functionality verified.");
//
//        // Test the main mutual funds screener
//    }




}
