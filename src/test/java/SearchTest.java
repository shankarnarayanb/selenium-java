import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class SearchTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver",
                "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.amazon.co.uk/");
    }

    @Test
    public void searchProduct() {
        // find search box and enter search string
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Phones");
        WebElement searchButton =
                driver.findElement(By.cssSelector("[value=\"Go\"]"));
        searchButton.click();
        System.out.println("Title = " + driver.getTitle());
        assertThat(driver.getTitle())
                .isEqualTo("Amazon.co.uk: Phones");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
