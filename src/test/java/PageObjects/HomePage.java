package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Following Selenium's Page Object Model, this class represents the page.
 * Any call for data from the page, or any interaction with the page should be done by acting on this object.
 * The parametised constructor HomePage(WebDriver driver) sets up the page when called with the driver context.
 * The elements using @FindBy are null until they are called - they are then initialised by the driver.
 */
public class HomePage extends AbstractPageObject {
    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchBox;

    @FindBy(css = "[type=submit]")
    private WebElement searchButton;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void enterIntoSearchBox(String searchTerm) {
        searchBox.sendKeys(searchTerm);
    }

    public void clickSearchButton() {
        searchButton.click();
    }
}
