package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResultsPage {
    @FindBy(xpath = "*/head/title")
    private WebElement title;

    public String getTitleText() {
        return title.getAttribute("textContent");
    }

    public ResultsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
