import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class NavigationTest {

    WebDriver driver;
    @BeforeMethod
    public void beforeMethod() {

        // set path of Chromedriver executable
        System.setProperty("webdriver.chrome.driver",
                "src/test/resources/drivers/chromedriver.exe");

        // initialize new WebDriver session
        driver = new ChromeDriver();
    }

    @Test
    public void navigateToAUrl() {
        // navigate to the web site
        driver.get("https://www.amazon.co.uk/");
        // Validate page title
        System.out.println("Title = " + driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "Amazon.co.uk: Low Prices in Electronics, Books, Sports Equipment & more");
    }
    @AfterMethod
    public void afterMethod() {

        // close and quit the browser
        driver.quit();
    }
}