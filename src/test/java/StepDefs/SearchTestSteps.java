package StepDefs;

import PageObjects.HomePage;
import PageObjects.PageObjectManager;
import PageObjects.ResultsPage;
import cucumber.api.java.After;
import cucumber.api.java8.En;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class SearchTestSteps implements En {
    private WebDriver driver;
    private PageObjectManager pageObjectManager;
    private HomePage homePage;
    private ResultsPage resultsPage;

    /**
     * This is the Glue Code using Java 8's Lambdas - the alternative to this is the standard @Given, @When approach.
     * Parameters are passed dynamically to the methods
     * The parameters are taken from the feature file using Regular Expression matching.
     */
    public SearchTestSteps() {
        Given("^the user is on the homepage$", this::goToHomePage);
        When("^they search for \"([^\"]*)\"$", this::search);
        Then("^the results page' title should be \"([^\"]*)\"$", this::compareTitle);
    }

    private void goToHomePage() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.amazon.co.uk/");

        pageObjectManager = new PageObjectManager(driver);
        homePage = pageObjectManager.getHomePage();
    }

    private void search(String searchTerm) {
        homePage.enterIntoSearchBox(searchTerm);
        homePage.clickSearchButton();
    }

    private void compareTitle(String expectedValue) {
        resultsPage = pageObjectManager.getResultsPage();
        assertThat(resultsPage.getTitleText()).isEqualTo(expectedValue);
    }

    //Make sure to import cucumber.api.java.After; and not the JUnit @After, otherwise this will not run.
    @After
    public void closeDriver() {
        driver.close();
    }
}
