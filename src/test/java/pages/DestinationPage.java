package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class DestinationPage extends BasePage{

    public DestinationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css= "h1")
    WebElement trendingDestinationTitle;

    @FindBy(css = "[data-date='2023-08-18']")
    WebElement startDate;

    @FindBy(css = "[data-date='2023-08-25']")
    WebElement endDate;

    @FindBy(css = "[type='submit']")
    WebElement submitButton;

    @FindBy(css = ".d8f77e681c")
    WebElement numberOfResults;

    @FindBy(css = "h1")
    WebElement title;

    @FindBy(css = ".a53cbfa6de.ac9267e216.f801a9f549>div>div:nth-child(2)")
    WebElement sliderLeft;

    @FindBy(css = ".a53cbfa6de.ac9267e216.f801a9f549>div>div:nth-child(4)")
    WebElement sliderRight;

    public void verifyTrendingDestinationTitle() {
        assertTrue(trendingDestinationTitle, "Destination Title " + trendingDestinationTitle + " is shown");
    }

    public void verifyTrendingDestinationTitleColor() {
        String color = trendingDestinationTitle.getCssValue("color");
        String hexColor = Color.fromString(color).asHex();
        Assert.assertTrue(hexColor.equalsIgnoreCase("#1a1a1a") || hexColor.equalsIgnoreCase("#262626"));
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

    public void selectPriceRange() {
        Actions action = new Actions(driver);
        action.moveToElement(sliderLeft).dragAndDropBy(sliderLeft,85, 0).build().perform();
        action.moveToElement(sliderRight).dragAndDropBy(sliderRight,-65, 0).build().perform();
    }

    public void verifyNumberOfResults () {
        Assert.assertEquals(numberOfResults.getText(), title.getText());
    }

}
