package StepDefinition;

//import StepDefinition

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/java/resources/MultipleTicketCreation.feature",  // Relative path to the feature file
    glue = "src/test/java/StepDefinition/multipleTicketCreationTestRunner.java",  // Package name containing step definitions
    plugin = {"pretty", "html:target/cucumber-reports"},  // Report generation
    monochrome = true  // Cleaner console output
    )
 
public class multipleTicketCreationTestRunner {
	
}
