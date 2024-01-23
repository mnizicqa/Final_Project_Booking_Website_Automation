package tests;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.BestOfferDestinationPage;
import pages.DestinationPage;
import pages.HomePage;

public class FinalProjectBooking extends BaseTest {

    HomePage homePage = new HomePage(driver);

    DestinationPage destinationPage = new DestinationPage(driver);

    BestOfferDestinationPage bestOfferDestinationPage = new BestOfferDestinationPage(driver);

    @BeforeMethod
    @Parameters({"browser", "env", "wait"})
    public void setup(String browser, String wait, String env) throws Exception {
        init(browser, wait);
        openApp("PROD");
        new HomePage(driver).closeModal();
    }

    @AfterMethod
    @Parameters({"quit"})
    public void tearDown(String quit) {
        if (quit.equalsIgnoreCase(("Yes"))) {
            quit();
        }
    }

    @Test(priority = 1)
    @Severity(SeverityLevel.BLOCKER)

    public void bookProperty() throws Exception {

        homePage.enterDestination("Kopaonik");
        homePage.clickDatePicker();
        homePage.selectStartDate();
        homePage.selectEndDate();
        homePage.selectGuestAndRoomsNumber();
        homePage.clickDone();
        homePage.clickSubmitButton();
        homePage.titleIsVisible();
        reportScreenshot("screenshotBook", "Book Property screenshot");
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.NORMAL)

    public void subscribe() throws Exception {

        homePage.scrollToSubscribeSection();
        homePage.enterEmailAddress("tester@testing.com");
        homePage.higlightNewsletterInputField();
        homePage.clickSubscribeButton();
        homePage.checkSuccessMessage();
        reportScreenshot("screenshotSubscribe", "Subscribe screenshot");
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)

    public void trendingDestinations() throws Exception {

        homePage.scrollToTrendingDestinationsSection();
        homePage.checkImagesNumber("5");
        homePage.selectTrendingDestination();
        destinationPage.selectStartDate();
        destinationPage.selectEndDate();
        destinationPage.clickSubmitButton();
        destinationPage.verifyTrendingDestinationTitle();
        destinationPage.verifyTrendingDestinationTitleColor();
        destinationPage.selectPriceRange();
        reportScreenshot("screenshotTrend", "Trending Destinations screenshot");
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)

    public void exploreBosnia() throws Exception {

        homePage.scrollToExploreBosniaSection();
        homePage.selectBosniaDestination();
        DestinationPage destinationPage = new DestinationPage(driver);
        destinationPage.selectStartDate();
        destinationPage.selectEndDate();
        destinationPage.clickSubmitButton();
        destinationPage.selectPriceRange();
        destinationPage.verifyNumberOfResults();
        reportScreenshot("screenshotExp", "Explore Bosnia screenshot");
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    public void bestOffers() throws Exception {

        homePage.selectDesiredLanguage();
        homePage.confirmSelectedLanguage();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,200)");
        homePage.selectBestOfferDestination();
        bestOfferDestinationPage.scrollToSeasonalOfferSection();
        bestOfferDestinationPage.checkSeasonImagesNumber("12");
        bestOfferDestinationPage.selectSeasonalOfferDestination();
        bestOfferDestinationPage.clickDatePicker();
        bestOfferDestinationPage.selectStartDate();
        bestOfferDestinationPage.selectEndDate();
        bestOfferDestinationPage.clickSubmitButton();
        bestOfferDestinationPage.titleIsVisible();
        reportScreenshot("screenshotBest", "Best Offers screenshot");
    }
}
