package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BestOfferDestinationPage extends BasePage {

    public BestOfferDestinationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".dealspage-ufi-cards")
    WebElement seasonalOfferDestination;

    @FindBy(css = ".deals-ufi-card__helper")
    List<WebElement> seasonOffersImages;

    @FindBy(css= "#deal-ufi-name-2")
    WebElement seasonalOfferDestinationName;

    @FindBy(css = ".d606c76c5a")
    WebElement dateSelector;

    @FindBy(css = "[data-date='2023-08-27']")
    WebElement startDate;

    @FindBy(css = "[data-date='2023-08-29']")
    WebElement endDate;

    @FindBy(css = "[type='submit']")
    WebElement submitButton;

    @FindBy(css = "h1")
    WebElement propertyTitle;

    public void scrollToSeasonalOfferSection() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", seasonalOfferDestination);
    }

    public void checkSeasonImagesNumber(String seasonalImagesNum) {
        assertEQ(String.valueOf(seasonOffersImages.size()), seasonalImagesNum, "Seasonal Images Count!");
    }

    public void selectSeasonalOfferDestination() throws Exception {
        click(seasonalOfferDestinationName, "Seasonal Offer Destination" + seasonalOfferDestinationName + " has been clicked!");
    }

    public void clickDatePicker() throws Exception {
        click(dateSelector, "Datepicker " + dateSelector + " has been clicked!");
    }
    public void selectStartDate() throws Exception {
        click(startDate, "Start Date " + startDate + " has been clicked!");
    }

    public void selectEndDate() throws Exception {
        click(endDate, "End Date " + endDate + " has been clicked!");
    }

    public void clickSubmitButton() throws Exception {
        click(submitButton, "Submit Button " + submitButton + " has been clicked!");
    }

    public void titleIsVisible() {
        assertTrue(propertyTitle, "Property title " + propertyTitle + " is shown");
    }
}
