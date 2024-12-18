package StepDefinition;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import Pages.LoginPage;
import Utilities.ReadingPropertiesFile;
import base.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class login {
	
	ReadingPropertiesFile propObj= new ReadingPropertiesFile();
	LoginPage login;
	
	@Given("User opens the application")
	public void user_opens_the_application() throws IOException {
		
//		String browser = propObj.readFromPropertiesFile("browser");
//		WebDriverManager.chromedriver().setup();
//		// Setting  options to false so it will run without headless mode
//		// If we make it true then it will run the test code in headless mode
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--remote-allow-origins=*");
//		//options.setHeadless(false);
//		driver = new ChromeDriver(options);
//		driver.manage().window().maximize();
//		
//		driver.get(propObj.readFromPropertiesFile("url"));
	    
	}

//	@When("User enters username and password")
//	public void user_enters_username_and_password() throws IOException {
//		login=new LoginPage(Hooks.driver);
//		login.fillingLoginDetails("Mkumar6", "Default@1234");
//
//	}
	
	@When("^User enters \"([^\"]*)\" and \"([^\"]*)\"$")
    public void user_enters_credentials(String username, String password) throws IOException {
		login=new LoginPage(Hooks.driver);
		login.fillingLoginDetails(username, password);
    
    }

	@And("User clicks on the submit button")
	public void user_clicks_on_the_submit_button() {
	   
	}

	@Then("User lands to homepage")
	public void user_lands_to_homepage() {
	  
		String currentURL= Hooks.driver.getCurrentUrl();
		String expectedURL= "https://nycdoedev2.service-now.com/com.glideapp.servicecatalog_cat_item_guide_view.do?v=1&sysparm_initial=true&sysparm_guide=1a602a171bfb2c10ec6254ea234bcbf6";
		Assert.assertEquals(currentURL, expectedURL, "Not landed to home page");
	}
}
