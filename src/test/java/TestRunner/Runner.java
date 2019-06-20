package TestRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

/**
 * This is the Runner class of Cucumber. This class tells the system to run in a Junit context with Cucumber using @RunWith(Cucumber.class)
 * The @CucumberOptions annotation sets up cucumber and tells the location of the features and step defs (glue)
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/Features", glue = {"StepDefs/"})
public class Runner {
    public WebDriver driver;
}