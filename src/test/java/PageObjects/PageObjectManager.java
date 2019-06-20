package PageObjects;

import org.openqa.selenium.WebDriver;

/**
 * The PageObjectManager is required to initialise the page objects with the driver when needed.
 * Without this, the page objects would be null.
 * The manager simply initialises the page objects with their default constructors if they're null, and returns the object if they're not null
 */
public class PageObjectManager {

    private WebDriver driver;

    private HomePage homePage;

    private ResultsPage resultsPage;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() {
        return (homePage == null) ? homePage = new HomePage(driver) : homePage;
    }

    public ResultsPage getResultsPage() {
        return (resultsPage == null) ? resultsPage = new ResultsPage(driver) : resultsPage;
    }
}