package StepDefinition;

//import StepDefinition
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
 
@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/java/resources/createTicketScenarioOutline.feature",  // Relative path to the feature file
    glue = "StepDefinition",  // Package name containing step definitions
    plugin = {"pretty", "html:target/cucumber-reports"},  // Report generation
    monochrome = true  // Cleaner console output
    )
 
public class loginTestRunner {
	
}
