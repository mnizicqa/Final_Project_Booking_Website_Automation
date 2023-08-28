package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".a83ed08757.c21c56c305.f38b6daa18.d691166b09.ab98298258.deab83296e.f4552b6561")
    WebElement closeButton;

    @FindBy(css = "[name='ss']")
    WebElement inputDestination;

    @FindBy(css = ".d606c76c5a")
    WebElement dateSelector;

    @FindBy(css = "[data-date='2023-08-18']")
    WebElement startDate;

    @FindBy(css = "[data-date='2023-08-25']")
    WebElement endDate;

    @FindBy(css =".d67edddcf0")
    WebElement guestsAndRoomsNumberDropdown;

    @FindBy(xpath = "//*[@id='indexsearch']/div[2]/div/form/div[1]/div[3]/div/div/div/div/div[1]/div[2]/button[2]")
    WebElement guestsNumber;

    @FindBy(xpath = "//*[@id='indexsearch']/div[2]/div/form/div[1]/div[3]/div/div/div/div/div[3]/div[2]/button[2]")
    WebElement roomsNumber;

    @FindBy(css = ".a83ed08757.c21c56c305.bf0537ecb5.ab98298258.d2529514af.af7297d90d.d285d0ebe9")
    WebElement doneButton;

    @FindBy(css = "[type='submit']")
    WebElement submitButton;

    @FindBy(xpath = "//h1[contains(text(), 'Kopaonik')]")
    WebElement propertyTitle;

    @FindBy(css = ".input_newsletter_subscription_to")
    WebElement inputNewsletter;

    @FindBy(css = ".emk_footer_banner_block")
    WebElement subscribeSection;

    @FindBy(css = ".d65598d5f9")
    List<WebElement> images;

    @FindBy(css = "#newsletter_button_footer")
    WebElement subscribeButton;

    @FindBy(css = "[role='status']")
    WebElement successMessage;

    @FindBy(css = "[data-testid='destination-postcards-firstrow']")
    WebElement trendingDestinationsSection;

    @FindBy(css = ".f395e522bd.af0c2122fa>a:first-child")
    WebElement trendingDestination;

    @FindBy(css = "[data-qmab-component-id='27']")
    WebElement exploreBosniaSection;

    @FindBy(css = "[data-qmab-component-id='27'] li:nth-child(3)")
    WebElement exploreBosniaDestination;

    @FindBy(css = "[aria-label='Find Getaway Deals']")
    WebElement bestOfferDestinationButton;

    @FindBy(xpath = "//*[@id='b2indexPage']/div[2]/div/header/nav[1]/div[2]/span[2]/button")
    WebElement changeLanguageButton;

    @FindBy(xpath = "//*[@id='b2indexPage']/div[21]/div/div/div/div/div[2]/div/div[1]/div/div/ul[1]/li[3]/button")
    WebElement confirmSelectedLanguageButton;

    public void closeModal() throws Exception {
        click(closeButton, "Modal close button " + closeButton + " has been clicked");
    }

    public void enterDestination(String destination) throws Exception {
        typeText(inputDestination, destination, "Destination " + destination + " has been typed into the field!");
    }

    public void clickDatePicker() throws Exception {
        click(dateSelector, "Datepicker " + dateSelector + " has been clicked");
    }

    public void selectStartDate() throws Exception {
        click(startDate, "Start Date " + startDate + " has been clicked");
    }

    public void selectEndDate() throws Exception {
        click(endDate, "End Date " + endDate + " has been clicked");
    }

    public void selectGuestAndRoomsNumber() throws Exception {
        click(guestsAndRoomsNumberDropdown, "Guests and Rooms number dropdown " + guestsAndRoomsNumberDropdown + " has been clicked");
        click(guestsNumber, "Guests Number " + guestsNumber + " has been clicked");
        click(guestsNumber, "Guests Number " + guestsNumber + " has been clicked");
        click(roomsNumber, "Rooms Number " + roomsNumber + " has been clicked");
    }

    public void clickDone() throws Exception {
        click(doneButton, "Done Button " + doneButton + " has been clicked!");
    }

    public void clickSubmitButton() throws Exception {
        click(submitButton, "Submit Button " + submitButton + " has been clicked");
    }

    public void titleIsVisible() {
        assertTrue(propertyTitle, "Title " + propertyTitle + " is shown");
    }

    public void scrollToSubscribeSection() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", subscribeSection);
    }

    public void enterEmailAddress(String email) throws Exception {
        typeText(inputNewsletter, email, "Email " + email + " has been typed into the field!");
    }

    public void higlightNewsletterInputField() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style','background:yellow; border: 2px solid red');", inputNewsletter);
    }

    public void clickSubscribeButton() throws Exception {
        click(subscribeSection, "Subscribe Button " + subscribeButton + " has been clicked!");
    }

    public void checkSuccessMessage() {
        Assert.assertTrue(!successMessage.isDisplayed());
    }

    public void scrollToTrendingDestinationsSection() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", trendingDestinationsSection);
    }

    public void checkImagesNumber(String imagesNum) {
        assertEQ(String.valueOf(images.size()), imagesNum, "Images Count!");
    }

    public void selectTrendingDestination() throws Exception {
        click(trendingDestination, "Trending destination " + trendingDestination + " has been clicked!");
    }

    public void scrollToExploreBosniaSection() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", exploreBosniaSection);
    }

    public void selectBosniaDestination() throws Exception {
        click(exploreBosniaDestination, "Destination " + exploreBosniaDestination + " has been clicked!");
    }

    public void selectBestOfferDestination() throws Exception {
        click(bestOfferDestinationButton, "Best Offer Destination Button " + " has been clicked");
    }

    public void selectDesiredLanguage() throws Exception {
        click(changeLanguageButton, "Change Language Button" + " has been clicked");
    }

    public void confirmSelectedLanguage() throws Exception {
        click(confirmSelectedLanguageButton, "Desired Language Button" + " has been clicked");
    }
}
