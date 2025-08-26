package org.example.test;


import org.example.pages.DashboardTab;
import org.example.pages.ExploreTab;
import org.example.pages.InvestmentDetails;
import org.example.pages.Login;
import org.example.utils.GrowwUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class FirstTest extends GrowwUtils {

    @BeforeClass
    public void initializeDriver() throws MalformedURLException, InterruptedException {
        super.setup(); // from GrowwUtils
    }

    public class ExploreTabTests {
        private ExploreTab exploreTab;

        private DashboardTab dashboardTab;

        private Login login;

        private InvestmentDetails investmentDetails;

//        public ExploreTabTests() {}

//        public void DashboardTabTests() {}

        @BeforeClass
        public void setupTest() throws MalformedURLException, InterruptedException {
            setup(); // from GrowwUtils
            exploreTab = new ExploreTab(driver);
            dashboardTab = new DashboardTab(driver);
            login = new Login(driver);
            investmentDetails = new InvestmentDetails(driver);

        }

//        @Test(priority = 0)
//        public void enterPin() throws InterruptedException {
//            launchApp();
//            waitSeconds(3);
//            login.enterPin("1025");
//        }
//
//        @Test(priority = 1)
//        public void searchBehaviour() throws InterruptedException {
//            exploreTab.searchBehaviourRegularKeyword();
//            exploreTab.searchSchemename("navi");
//            exploreTab.trendingSearches();
//        }

//        @Test(priority = 2)
//        public void popularFunds() {
//            exploreTab.popularFunds();
//            scrollHalfPageUp();
//        }
//
//        @Test(priority = 3)
//        public void collections() throws InterruptedException {
//            exploreTab.collections();
//        }
//
//        @Test(priority = 4)
//        public void recentlyViewed() throws InterruptedException {
//            exploreTab.recentlyViewed();
//            scrollHalfPageUp();
//        }
//
//        @Test(priority = 5)
//        public void fundsByGroww() throws InterruptedException {
//            exploreTab.fundsByGroww();
//        }
//
//        @Test(priority = 7)
//        public void productAndTools() throws InterruptedException {
//            exploreTab.productAndTools();
//        }
//
//        @Test(priority = 8)
//        public void addCart() throws InterruptedException {
//            exploreTab.addCart();
//        }
//
//        @Test(priority = 9)
//        public void removeCart() throws InterruptedException {
//            exploreTab.removeCart();
//            scrollToEnd();
//        }
//
//        @Test(priority = 9)
//        public void allMutualFunds() throws InterruptedException {
//            exploreTab.allMutualFunds();
//        }
//
//        @Test(priority = 10)
//        public void collectionsData()
//        {
//            exploreTab.collectionsData();
//        }
//
//        @Test(priority = 11)
//        public void pendingPayments() {
//            dashboardTab.pendingPayments();
//        }

//        @Test(priority = 12)
//        public void orders() {
//            dashboardTab.orders();
//        }
//
//        @Test(priority = 13)
//        public void investments() {
//            dashboardTab.investments();
//        }
//
//        @Test(priority = 14)
//        public void hideUnhide() {
//            dashboardTab.hideUnhide();
//        }
//
//        @Test(priority = 15)
//        public void portfolioAnalysis() throws InterruptedException {
//            dashboardTab.portfolioAnalysis();
//        }
//
//        @Test(priority = 15)
//        public void xidashboardXirrrr() throws InterruptedException {
//            dashboardTab.dashboardXirr();
//        }
//
//        @Test(priority = 15)
//        public void sort() throws InterruptedException {
//            dashboardTab.sort();
//            scrollHalfPageUp();
//        }
//
//        @Test(priority = 16)
//        public void investmentDetails() throws InterruptedException {
//            scrollHalfPageUp();
//            dashboardTab.dashboardSchemeValidation();
//
//        }
//
//        @Test(priority = 16)
//        public void dashboardRedeem() throws InterruptedException {
//            dashboardTab.dashboardRedeem();
//        }
//
//        @Test(priority = 17)
//        public void dashboardInvestmentDetails() throws InterruptedException {
//            dashboardTab.dashboardInvestmentDetails();
//        }
//
//        @Test(priority = 18)
//        public void dashboardPurchase() {
//            dashboardTab.dashboardPurchase();
//        }

//        @Test(priority = 19)
//        public void investmentDetailsFolioSelection() throws InterruptedException {
//            investmentDetails.investmentDetails();
//            investmentDetails.investmentDetailsFolioSelection();
//            investmentDetails.selectPhysicalFolio();
//            investmentDetails.investmentDetailsFolioSelection();
//            investmentDetails.selectDematFolio();
//            scrollHalfPageUp();
//        }

        @Test(priority = 20)
        public void investmentDetailsSwitch() throws InterruptedException {
            investmentDetails.investmentDetailsSwitch();
        }

//        @Test(priority = 21)
//        public void investmentDetailsSTP() throws InterruptedException {
//            investmentDetails.investmentDetailsSTP();
//        }





    }
}













//    @Test
//    public void testScreener() throws InterruptedException {
//        ExploreTab e = new ExploreTab(driver);
//        e.screener();
//        e.collections();
//        e.recentlyViewed();
//        e.fundsByGroww();
//        e.productAndTools();
//        e.addCart();
//
//        e.removeCart();
//
//
//
//    }




//    public static void main(String[] args) throws MalformedURLException, InterruptedException
//    {
//        GrowwUtils g = new GrowwUtils();
//        g.setup();
//
//        g.launchApp();
//        FirstTest f = new FirstTest(g.driver);
//        g.waitSeconds(2);
//        Login l = new Login(g.driver);
////        l.googlelogin();
////        l.manualLogin();
////        l.enterPin("1025");
//        ProductPage pp = new ProductPage(f.driver);
//        f.launchApp();
//        g.waitSeconds(5);
//        l.enterPin("1025");
//        pp.productpage();
//        System.out.println("Product Page Completed");
//        Thread.sleep(5000);
//        f.closeApp();
//        PlaceOrder p = new PlaceOrder(f.driver);
//        f.launchApp();
//        Thread.sleep(5000);
//        l.enterPin("1025");
//        Thread.sleep(5000);
//        p.placeOrder();
//        System.out.println("Place Order Completed");
//        f.closeApp();
//        Thread.sleep(5000);
//        ExploreTab e = new ExploreTab(f.driver);
//        f.launchApp();
//        g.waitSeconds(5);
//        l.enterPin("1025");
//        g.waitSeconds(5);
//        e.exploreTab();
//        System.out.println("Explore Tab completed");

//        Dashboard d = new Dashboard(f.driver);
////        f.launchApp();
////        Thread.sleep(5000);
////        l.enterPin("1025");
//        d.dashbord();

//        Sips s = new Sips(f.driver);
//        f.launchApp();
//        Thread.sleep(5000);
//        l.enterPin("1025");
//        s.sips();


//        f.closeApp();


//        System.out.println("Completed");



//    }
//}

